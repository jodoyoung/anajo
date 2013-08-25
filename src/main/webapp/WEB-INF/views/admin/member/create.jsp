<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>회원 관리</p>

<article>
	<p>회원 등록</p>

	<form name="frmMember" action="<c:url value="/admin/member/create" />" method="post">
		<input type="hidden" name="memberId" value="${memberId}" />
		<table>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>이름:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			
		</table>
		<input type="submit" value="확인" />
	</form>

</article>