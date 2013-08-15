<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>권한 관리</p>

<article>
	<p>권한 정보</p>

	<table>
		<tr>
			<td>권한명:</td>
			<td>${role.roleName}</td>
		</tr>
		<tr>
			<td>비고:</td>
			<td>${role.description}</td>
		</tr>
	</table>
	
	<p></p>
	
	<a href="<c:url value="/admin/role/update">
					<c:param name="roleId" value="${role.roleId}" />
				</c:url>">수정</a>
	<a href="<c:url value="/admin/role/delete">
					<c:param name="roleId" value="${role.roleId}" />
				</c:url>">삭제</a>

</article>