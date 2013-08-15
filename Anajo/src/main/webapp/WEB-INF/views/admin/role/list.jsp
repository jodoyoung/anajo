<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<p>권한 관리</p>

<article>
	<p>
		<a href="<c:url value="/admin/role/create" />">추가</a>
	</p>

	<table>
		<c:forEach var="role" items="${roles}">
			<tr>
				<td><a href="<c:url value="/admin/role/read">
										<c:param name="roleId" value="${role.roleId}" />
								   </c:url>">${role.roleName}</a></td>
				<td>${role.description}</td>
			</tr>
		</c:forEach>
	</table>

</article>