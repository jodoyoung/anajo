<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>회원 관리</p>

<article>
	<p>회원 수정</p>

	<form name="frmMember" action="<c:url value="/admin/member/update" />" method="post">
		<input type="hidden" name="memberId" value="${member.memberId}" />
		<table>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="${member.email}" /></td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>이름:</td>
				<td><input type="text" name="name" value="${member.name}" /></td>
			</tr>
			<tr>
				<td>상태:</td>
				<td>
					<select name="enabled">
						<c:forEach var="type" items="${enabledType}">
							<option value="${type.code}"
								<c:if test="${type.code eq member.enabled}"> selected</c:if>
							>${type.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
		<input type="submit" value="확인" />
	</form>

</article>