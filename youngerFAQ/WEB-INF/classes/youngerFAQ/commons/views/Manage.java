package youngerFAQ.commons.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import youngerFAQ.commons.dbfunction.DBFunctions;
import youngerFAQ.commons.sub.ProblemMesList;
import youngerFAQ.commons.sub.UserMes;
import youngerFAQ.commons.sub.UserMesList;



@WebServlet("/manage.jsp")
public class Manage extends  HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6824597135647682662L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		DBFunctions dbFunction=new DBFunctions();
		String userName=(String)request.getSession().getAttribute("userName");
		UserMes userMes=dbFunction.getUserMes(dbFunction.getUserId(userName));
		if(userMes.isAdministrator()==true){
			
			UserMesList userMesList=dbFunction.getUserMesListByOrder();
			ProblemMesList problemMesList=dbFunction.getAllProblemMes();
			
			request.setAttribute("userMesList", userMesList);
			request.setAttribute("problemMesList", problemMesList);
			request.getRequestDispatcher("/WEB-INF/jsp/manage.jsp").forward(request, response);
			
		}else{
			
			String errorMes="对不起，您不是管理员，无法进入管理页面!";
			request.setAttribute("error", errorMes);
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String searchUser=request.getParameter("username");
		String searchProblem=request.getParameter("problemTitle");
		
		DBFunctions dbFunction=new DBFunctions();
		if(searchUser!=null){
			
			UserMesList userMesList=dbFunction.getUserMesListByKey(searchUser);
			ProblemMesList problemMesList=dbFunction.getAllProblemMes();
			
			request.setAttribute("userMesList", userMesList);
			request.setAttribute("problemMesList", problemMesList);
			
			request.getRequestDispatcher("/WEB-INF/jsp/manage.jsp").forward(request, response);
			
		}else{
			
			ProblemMesList problemMesList=dbFunction.getProblemMesByKey(searchProblem);
			UserMesList userMesList=dbFunction.getUserMesListByOrder();
			
			request.setAttribute("userMesList", userMesList);
			request.setAttribute("problemMesList", problemMesList);
			
			request.getRequestDispatcher("/WEB-INF/jsp/manage.jsp").forward(request, response);
		}
		
	}
	
}
