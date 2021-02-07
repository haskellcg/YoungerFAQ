package youngerFAQ.commons.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import youngerFAQ.commons.dbfunction.DBFunctions;
import youngerFAQ.commons.sub.AnswerMes;

@WebServlet("/answerQuestion.jsp")
public class AnswerQuestion extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8477723373105242083L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBFunctions dbFunction=new DBFunctions();
		String ansContent=request.getParameter("response");
		String ansToProId=request.getParameter("proId");
		String ansPerson=(String)request.getSession().getAttribute("userName");
		if(ansPerson==null){
			response.sendRedirect("login.jsp");
		}else{
			AnswerMes ansMes=new AnswerMes();
			ansMes.setAnsToProId(ansToProId);
			ansMes.setAnsPersonname(ansPerson);
			ansMes.setAnsContent(ansContent);
			dbFunction.insertAnswerMes(ansMes);
			
			response.sendRedirect("problemDetailed.jsp?proId="+ansToProId);
		}
	}
}
