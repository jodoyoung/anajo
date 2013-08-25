<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<div data-role="content">
	<div class="ui-grid-a">

		<c:set var="i" value="0" />

		<c:forEach var="m" items="${menus}">

			<c:set var="sType" value="${i mod 2}" />

			<c:choose>
				<c:when test="${sType eq 0}">
					<c:set var="s" value="a" />
				</c:when>
				<c:when test="${sType eq 1}">
					<c:set var="s" value="b" />
				</c:when>
			</c:choose>

			<div class="ui-block-${s}">
				<a data-role="button" data-transition="slide" data-theme="c"
					href='<c:url value="${m.link}" />'>${m.title}</a>
			</div>

			<c:set var="i" value="${i+1}" />

		</c:forEach>

	</div>
</div>