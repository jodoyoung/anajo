<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>메뉴 관리</p>

<article>
	<p>메뉴 등록</p>

	<form name="frmMenu" action="<c:url value="/admin/menu/create" />" method="post">
		<input type="hidden" name="menuId" value="${menuId}" />
		<table>
			<tr>
				<td>메뉴명:</td>
				<td><input type="text" name="title"  /></td>
			</tr>
			<tr>
				<td>주소:</td>
				<td><input type="text" name="link" /></td>
			</tr>
		</table>
		<input type="submit" value="확인" />
	</form>

</article>