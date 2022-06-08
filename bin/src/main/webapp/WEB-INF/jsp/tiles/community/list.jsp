<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
	function create(){		
		if(confirm("로그인 후 가능한 기능입니다.\n로그인 페이지로 이동하시겠습니까?")){
			window.location.href = "http://localhost:8080/user/login";
		}
	}
</script>

<div class="container">
	<h1>Community List</h1>
</div>
	<div class="container">
	<a id="a-btn"
		href="<c:url value='/community/list'>
					<c:param name="sortByPostId" value="true" />
			</c:url>">🔻 PostId순
	</a>&nbsp
	<a id="a-btn"
		href="<c:url value='/community/list'>
					<c:param name="sortByPostId" value="false" />
			</c:url>">🔻 최신순
	</a> <br/> <br/> <br/>  
		<div class="row">
			<div class="col-lg-4 col-md-6 mb-4">
				<div class="post-entry-1 h-100">
					<div class="post-entry-1-contents">
						<table class="listTb" align="center">
							<tr class="listTb-tr1">
								<td class="listTb-1">Post ID</td>
								<td class="listTb-2">Title</td>
								<td class="listTb-3">Writer</td>
								<td class="listTb-2">Created Date</td>
							</tr>
							<c:forEach var="community" items="${communityList}">
								<tr class="listTb-tr2">
									<td><a id="a2-btn" href="<c:url value='/community/detail'>
	  											<c:param name="postId" value="${community.postId}"/>
											  </c:url>">${community.postId}</a>
									</td>
									<td>${community.title}</td>
									<td>${community.userId}</td>
									<td>
										<div class="price-wrap d-flex">
											<span class="meta d-inline-block mb-3"> &nbsp;
												<fmt:formatDate value="${community.communityDate}" pattern="yyyy-MM-dd" />
											</span>
										</div>
									</td>
								</tr>
							</c:forEach>
						</table>
						</div>
					</div>
				</div>
			<br/><br/>
		</div>
		<c:if test="${!empty userSession.user}">
		<a id="auction-register-btn"
			href="<c:url value='/community/create'></c:url>">게시물 등록
		</a> 
	</c:if>
	<c:if test="${empty userSession.user}">
		<input id="auction-register-btn" type="button" value="게시물 등록" onClick="create()" />
	</c:if>
</div>
