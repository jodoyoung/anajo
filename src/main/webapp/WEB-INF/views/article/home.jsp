<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<p>게시판 목록</p>

<article>
	<c:forEach var="category" items="${categories}">
		<p><a href="${category.link}">${category.title}</a></p>
	</c:forEach>
</article>