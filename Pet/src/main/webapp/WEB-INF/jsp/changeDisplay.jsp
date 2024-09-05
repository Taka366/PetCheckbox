<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>履歴修正</title>
</head>
<body>	 
	<table border="1">
		<h1>履歴修正</h1>
		<thead>
			<tr>
				<th>ID</th>
				<th>実施日</th>
				<th>実施時間</th>
				<th>実施内容</th>
				<th>実施時間帯</th>
				<th>実施者</th>
			</tr>
		</thead>
		<c:forEach var="change" items="${log}">
			<tbody>
				<tr>
					<td>${change.id}</td>
					<td>${change.days}</td>
					<td>${change.time}</td>
					<td>${change.action}</td>
					<td>${change.timeframe}</td>
					<td>${change.name}</td>
			</tbody>
		</c:forEach>
	</table><br>
	
	<form action="ChangeServlet" method="post" onsubmit="return submitCheck()">
		<input type="hidden" id="id" name="id" value="${log[0].id}">
	
		<label for="date">実施日:</label>
		<input type="date" id="days" name="days" required><br>
	
		<label for="time">実施時間:</label>
		<input type="time" id="time" name="time" required>
		
		<fieldset>
			<legend>実施内容</legend>
			<label for="food">
				<input type="radio" name="action" id="food" value="餌やり" required>
				餌やり
			</label><br>
			<label for="water">
				<input type="radio" name="action" id="water" value="水やり">
				水やり
			</label><br>
			<label for="toilet">
				<input type="radio" name="action" id="toilet" value="トイレ掃除">
				トイレ掃除
			</label><br>
			<label for="lock">
				<input type="radio" name="action" id="lock" value="カギ閉め">
				カギ閉め
			</label><br>
			<label for="all">
				<input type="radio" name="action" id="all" value="全部">
				全部
			</label>
		</fieldset>
		<fieldset>
			<legend>実施時間帯</legend>
			<label for="morning">
				<input type="radio" name="timeframe" id="morning" value="朝" required>
				朝
			</label><br>
			<label for="noon">
				<input type="radio" name="timeframe" id="noon" value="昼">
				昼
			</label><br>
			<label for="night">
				<input type="radio" name="timeframe" id="night" value="夜">
				夜
			</label>
		</fieldset>
		<fieldset>
			<legend>実施者</legend>
			<label for="T">
				<input type="radio" name="name" id="T" value="T" required>
				T
			</label><br>
			<label for="R">
				<input type="radio" name="name" id="R" value="R">
				R
			</label><br>
			<label for="A">
				<input type="radio" name="name" id="A" value="A">
				A
			</label><br>
		</fieldset>
		<button type="submit" id="btn" style="width: 80px; height: 30px; font-size:16px;">修正</button>
		<script src="${pageContext.request.contextPath}/js/confirm.js?date=20240817"></script>
	</form>	<br>
	
	<a href = "TodayServlet">タスク当日管理画面へ</a><br>
	
	<a href = "WeekServlet">履歴確認画面へ</a>
	
</body>
</html>