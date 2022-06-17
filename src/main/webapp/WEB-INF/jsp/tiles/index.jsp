<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Auction</h1>
</br>
<div class="container">
	<div align="center">
		<form method="POST" action="/auction/list" >
		</form>
	</div></br>

	<div>
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
	</div>
</div>
        
        <p align="center">
          <b> Welcome to the Jasmine, by Aladdin </b>
        </p>
        <p align="center">Based on the 'Spring Boot'</p>
        <p align="center">
          <i> Jasmine service is a used book trading service. </br>
          	 With our service, consumers can buy the books they need at a lower price than buying them from a bookstore,  </br>
          	and sellers can make money by selling books they no longer need. </br>
          	 We want to spread the knowledge and enjoyment gained through books to the world by making books </br>
          	 more accessible to more people through Jasmine.
          </i>
        </p>
        <p>&nbsp;</p>
        