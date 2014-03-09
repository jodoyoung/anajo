<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>메뉴 관리</p>

<article>
	<p>메뉴 수정</p>

	<form name="frmMenu" action="<c:url value="/admin/menu/update" />" method="post">
		<input type="hidden" name="menuId" value="${menu.menuId}" />
		<table>
			<tr>
				<td>메뉴명:</td>
				<td><input type="text" name="title" value="${menu.title}" /></td>
			</tr>
			<tr>
				<td>주소:</td>
				<td><input type="text" name="link" value="${menu.link}" /></td>
			</tr>
		</table>
		<input type="submit" value="확인" />
	</form>

</article>

<script type="text/javascript">
var MenuUpdate = new $A.APage('menuUpdate');

MenuUpdate.doUpdate = function() {
	
};
</script>