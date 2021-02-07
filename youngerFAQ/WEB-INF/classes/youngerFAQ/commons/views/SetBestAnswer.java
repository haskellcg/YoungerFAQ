package youngerFAQ.commons.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import youngerFAQ.commons.dbfunction.DBFunctions;


@WebServlet("/setBestAnswer.jsp")
public class SetBestAnswer extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2473277203761426527L;

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
		DBFunctions  dbFunction=new DBFunctions();
		String ansId=request.getParameter("ansId");
		
		dbFunction.setBestAnswer(ansId);
		String proId=(dbFunction.getAnswerMes(ansId)).getAnsToProId();
		response.sendRedirect("problemDetailed.jsp?proId="+proId);
	}
	
}
