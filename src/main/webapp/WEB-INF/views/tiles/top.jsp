<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<header>
	<div id="logo">
		<a href="<c:url value="/" />">Anajo</a>
	</div>
	<div id="reg">
		<sec:authorize access="!hasRole('ROLE_USER')">
			<a href="<c:url value="/auth/loginPage" />">로그인</a>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_USER')">
			<a href="<c:url value="/auth/logout" />">로그아웃</a>
		</sec:authorize>
	</div>
</header>

<nav>
	<c:forEach var="menu" items="${menus}">
		<sec:authorize access="hasAnyRole(${menu.authorities})">
			<a href="${menu.link}">${menu.title}</a>
		</sec:authorize>
	</c:forEach>	
</nav>
