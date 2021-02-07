package youngerFAQ.commons.views;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import youngerFAQ.commons.dbfunction.DBFunctions;
import youngerFAQ.commons.sub.AnswerCommentMesList;
import youngerFAQ.commons.sub.AnswerMesList;
import youngerFAQ.commons.sub.ProblemMesList;
import youngerFAQ.commons.sub.UserMes;

@WebServlet("/userhome.jsp")
public class UserHome extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1873781880932977042L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId =request.getParameter("userId");

		if (userId.equals("null")) {
			response.sendRedirect("index.jsp");
		}else if(userId.equals("")){
			request.setAttribute("errorMes", "该用户已被删除!");
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
			}else{
				
				DBFunctions dbFunction = new DBFunctions();
				UserMes userMes = dbFunction.getUserMes(userId);
				ProblemMesList proSolveList = dbFunction
							.getSolveProblemMesByID(userId);
				ProblemMesList proSolvedList = dbFunction
							.getSolvedProblemMesByID(userId);
				AnswerMesList answerMesList = dbFunction
							.getAnswerMesListToUserId(userId);
				AnswerCommentMesList commentToOtherList = dbFunction
							.getCommentToOtherListByID(userId);
				AnswerCommentMesList commentToSelfList = dbFunction
							.getCommentToSelfListByID(userId);

				request.setAttribute("userMes", userMes);
				request.setAttribute("proSolveList", proSolveList);
				request.setAttribute("proSolvedList", proSolvedList);
				request.setAttribute("answerMesList", answerMesList);
				request.setAttribute("commentToOtherList", commentToOtherList);
				request.setAttribute("commentToSelfList", commentToSelfList);
				request.getRequestDispatcher("/WEB-INF/jsp/userhome.jsp").forward(request, response);
			}
			
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
