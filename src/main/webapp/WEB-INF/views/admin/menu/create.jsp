<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p class="title">메뉴 등록</p>

<article>

	<form id="createForm">
		<table class="detail">
			<tr>
				<th>메뉴명</th>
				<td><input type="text" id="title" name="title" placeholder="메뉴명" /></td>
			</tr>
			<tr>
				<th>URI</th>
				<td><input type="text" id="link" name="link" placeholder="URI" /></td>
			</tr>
			<tr>
				<th>메뉴 접근 권한</th>
				<td><a href="javascript:AdminMenuCreate.openRolePopup();">추가</a></td>
			</tr>
		</table>
		<a href="javascript:AdminMenuCreate.doCreate();" class="button">확인</a>
		<a href="javascript:AdminMenuCreate.doCancel();" class="button">취소</a>
	</form>
	
	<div id="rolePopup">
		TEST
	</div>

</article>

<script type="text/javascript">
var AdminMenuCreate = $A.APage('AdminMenuCreate');

AdminMenuCreate.doCancel = function() {
	this.document.location.href = '<c:url value="/admin/menu" />';
};

AdminMenuCreate.doCreate = function() {
	if(!this.validateForm()) return;
	
	var menu = { title: $('#title').val(), link: $('#link').val() };
	
	$.ajax({ url: '<c:url value="/admin/menu/create" />.json',
		type: 'POST',
		data: JSON.stringify(menu),
		success: function(result) {
			alert('메뉴가 등록 되었습니다.');
			location.href = '<c:url value="/admin/menu" />';
		}
	});
};

AdminMenuCreate.validateForm = function() {
	$("#createForm").validate({
		rules: {
			title: "required",
			link: "required"
		},
		messages: {
			title: " 메뉴명을 입력 해 주세요.",
			link: " URI를 입력 해 주세요."
		}
	});
	
	return $("#createForm").valid();
};

AdminMenuCreate.openRolePopup = function() {
	$A.openLayer('/resources/html/widget/RoleWidget.html');
};
</script>