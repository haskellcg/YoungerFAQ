package youngerFAQ.commons.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import youngerFAQ.commons.dbfunction.DBFunctions;
import youngerFAQ.commons.sub.ProblemMesList;
import youngerFAQ.commons.sub.UserMesList;

@WebServlet("/SearchIndex")
public class SearchIndex extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3886021837959895611L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("index.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String choice = request.getParameter("choice");
		String searchContent = request.getParameter("search");
		System.out.println("hah2");
		
		if (searchContent.equals("")){
			response.sendRedirect("index.jsp");
		}else{	request.setAttribute("type", "search");
				DBFunctions dbFunction = new DBFunctions();
				if (choice.equals("搜问题")) {
					ProblemMesList list = dbFunction.getProblemMesByKey(searchContent);
					request.setAttribute("list", list);
					System.out.println("hahaha");
					request.setAttribute("type_view", "搜索结果");
					request.getRequestDispatcher("/WEB-INF/jsp/questionList.jsp").forward(request, response);
				} else if (choice.equals("搜人")) {
					UserMesList userMesList = null;
					userMesList = dbFunction.getUserMesListByKey(searchContent);
					System.out.println();
					request.setAttribute("list", userMesList);
					request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp").forward(request, response);
				} else {
					response.sendRedirect("index.jsp");
				}
		}
	}
}