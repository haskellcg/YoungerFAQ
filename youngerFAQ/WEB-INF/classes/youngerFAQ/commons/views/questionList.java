package youngerFAQ.commons.views;
import youngerFAQ.commons.dbfunction.DBFunctions;
import youngerFAQ.commons.sub.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class questionList
 */
@WebServlet("/questionList.jsp")
public class questionList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public questionList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//在主页中通过 问题分类点击或对“更多”的点击  或者是因为搜索而要进入的问题列表界面；
		//根据参数，传递一个ProblemMesList;
		//1.通过搜索值 2.通过分类 3.通过精彩推荐  未解决 已解决 等进入；
		//类型判定值为type all recommend 1 2 3 4 5 solve solved search 没有type值则默认为all
		//type=search 则要从request.getAttribute("search") 获取要搜索的内容 若为空，丁香至all
		DBFunctions dbFunction=new DBFunctions();
		String type=request.getParameter("type");
		ProblemMesList List = null;
		request.setAttribute("type", type);//保存问题类型  为翻页作准备。
		String pa=request.getParameter("pa");//传递页面值
		if(pa!=null)
			request.setAttribute("pa", pa);
		if(type.contentEquals("all"))
		{
			request.setAttribute("type_view","全部");
			 List=dbFunction.getAllProblemMes();
			
		}
		if(type.contentEquals("search"))
		{
			request.setAttribute("type_view","搜索的结果");//type_view用于在表头显示；
			String content=request.getParameter("search");
			if(content==""||content==null)
				List=dbFunction.getAllProblemMes();
			else
			{	List=dbFunction.getProblemMesByKey(content);
			     request.setAttribute("content_search", request.getParameter("search"));
		    }
		}
		if(type.contentEquals("recommend"))
		{
			request.setAttribute("type_view", "精彩推荐");
			List=dbFunction.getAllProblemMes();
			//List=dbFunction.get推荐问题函数
		
		}
		if(type.contentEquals("solve"))
		{
			 request.setAttribute("type_view","待解决");
			 List=dbFunction.getSolveProblemMes();
		}
		if(type.contentEquals("solved"))
		{
			 request.setAttribute("type_view","已解决");
			 List=dbFunction.getSolvedProblemMes();
		}
		if(type.contentEquals("1"))
		{
			 request.setAttribute("type_view","科学教育");
			 List=dbFunction.getKindOfProblemMes("科学教育");
		}
		if(type.contentEquals("2"))
		{
			 request.setAttribute("type_view","娱乐休闲");
			 List=dbFunction.getKindOfProblemMes("娱乐休闲");
		}
		if(type.contentEquals("3"))
		{
			 request.setAttribute("type_view","生活");
			 List=dbFunction.getKindOfProblemMes("生活");
		}
		if(type.contentEquals("4"))
		{
			 request.setAttribute("type_view","体育运动");
			 List=dbFunction.getKindOfProblemMes("体育运动");
		}
		if(type.contentEquals("5"))
		{
			 request.setAttribute("type_view","时政");
			 List=dbFunction.getKindOfProblemMes("时政");
		}
		request.setAttribute("list", List);	
		request.getRequestDispatcher("/WEB-INF/jsp/questionList.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
