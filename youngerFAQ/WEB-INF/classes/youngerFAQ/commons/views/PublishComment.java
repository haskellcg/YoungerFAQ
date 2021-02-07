package youngerFAQ.commons.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import youngerFAQ.commons.dbfunction.DBFunctions;
import youngerFAQ.commons.sub.AnswerCommentMes;


@WebServlet("/publishComment.jsp")
public class PublishComment extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1399105722029284603L;

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
		
		DBFunctions dbFunction=new DBFunctions();
		String commentContent=request.getParameter("comment");
		String commentAnsId=request.getParameter("ansId");
		String commentPublishId=(String)request.getSession().getAttribute("userId");
		
		AnswerCommentMes comment=new AnswerCommentMes();
		comment.setCommentContent(commentContent);
		comment.setCommentAnsId(commentAnsId);
		comment.setCommentPublishId(commentPublishId);
		
		dbFunction.insertAnswerCommentMes(comment);
		String proId=(dbFunction.getAnswerMes(commentAnsId)).getAnsToProId();
		
		response.sendRedirect("problemDetailed.jsp?proId="+proId);
		
	}
	
	
}
