<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="${pageContext.request.contextPath}/js/validationRegist.js"></script>

<title>タスク当日管理</title>
</head>
<body>
	<h1>タスク当日管理</h1>
	
	<form action="RegistrationServlet" method="post" onsubmit="return validateRegistForm()">
		<label for="date">実施日:</label>
		<input type="date" id="days" name="days" required><br>
		
		<label for="time">実施時間:</label>
		<input type="time" id="time" name="time" required>
		
		<fieldset>
			<legend>実施内容</legend>
			<c:forEach var="actionEntry" items="${action}">
				<label for="${actionEntry.actionEntry}">
				<input type="checkbox" name="action" id="${actionEntry.actionEntry}" value="${actionEntry.actionEntry}">
				<c:out value="${actionEntry.actionEntry}"></c:out>
				</label><br>
			</c:forEach>
		</fieldset>
				
		<fieldset>
			<legend>実施時間帯</legend>
			<c:forEach var="timeframeEntry" items="${timeframe}">
				<label for="${timeframeEntry.timeframeEntry}">
				<input type="checkbox" name="timeframe" id="${timeframeEntry.timeframeEntry}" value="${timeframeEntry.timeframeEntry}">
				<c:out value="${timeframeEntry.timeframeEntry}"></c:out>
				</label><br>
			</c:forEach>
		</fieldset>
				
		<fieldset>
			<legend>実施者</legend>
			<c:forEach var="nameEntry" items="${name}">
				<label for="${nameEntry.nameEntry}">
				<input type="checkbox" name="name" id="${nameEntry.nameEntry}" value="${nameEntry.nameEntry}">
				<c:out value="${nameEntry.nameEntry}"></c:out>
				</label><br>
			</c:forEach>
		</fieldset>
		
		<button type="submit" style="width: 80px; height: 30px; font-size:16px;">登録</button>
	</form>	<br>
	<table border="1">
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
		<c:forEach var="today" items="${todayLog}">
			<tbody>
				<tr>
					<td>${today.id}</td>
					<td>${today.days}</td>
					<td>${today.time}</td>
					<td>${today.action}</td>
					<td>${today.timeframe}</td>
					<td>${today.name}</td>
			</tbody>
		</c:forEach>
	</table><br>
	
	<form action="DeleteServlet" method="post">
		<label for="deleteId">
		削除ID&nbsp№：&nbsp
		<input type="text" name="deleteId" id="deleteId" required>
		</label><br>
		<button type="submit" style="width: 80px; height: 30px; font-size:16px;">削除</button>
	</form><br>
	
	<a href = "WeekServlet">履歴確認画面へ</a>
	
</body>
</html>