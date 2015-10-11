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
			<p>
				Вы вошли как <sec:authentication property="principal.username" />
			</p>
			<form action="<c:url value="/logout" />" method="POST">
			<input type="submit" value="Выйти"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>

			<c:if test="${!empty people}">
			<table>
			<thead>
			    <th>ФИО</th>
			    <th>Возраст</th>
			</thead>
			<tbody>
			<c:forEach items="${people}" var="nextPerson">
			<tr>
			   <td>
			        <c:out value="${nextPerson.fullname}"/>
			   </td>
			   <td>
			        <c:out value="${nextPerson.age}"/>
			   </td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
			</c:if>

			<c:if test="${empty people}">
			    <p>Никого нет...</p>
            </c:if>
</body>
</html>
