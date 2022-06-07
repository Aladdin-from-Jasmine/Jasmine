<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- 게시물 o -->
<c:if test="${listcheck != 'empty'}">

</c:if>


<!-- 게시물 x -->
<c:if test="${listcheck == 'empty'}">
	<div class="table_empty">
		검색결과가 없습니다.
	</div>
</c:if>