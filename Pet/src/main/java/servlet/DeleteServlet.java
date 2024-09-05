package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Del;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
				request.setCharacterEncoding("UTF-8");
				int id = Integer.parseInt(request.getParameter("deleteId"));
				
		//テーブル登録の呼び出し
				Del delete = new Del();
				delete.delete(id);
					
		//TodayServletへフォワードし、画面上の履歴を更新
				RequestDispatcher dispatcher = request.getRequestDispatcher("/TodayServlet");
				dispatcher.forward(request, response);
	}
}