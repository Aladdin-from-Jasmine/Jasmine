<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<h1>Auction</h1>
</br>
<div class="container">
	<div align="center">
		<form method="POST" action="/auction/list" >
			<input id="search-auction-form" type="text" name="keyword" class="form-control" />
			<input id="search-auction-form" type="submit" value="검색" id="register-btn">
		</form>
	</div></br>

	<a id="auction-register-btn" href="<c:url value='/auction/list'/>" id="a-btn">🔮 전체목록</a>
	<c:if test="${!empty userSession.user}">
		<a id="auction-register-btn"
			href="<c:url value='/auction/auction_form'></c:url>">경매 등록</a>
	</c:if>	 <br />
	<br />

	<div>
		<c:forEach var="auction" items="${auctionList.pageList}" varStatus="status">
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
		
		<c:if test="${!auctionList.firstPage}">
	          <a href="/auction/list?page=previous" style=""><font color="#d164c4"><B>&lt;&lt;
	                Prev</B></font></a>
        </c:if> 
        
        <c:if test="${!auctionList.lastPage}">
          <a href="/auction/list?page=next"><font color="#d164c4"><B>Next
                &gt;&gt;</B></font></a>
        </c:if>
        
	</div>
</div>