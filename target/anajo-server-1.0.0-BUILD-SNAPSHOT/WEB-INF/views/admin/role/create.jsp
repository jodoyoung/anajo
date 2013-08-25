<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>권한 관리</p>

<article>
	<p>권한 등록</p>

	<form name="frmRole" action="<c:url value="/admin/role/create" />" method="post">
		<input type="hidden" name="roleId" value="${roleId}" />
		<table>
			<tr>
				<td>권한명:</td>
				<td><input type="text" name="roleName" placeholder="ROLE_NAME" /></td>
			</tr>
			<tr>
				<td>비고:</td>
				<td><input type="text" name="description" /></td>
			</tr>
		</table>
		<input type="submit" value="확인" />
	</form>

</article>