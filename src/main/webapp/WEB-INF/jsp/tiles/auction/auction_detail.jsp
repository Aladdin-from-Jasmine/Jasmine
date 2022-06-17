<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">

function deleteAuction() {
   if (confirm("경매를 삭제하시겠습니까?")) {
      location.href= "delete?auctionId=${auction.auctionId}";
   }
}

function updateAuction() {
   if (confirm("경매를 수정하시겠습니까?")) {
      location.href= "form?auctionId=${auction.auctionId}";
   }
}

function bid(max, now) {

	var txt = document.getElementById("bidPrice").value;
	
   if (confirm("배팅 하시겠습니까?")) {
	   /* if(max >= txt)
		   alert("작아욘");
	   else */
      	bidForm.submit();
   }
   
}

function orderAuction() {
   location.href= "../order/auction/create.do?auctionId=${auction.auctionId}";
}

</script>


   <h1>About Auction</h1>

   <br />
   <h2>제목 : ${auction.title}</h2> 

<div class="container">
      <div id="auctionForm">
      	<table class="TB3" align="center">
      		<tr>
      			<td rowspan="7">
	      			<p><img src= "${auction.img}" width="300px" height="350px"/></p> 
      			</td>
      			<td>작성자 : ${writer}</td>
      		</tr>
      		<tr>
      			<td>글 작성일 : <fmt:formatDate value="${auction.uploadDate}" 
      						pattern="yyyy-MM-dd" /></td>
      		</tr>
      		<tr>
      			<td>조회수 : ${auction.count}</td>
      		</tr>
      		<tr>
      			<td>책 제목 : ${auction.booktitle}</td>
      		</tr>
      		<tr>
      			<td>저자 : ${auction.bookauthor}</td>
      		</tr>
      		<tr>
      			<td>출판사 : ${auction.bookpublisher}</td>
      		</tr>
      		<tr>
      			<td>설명 : ${auction.content_}</td>
      		</tr>
      	</table>
      	
      	</br></br>
      	
      	<table class="TB2" align="center">
      		<tr class="td1">
      			<c:if test="${auction.state eq 'closed'}">
	      			<td>진행상황</td>
	      			<td>낙찰되었습니다.</td>
      			</c:if>
      			<c:if test="${auction.state eq 'proceeding'}">
	      			<td>경매 마감일</td>
      				<td><fmt:formatDate value="${auction.endDate}" pattern="yyyy-MM-dd HH:mm" /></td>
      			</c:if>
      		<%-- 	<td>경매 마감일</td>
      			<td><fmt:formatDate value="${auction.endDate}" pattern="yyyy-MM-dd HH:mm" /></td>
      		 --%></tr>
      		<tr class="td1">
      			<td>시작 금액</td>
      			<td><fmt:formatNumber value="${auction.startPrice}" pattern="#,###원" /></td>
      		</tr>
      		<tr class="td1">
      			<td style="color: #f57ad4">현재 최고가</td>
      			<td style="color: #f57ad4"style="color: rgb(128, 128, 192)"><fmt:formatNumber value="${auction.maxPrice}" pattern="#,###원" /></td>
      		</tr>
      		<tr class="td1">
      			<td>최고가 배팅 User</td>
      			<td>${user_maxBid}</td>
      		</tr>
      		<tr class="td1">
      			<td>최고가 배팅날짜</td>
      			<td><fmt:formatDate value="${date_maxBid}" pattern="yyyy-MM-dd" /></td>
      		</tr>
      	</table>
      	
      	</br></br>
      
      <%-- 
       <p> 
          <img src= "${auction.img}" width="300px" height="350px"/>
      </p> 
         <p>
            작성자 : ${writer} <br> <br> 
            작성일 : <fmt:formatDate value="${auction.uploadDate}" pattern="yyyy-MM-dd" /><br><br> 
            조회수 : ${auction.count} <br><br> 
            설명 : ${auction.content_}<br><br>
            책 제목 : ${auction.booktitle}<br><br>
            책 저자 : ${auction.bookauthor}<br><br>
            책 출판사 : ${auction.bookpublisher}<br><br>
         </p>
            시작 금액 : <fmt:formatNumber value="${auction.startPrice}" pattern="#,###원" /><br><br> 
            마감일 : <fmt:formatDate value="${auction.endDate}" pattern="yyyy-MM-dd HH:mm" />
          <br /><br> <br> 

           <b>현재 최고가 : <fmt:formatNumber value="${auction.maxPrice}" pattern="#,###원" /></b>
           <p>
               <fmt:formatDate value="${date_maxBid}" pattern="yyyy-MM-dd" />
               <br /> ${user_maxBid}
            </p>
            <br> --%>

         <!-- betting -->
         <c:if test="${empty userSession.user}">
         	<p class="error">배팅을 하시려면 로그인을 해주세요!</p>
         </c:if>
         <c:if test="${!empty userSession.user && isWriter eq false}">
              <form:form modelAttribute="bidForm" method="post"
                  action="/auction/bid/create"> 
                  베팅 금액
                     <form:input type="hidden" path="bid.auctionId"
                        value="${auction.auctionId}" />
                     <c:if test="${auction.state eq 'proceeding'}">
                        <form:input type="number" path="bid.bidPrice"
                           class="form-control" id="bidPrice"/> &nbsp;&nbsp;
                        <input id="register-btn" type="button" value="신청하기" onClick="bid(${auction.maxPrice})">
                     </c:if>

                     <c:if test="${auction.state eq 'closed'}">
                        <form:input type="number" path="bid.bidPrice"
                           class="form-control" readonly="true" />&nbsp;&nbsp;
                        <input type="button" value="신청하기" onClick="bid()" disabled>

                        <c:if
                           test="${completeOrder ne 1 && successBidderUserId eq userSession.user.userId}">
                                 &nbsp;&nbsp; <!-- 아래 버튼은 낙찰자만 볼 수 있도록 -->
                           <input type="button" value="결제하기" onClick="orderAuction()">
                        </c:if>
                     </c:if>
                  <form:errors path="bid.bidPrice" cssClass="error" />
               </form:form>
         </c:if>
      </div>
      
         <!--<p>${isWriter}</p> 얘 나중에 삭제하기 -->
   </div>

   <div class="form-group" >
   	  <!-- user이면 작성자이고 경매가 입찰 전이면 수정, 삭제 가능 / 관리자면 입찰 상관없이 수정, 삭제 가능  -->
      <c:if test="${((isWriter eq true) and (empty auction.bids)) or (isManager eq true)}">
         <a id="auction-register-btn" href="javascript:updateAuction()">수정</a>
         <a id="auction-register-btn" href="javascript:deleteAuction()">삭제</a>
      </c:if>
      <c:if test="${(isWriter eq true) and (!empty auction.bids) and (!empty isClosed)}">
         <a id="auction-register-btn" href="<c:url value='/auction/bid/success'>
         					<c:param name="auctionId" value="${auction.auctionId}"/>
         				</c:url>">낙찰</a>
      </c:if>
      <a id="auction-register-btn" href="<c:url value='/auction/list'></c:url>">목록</a>
</div>