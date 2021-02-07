package youngerFAQ.commons.views;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import youngerFAQ.commons.dbfunction.DBFunctions;
import youngerFAQ.commons.sub.AnswerMesList;
import youngerFAQ.commons.sub.AnswerMes;
import youngerFAQ.commons.sub.ProblemMes;
import youngerFAQ.commons.sub.AnswerCommentMesList;

@WebServlet("/problemDetailed.jsp")
public class ProblemDetailed extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6631540377371884951L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBFunctions dbFunction=new DBFunctions();
		String proId=request.getParameter("proId");
		dbFunction.addProblemVisitNumber(proId);
		ProblemMes problemMes=dbFunction.getProblemMes(proId);
		
		
		AnswerMesList answerMesList=dbFunction.getAnswerListToProId(proId);
		ArrayList<AnswerCommentMesList> allProComment=new ArrayList<AnswerCommentMesList>(answerMesList.length());
		
		answerMesList.setFirst();
		for(int i=0;i<answerMesList.length();i++){
			
			String ansIdTemp=((AnswerMes)answerMesList.currValue()).getAnsId();
			allProComment.add(dbFunction.getCommentByAnsId(ansIdTemp));
			answerMesList.next();
			
		}
		AnswerMes bestMes=dbFunction.getAnswerMes(problemMes.getProBestAnsId());
		
		
		request.setAttribute("problemMes", problemMes);
		request.setAttribute("bestAnsMes", bestMes);
		request.setAttribute("answerMesList", answerMesList);
		request.setAttribute("allProComment",allProComment);
		
		request.getRequestDispatcher("/WEB-INF/jsp/question.jsp").forward(request, response);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	
	
}

