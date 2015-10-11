<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!doctype html>
<html>
<head>
<title>Система добавления человеков</title>
</head>
<body>
		    <c:if test="${!empty param.error}">
		    <div>
		    Не угадали пароль!
		    </div>
		    </c:if>
		    <c:if test="${!empty param.logout}">
		    <div>
		    Вы успешно вышли из системы добавления человеков!
		    </div>
		    </c:if>
			<c:url var="loginUrl" value="/j_spring_security_check" />
			<form action="${loginUrl}" method="POST">
				<div>
				<input type="text" name="j_username" placeholder="Логин" required="true" autofocus="true"/>
				</div>
				<div>
				<input type="password" name="j_password" placeholder="Пароль" required="true"/>
				</div>
				<input type="submit" value="Войти"/>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
</body>
</html>
