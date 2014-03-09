<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p class="title">메뉴 목록</p>

<article>

	<table class="list">
		<tr>
			<th>메뉴명</th>
			<th>URI</th>
		</tr>
		<c:forEach var="menu" items="${menus}" varStatus="status">
			<tr class="row${status.index mod 2}" onClick="javascript:AdminMenuList.goDetail('${menu.menuId}');">
				<td><a href="<c:url value="/admin/menu/read">
										<c:param name="menuId" value="${menu.menuId}" />
									</c:url>">${menu.title}</a></td>
				<td>${menu.link}</td>
			</tr>
		</c:forEach>
	</table>
	
	<p>
		<a href="<c:url value="/admin/menu/create" />" class="button">추가</a>
	</p>
	
</article>

<script type="text/javascript">
var AdminMenuList = new $A.APage('AdminMenuList');

AdminMenuList.goDetail = function(id) {
	var url = '<c:url value="/admin/menu/read" />?menuId=' + id;
	this.document.location.href = url;
};
</script>