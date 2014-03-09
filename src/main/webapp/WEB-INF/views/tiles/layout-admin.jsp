<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertAttribute name="common" />
<!DOCTYPE html>
<html>
<head>
<tiles:insertAttribute name="header" />
</head>
<body>
	<div id="wrapper">

		<!-- 상단 -->
		<tiles:insertAttribute name="top" />

		<!-- 콘텐츠 -->
		<section>
			<tiles:insertAttribute name="content" />
		</section>

		<!-- 하단 -->
		<footer>
			<tiles:insertAttribute name="footer" />
		</footer>

	</div>
</body>
</html>