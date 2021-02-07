package youngerFAQ.commons.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import youngerFAQ.commons.dbfunction.DBFunctions;


@WebServlet("/deleteProblem.jsp")
public class DeleteProblem extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6290434172109756412L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBFunctions dbFunction=new DBFunctions();
		String proId=request.getParameter("proId");
		dbFunction.deleteProblemMes(proId);
		dbFunction.deleteAnsCmtToProId(proId);
		
		String successMes="成功删除该问题！";
		request.setAttribute("successMes", successMes);
		request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
	
	
}
