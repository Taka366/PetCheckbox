<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>履歴確認</title>
</head>
<body>
	<h1>履歴確認</h1>
	<table border="1" id="petTable" class="tablesorter">
		<thead>
			<tr>
				<th onclick="sortTable(0)">ID</th>
				<th onclick="sortTable(1)">実施日</th>
				<th onclick="sortTable(2)">実施時間</th>
				<th onclick="sortTable(3)">実施内容</th>
				<th onclick="sortTable(4)">実施時間帯</th>
				<th onclick="sortTable(5)">実施者</th>
			</tr>
		</thead>
		<c:forEach var="week" items="${weekLog}">
			<tbody>
				<tr>
					<td>${week.id}</td>
					<td>${week.days}</td>
					<td>${week.time}</td>
					<td>${week.action}</td>
					<td>${week.timeframe}</td>
					<td>${week.name}</td>
			</tbody>
		</c:forEach>
	</table><br>
	
	<form action="ChangeDisplayServlet" method="post">
		<label for="changeId">
		修正ID&nbsp№：&nbsp
		<input type="text" name="changeId" id="changeId" required>
		</label><br>
		<button type="submit" style="width: 80px; height: 30px; font-size:16px;">修正</button>
	</form><br>

	<a href = "TodayServlet">タスク当日管理画面へ</a><br>

	<script src="${pageContext.request.contextPath}/js/sortTable.js"></script>
</body>
</html>