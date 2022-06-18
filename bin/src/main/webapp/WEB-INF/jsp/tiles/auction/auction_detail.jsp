<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">

function deleteAuction() {
   if (confirm("경매를 삭제하시겠습니까?")) {
      location.href= "delete.do?auctionId=${auction.auctionId}";
   }ㄴ
}

function updateAuction() {
   if (confirm("경매를 수정하시겠습니까?")) {
      location.href= "form.do?auctionId=${auction.auctionId}";
   }
}

function bid() {

   if (confirm("배팅 하시겠습니까?")) {
      bidForm.submit();
   }
   
}

function orderAuction() {
   location.href= "../order/auction/create.do?auctionId=${auction.auctionId}";
}

</script>


   <h1>About Auction</h1>

   <br />
   <h2>${auction.title}</h2>


<div class="container">
      <div id="auctionForm">
      <!-- 사진 주석처리 함 / 사진 되면 주석 푸세요~~ -->
<!--       <p> -->
<%--           <img src="${auction.img}" --%>
<%--             onerror="this.src='<%=request.getContextPath()%>/resources/static/images/snoopy.gif'" --%>
<!--             alt="Image"> -->
<!--       </p> -->
         <p>
            작성자 : ${writer} <br> <br> 
            작성일 : <fmt:formatDate value="${auction.uploadDate}" pattern="yyyy-MM-dd" /><br><br> 
            조회수 : ${auction.count} <br><br> 
            설명 : ${auction.content}<br><br>
    		
         </p>
            시작 금액 : <fmt:formatNumber value="${auction.startPrice}" pattern="#,###원" /><br><br> 
            마감일 : <fmt:formatDate value="${auction.endDate}" pattern="yyyy-MM-dd HH:mm" />
          <br /><br> <br> 

           <b>현재 최고가 : <fmt:formatNumber value="${auction.maxPrice}" pattern="#,###원" /></b>
           <p>
               <fmt:formatDate value="${date_maxBid}" pattern="yyyy-MM-dd" />
               <br /> ${user_maxBid}
            </p>
            <br>

         <!-- betting -->
         <c:if test="${isWriter eq false}">
              <form:form modelAttribute="bidForm" method="post"
                  action="/auction/bid/create"> 
                  베팅 금액
                     <form:input type="hidden" path="bid.auctionId"
                        value="${auction.auctionId}" />
                     <c:if test="${auction.state eq 'proceeding'}">
                        <form:input type="number" path="bid.bidPrice"
                           class="form-control" /> &nbsp;&nbsp;
                        <input id="register-btn" type="button" value="신청하기" onClick="bid()">
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
   </div>

   <div class="form-group" >
      <%-- <c:if test="${(isWriter eq true) and (empty bids) and (auction.state eq 'proceeding')}"> --%>
      <c:if test="${(isWriter eq true) and (empty auction.bids)}">
         <a href="javascript:updateAuction()">수정</a>
         <a href="javascript:deleteAuction()">삭제</a>
      </c:if>
      <a id="auction-register-btn" href="<c:url value='/auction/list'></c:url>">목록</a>
</div>