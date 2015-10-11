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
				и вы являетесь администратором системы.
				Вы можете добавлять и удалять людей в системе.
			</p>
			<form action="<c:url value="/logout" />" method="POST">
			<input type="submit" value="Выйти"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
			<p>Введите данные нового человека:</p>
			<c:url var="addPersonUrl" value="/person.add" />
			<form:form action="${addPersonUrl}" method="POST" modelAttribute="personDto">
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
  				<form:input id="lastname" path="lastname"/>
  				<form:errors path="lastname"/>
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

			<c:if test="${!empty people}">
			<table>
			<thead>
			    <th>ФИО</th>
			    <th>Возраст</th>
			    <th></th
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
			   <td>
			       <form action="<c:url value="/person.delete/${nextPerson.id}"/>" method="POST">
			         <input type="submit" value="Удалить"/>
       				 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			       </form>
			   </td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
			</c:if>
</body>
</html>
