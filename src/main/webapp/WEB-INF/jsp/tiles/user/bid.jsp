<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<h1>My Page</h1>
	<h3>낙찰된 경매 ⌛</h3>
</div>
	<div>
		<c:forEach var="auction" items="${auctionList}" varStatus="status">
			<div id="auctionForm">
				<table class="TB3" align="center">
					<tr>
						<td rowspan="5">
							<img src="${auction.img}" alt="Image" width="200px" height="200px">
						</td>
						<td>
							<h3>
								경매제목 :&nbsp;
								<a href="<c:url value='/auction/detail'>
		                                 <c:param name="auctionId" value="${auction.auctionId}"/>
		                               </c:url>">${auction.title}</a>
							</h3>
						</td>
					</tr>
					<tr>
						<td text-align="center">
							<div>
								<h5>진행상황 :&nbsp;
									<c:if test="${auction.state eq 'proceeding'}">
										Proceeding
									</c:if>
									<c:if test="${auction.state eq 'closed'}">
										Closed
									</c:if>
								</h5>
							</div>
						</td>
					</tr>
					<tr>
						<td text-align="center">
							<span>마감일 : &nbsp;	<fmt:formatDate value="${auction.endDate}" pattern="yyyy-MM-dd" />
							</span>
						</td>
					</tr>
					<tr>
						<td text-align="center">
							<span> <span>최고가 : </span> &nbsp; 
									<fmt:formatNumber value="${auction.maxPrice}" pattern="#,###원" />
							</span>	
						</td>
					</tr>
					<tr>
						<td text-align="center">
							<p>경매내용 : ${auction.content_}</p>
						</td>
					</tr>		
				</table>
			</div>
		</c:forEach>
	</div>