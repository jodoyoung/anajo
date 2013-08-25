<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<p>회원 관리</p>

<article>
	<p>
		<a href="<c:url value="/admin/member/create" />">추가</a>
	</p>

	<table>
		<c:forEach var="member" items="${members}">
			<tr>
				<td><a href="<c:url value="/admin/member/read">
										<c:param name="memberId" value="${member.memberId}" />
								   </c:url>">${member.email}</a></td>
				<td>${member.name}</td>
			</tr>
		</c:forEach>
	</table>

</article>