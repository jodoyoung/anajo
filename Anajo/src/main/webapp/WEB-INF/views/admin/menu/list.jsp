<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p>메뉴 관리</p>

<article>
	<p>
		<a href="<c:url value="/admin/menu/create" />">추가</a>
	</p>

	<table>
		<c:forEach var="menu" items="${menus}">
			<tr>
				<td><a href="<c:url value="/admin/menu/read">
										<c:param name="menuId" value="${menu.menuId}" />
								   </c:url>">${menu.title}</a></td>
				<td>${menu.link}</td>
			</tr>
		</c:forEach>
	</table>

</article>