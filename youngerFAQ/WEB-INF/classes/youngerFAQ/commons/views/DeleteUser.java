package youngerFAQ.commons.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import youngerFAQ.commons.dbfunction.DBFunctions;
import youngerFAQ.commons.sub.UserMes;


@WebServlet("/deleteUser.jsp")
public class DeleteUser extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6116834354437357549L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        DBFunctions dbFunction=new DBFunctions();
        String userId=request.getParameter("userId");
        UserMes userMes=dbFunction.getUserMes(userId);
        if(userMes.isAdministrator()==true){
        	
        	String errorMes="对不起，您无法删除管理员！";
        	request.setAttribute("errorMes", errorMes);
        	request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        	
        }else{
        	
        	dbFunction.deleteUserMes(userId);
        	String successMes=userMes.getUserName()+"账户已经被从数据库中成功删除！";
        	request.setAttribute("successMes", successMes);
        	request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
        }
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
}
