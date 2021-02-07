package youngerFAQ.commons.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import youngerFAQ.commons.dbfunction.DBFunctions;
import youngerFAQ.commons.sub.UserMes;

@WebServlet("/login.jsp")
public class Login extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2116483498996475794L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBFunctions dbFunction=new DBFunctions();
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		if(dbFunction.userNameIsExist(userName)==1){
			
			UserMes userMes=dbFunction.getUserMes(dbFunction.getUserId(userName));
			String realPassword=userMes.getPassword();
			if(password.equals(realPassword)){
				String userId=userMes.getUserId();
				request.getSession().setAttribute("userName", userName);
				request.getSession().setAttribute("userId", userId);
				
				response.sendRedirect("index.jsp");
			}else{
				String errorMes="输入的密码不正确，请检查是否输入正确！";
				request.setAttribute("errorMes", errorMes);
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			}
				
		}else{
			String errorMes="用户名不存在，请确认用户名是否输入正确！";
			request.setAttribute("errorMes", errorMes);
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
	}
	
}
