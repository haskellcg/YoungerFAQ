package youngerFAQ.commons.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import youngerFAQ.commons.dbfunction.DBFunctions;
import youngerFAQ.commons.sub.UserMes;


@WebServlet("/register.jsp")
@MultipartConfig
public class Register extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7276851805428626057L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		DBFunctions dbFunction=new DBFunctions();
		String userName=request.getParameter("username");
		if(dbFunction.userNameIsExist(userName)==1){
			
			String errorMes="对不起，您的用户名已存在，请重选择一个用户名！";
			request.setAttribute("errorMes", errorMes);
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
			
		}else{
			UserMes temp=new UserMes();
			temp.setUserName(request.getParameter("username"));
			temp.setDearName(request.getParameter("dearname"));
			temp.setPassword(request.getParameter("password"));
			temp.setSex(request.getParameter("sex").trim().equals("男")?true:false);
			temp.setEmail(request.getParameter("mail"));
			temp.setCellNumber(request.getParameter("cellphone"));
			temp.setQqnumber(request.getParameter("qq"));
			temp.setWorkName(request.getParameter("work"));
			temp.setAddress(request.getParameter("address"));
			temp.setBirthday(request.getParameter("birthyear")+"-"+request.getParameter("birthmonth")+"-"+request.getParameter("birthdy"));
			temp.setAdministrator(false);
			
			Part part=request.getPart("headpic");
			String realPath=request.getServletContext().getRealPath("/");
			String filename=(part.getSize()==0?"default":part.getName()+userName);
			temp.setHeadPic("upload/"+filename);
			if(!filename.equals("default"))
					part.write(realPath+"/upload/"+filename);
			
			String userId=dbFunction.insertUserMes(temp);
			request.getSession().setAttribute("userName", userName);
			request.getSession().setAttribute("userId", userId);
			
			
			request.setAttribute("successMes", "恭喜您成功注册为Younger知道用户！");
			request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
		} 
	}
}
