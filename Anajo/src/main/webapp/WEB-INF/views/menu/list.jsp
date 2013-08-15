<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<div data-role="content">
	<div class="ui-grid-b">
		<c:forEach var="m" items="${menus}">
			<div class="ui-block-a">
				<a data-role="button" data-transition="slide" data-theme="c"
					href='<c:url value="${m.link}" />' onfocus="this.blur()">${m.title}</a>
			</div>
		</c:forEach>
	</div>
</div>