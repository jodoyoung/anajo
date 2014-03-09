<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<article class="login">
	<div class="logo">
		<a href="<c:url value="/" />"><img src="<c:url value="/resources/img/logo.png" />" alt="anajo" /></a>
	</div>
	<div class="loginBox">
	<form action="/auth/login" method='POST'>
		<input type="text" name="email" placeholder="이메일" /><br/>
		<input type="password" name="password" placeholder="비밀번호" /><br/><br/><br/>
		<input name="submit" type="submit" value="로그인" class="button" />
	</form>
	</div>

</article>