package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ChangeDisplayLogic;
import model.Pet;

/**
 * Servlet implementation class ChangeDisplayServlet
 */
@WebServlet("/ChangeDisplayServlet")
public class ChangeDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		int changeId = Integer.parseInt(request.getParameter("changeId"));
		
		//修正対象IDの情報を取得
		ChangeDisplayLogic change = new ChangeDisplayLogic();
		List<Pet> log = change.excute(changeId);
		
		//リクエストスコープに修正対象IDの情報を保存
		request.setAttribute("log",log);
		
		//changeDisplayjsp呼び出し
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/changeDisplay.jsp");
		dispatcher.forward(request, response);
	}
}