<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!doctype html>
<html>
<head>
<title>Test application</title>
</head>
<body>
		<sec:authorize access="isAuthenticated()">
			<p>
				Вы вошли как <sec:authentication property="principal.username" />
			</p>
			<p>Теперь давайте добавлять человеков</p>
			<c:url var="addHomoUrl" value="/homo.add" />
			<form:form action="${addHomoUrl}" method="POST" commandName="homoDto">
                <div>
                <label for="surname">Фамилия</label>
                </div>
                <div>
  				<form:input id="surname" path="surname"/>
  				<form:errors path="surname"/>
				</div>

                <div>
                <label for="name">Имя</label>
                </div>
                <div>
  				<form:input id="name" path="name"/>
  				<form:errors path="name"/>
  				</div>

				<div>
                <label for="lastname">Отчество</label>
                </div>
                <div>
  				<form:input id="lastname" path="lastName"/>
  				<form:errors path="lastName"/>
  				</div>

				<div>
                <label for="age">Возраст</label>
                </div>
                <div>
  				<form:input type="number" id="age" path="age"/>
  				<form:errors path="age"/>
  				</div>

				<div>
				<input type="submit" value="Добавить"/>
				</div>

			</form:form>

			<c:if test="${!empty allHomo}">
			<c:forEach items="${allHomo}" var="nextHomo">
			   <p><strong>${nextHomo}</strong></p>
			</c:forEach>
			</c:if>
		</sec:authorize>

		<sec:authorize access="!isAuthenticated()">
			<c:url var="loginUrl" value="/j_spring_security_check" />
			<form action="${loginUrl}" method="POST">
				<div>
				<input type="text" name="j_username" placeholder="Логин" required="true" autofocus="true"/>
				</div>
				<div>
				<input type="password" name="j_password" placeholder="Пароль" required="true"/>
				</div>
				<input type="submit" value="Войти"/>
			</form>
		</sec:authorize>
</body>
</html>