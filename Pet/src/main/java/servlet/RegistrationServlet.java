package servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Pet;
import model.Registration;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String days = request.getParameter("days");
		String time = request.getParameter("time");
		String action[] = request.getParameterValues("action");
		List<String> actionList = Arrays.asList(action);
		String timeframe[] = request.getParameterValues("timeframe");
		List<String> timeframeList = Arrays.asList(timeframe);
		String name[] = request.getParameterValues("name");
		List<String> nameList = Arrays.asList(name);
		
		//テーブル登録の呼び出し
		Pet pet = new Pet(days,time,actionList,timeframeList,nameList);
		Registration registration = new Registration();
		registration.execute(pet);
			
		//TodayServletへフォワードし、画面上の履歴を更新
		RequestDispatcher dispatcher = request.getRequestDispatcher("/TodayServlet");
		dispatcher.forward(request, response);
	}
}