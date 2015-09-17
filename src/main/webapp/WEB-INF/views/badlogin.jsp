<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
<head>
<title>Ошибка авторизации</title>
</head>
<body>
	<p>Неверное имя пользователя или пароль</p>
	<c:url var="loginUrl" value="/" />
	<p><a href="${loginUrl}">Попробовать еще?</a></p>
	<p><a href="http://www.google.com">Или ну его нафиг?</a></p>
</body>
</html>