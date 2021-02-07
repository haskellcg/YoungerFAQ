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

@WebServlet("/changeUserInfo.jsp")
@MultipartConfig
public class ChangeUserInfo extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2801848852077401453L;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBFunctions dbFunction=new DBFunctions();
		String visitUserId=(String)request.getSession().getAttribute("userId");
		String beVisitedUserId=request.getParameter("userId");
		if(visitUserId!=null && beVisitedUserId.equals(visitUserId)){
			UserMes userMes=dbFunction.getUserMes(beVisitedUserId);
			request.setAttribute("userMes", userMes);
			request.getRequestDispatcher("/WEB-INF/jsp/changeUserInfo.jsp").forward(request, response);
		}
		else{
			request.setAttribute("errorMes", "无法修改他人信息！");
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DBFunctions dbFunction=new DBFunctions();
		String userName=(String)request.getSession().getAttribute("userName");
		UserMes userMes=dbFunction.getUserMes(dbFunction.getUserId(userName));
		
		String pd=request.getParameter("password");
		if(userMes.getPassword().equals(pd)){
			
			UserMes temp=new UserMes();
			temp.setUserId(userMes.getUserId());
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
			if(part.getSize()==0){
				temp.setHeadPic(userMes.getHeadPic());
			}else{
				temp.setHeadPic("upload/"+part.getName()+request.getParameter("username"));
				part.write(realPath+"/upload/"+part.getName()+request.getParameter("username"));
			}
			
			
			dbFunction.alterUserMes(temp);
			
			
			String successMes="成功修改个人信息！";
			request.setAttribute("successMes", successMes);
			request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
		
		}else{
			String oldPassword=request.getParameter("password2");
			if(userMes.getPassword().equals(oldPassword)){
				UserMes temp=new UserMes();
				temp.setUserId(userMes.getUserId());
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
				if(part.getSize()==0){
					temp.setHeadPic(userMes.getHeadPic());
				}else{
					temp.setHeadPic("upload/"+part.getName()+request.getParameter("username"));
					part.write(realPath+"/upload/"+part.getName()+request.getParameter("username"));
				}
				
				
				
				dbFunction.alterUserMes(temp);
				String successMes="成功修改个人信息！";
				request.setAttribute("successMes", successMes);
				request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
			}else{
				String errorMes="旧密码不正确，无法修改密码！请确认是否输入正确！";
				request.setAttribute("errorMes", errorMes);
				request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
			}
		}
	}
	
}
