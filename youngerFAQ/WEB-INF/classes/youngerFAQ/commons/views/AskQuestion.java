package youngerFAQ.commons.views;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import youngerFAQ.commons.dbfunction.DBFunctions;
import youngerFAQ.commons.sub.ProblemMes;

@WebServlet("/askQuestion.jsp")
public class AskQuestion extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7185392718884732265L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		if(request.getSession().getAttribute("userName")==null){
			
			response.sendRedirect("login.jsp");
			
		}else{
			
			request.getRequestDispatcher("/WEB-INF/jsp/askQuestion.jsp").forward(request, response);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String proTitle=request.getParameter("textfield4");
		String proKindOf=request.getParameter("select");
		String proContent=request.getParameter("textarea");
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String proPublishDate=sdf.format(date);
		String proPublisher=(String)request.getSession().getAttribute("userName");
		
		
		ProblemMes problemMes=new ProblemMes();
		problemMes.setProTitle(proTitle);
		problemMes.setProContent(proContent);
		problemMes.setProKindOf(proKindOf);
		problemMes.setProPublishDate(proPublishDate);
		problemMes.setProBestAnsId("0");
		problemMes.setProPublisher(proPublisher);
		problemMes.setProVisitNumber(0);
		problemMes.setEnd(false);
		
		
		DBFunctions dbFunction=new DBFunctions();
		String proId=dbFunction.insertProblemMes(problemMes);
		request.setAttribute("proId",proId);
		
		response.sendRedirect("problemDetailed.jsp?proId="+proId);
	}

}
