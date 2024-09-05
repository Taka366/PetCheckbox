package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ActionEntry;
import model.ActionEntryLogic;
import model.NameEntry;
import model.NameEntryLogic;
import model.Pet;
import model.TimeframeEntry;
import model.TimeframeEntryLogic;
import model.TodayLogic;

/**
 * Servlet implementation class TodayServlet
 */
@WebServlet("/TodayServlet")
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TodayLogic.executeを実行
		TodayLogic todayLogic = new TodayLogic();
		List<Pet> todayLog = todayLogic.execute();
		
		//ActionEntryLogic.excuteを実行
		ActionEntryLogic actionEntry = new ActionEntryLogic();
		List<ActionEntry> action = actionEntry.execute();
		
		//TimeframeEntryLogic.excuteを実行
		TimeframeEntryLogic timeframeEntry = new TimeframeEntryLogic();
		List<TimeframeEntry> timeframe = timeframeEntry.execute();
		
		//NameEntryLogic.excuteを実行
		NameEntryLogic nameEntry = new NameEntryLogic();
		List<NameEntry> name = nameEntry.execute();
		
		//リクエストスコープに当日の履歴を保存
		request.setAttribute("todayLog",todayLog);
		
		//リクエストスコープに「実施内容」の項目リストを保存
		request.setAttribute("action",action);
		
		//リクエストスコープに「実施時間帯」の項目リストを保存
		request.setAttribute("timeframe",timeframe);
		
		//リクエストスコープに「実施者」の項目リストを保存
		request.setAttribute("name",name);
		
		// Todayjsp呼び出し
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/today.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}