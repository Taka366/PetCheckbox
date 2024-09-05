package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ChangeLogic;
import model.Pet;

/**
 * Servlet implementation class ChangeServlet
 */
@WebServlet("/ChangeServlet")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String days = request.getParameter("days");
		String time = request.getParameter("time");
		String action = request.getParameter("action");
		String timeframe = request.getParameter("timeframe");
		String name = request.getParameter("name");
		
		//修正用Petインスタンスの作成
		Pet changeLog = new Pet(id,days,time,action,timeframe,name);
		
		//履歴修正BOの呼び出し
		ChangeLogic change = new ChangeLogic();
		change.change(changeLog);
		
		//TodayServletへフォワードし、画面上の履歴を更新
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WeekServlet");
		dispatcher.forward(request, response);
	}
}