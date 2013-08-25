<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>메뉴 관리</p>

<article>
	<p>메뉴 정보</p>

	<table>
		<tr>
			<td>메뉴명:</td>
			<td>${menu.title}</td>
		</tr>
		<tr>
			<td>주소:</td>
			<td>${menu.link}</td>
		</tr>
	</table>
	
	<p></p>
	
	<a href="<c:url value="/admin/menu/update">
					<c:param name="menuId" value="${menu.menuId}" />
				</c:url>">수정</a>
	<a href="<c:url value="/admin/menu/delete">
					<c:param name="menuId" value="${menu.menuId}" />
				</c:url>">삭제</a>

</article>