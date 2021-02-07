package youngerFAQ.commons.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import youngerFAQ.commons.dbfunction.DBFunctions;
import youngerFAQ.commons.sub.ProblemMesList;

@WebServlet("/index.jsp")
public class IndexView extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3898244244223307287L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub\
		System.out.println(request.getServletContext().getRealPath("/"));
		DBFunctions dbFunction=new DBFunctions();
		
		ProblemMesList proList=dbFunction.getAllProblemMes();
		ProblemMesList proSolveList=dbFunction.getSolveProblemMes();
		ProblemMesList proSolvedList=dbFunction.getSolvedProblemMes();
		ProblemMesList proScienceList=dbFunction.getKindOfProblemMes("科学教育");
		ProblemMesList proFunList=dbFunction.getKindOfProblemMes("娱乐休闲");
		ProblemMesList proLifeList=dbFunction.getKindOfProblemMes("生活");
		ProblemMesList proSportList=dbFunction.getKindOfProblemMes("体育运动");
		ProblemMesList proPoliticsList=dbFunction.getKindOfProblemMes("时政");
		
		request.setAttribute("proList", proList);
		request.setAttribute("proSolveList", proSolveList);
		request.setAttribute("proSolvedList", proSolvedList);
		request.setAttribute("proScienceList", proScienceList);
		request.setAttribute("proFunList", proFunList);
		request.setAttribute("proLifeList", proLifeList);
		request.setAttribute("proSportList", proSportList);
		request.setAttribute("proPoliticsList", proPoliticsList);
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request,response);
	}
	

}
