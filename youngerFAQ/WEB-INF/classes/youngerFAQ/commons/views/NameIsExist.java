package youngerFAQ.commons.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import youngerFAQ.commons.dbfunction.DBFunctions;

@WebServlet("/UserCheck")
public class NameIsExist extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5967276480996541887L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("userName");
		request.setCharacterEncoding("utf-8");
		DBFunctions dbFunction=new DBFunctions();
		String userName=request.getParameter("username");
		String isExist=null;
		if(userName.equals(username))
			isExist="true";
		else if(dbFunction.userNameIsExist(userName)==1)
			isExist="false";
		else
			isExist="true";
		response.getWriter().write(isExist);
		
		
	}
}
