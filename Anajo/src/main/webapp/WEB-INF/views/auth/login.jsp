<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>로그인</p>

<article>

	<form action="/auth/login" method='POST'>
		<table>
			<tr>
				<td><c:out value="test" />User:
				<td><input type='text' name='email' value=''>
			<tr>
				<td>Password:
				<td><input type='password' name='password' />
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="submit" />
			<tr>
				<td colspan='2'><input name="reset" type="reset" />
		</table>

	</form>

</article>