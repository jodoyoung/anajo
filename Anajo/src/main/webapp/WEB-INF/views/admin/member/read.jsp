<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>회원 관리</p>

<article>
	<p>회원 보기</p>

	<table>
		<tr>
			<td>Email:</td>
			<td>${member.email}</td>
		</tr>
		<tr>
			<td>이름:</td>
			<td>${member.name}</td>
		</tr>
		<tr>
			<td>상태:</td>
			<td>${member.enabledStr}</td>
		</tr>
		<tr>
			<td>권한:</td>
			<td>${member.roles}</td>
		</tr>
	</table>
	
	<p></p>
	
	<a href="<c:url value="/admin/member/update">
					<c:param name="memberId" value="${member.memberId}" />
				</c:url>">수정</a>
	<a href="<c:url value="/admin/member/delete">
					<c:param name="memberId" value="${member.memberId}" />
				</c:url>">삭제</a>

</article>