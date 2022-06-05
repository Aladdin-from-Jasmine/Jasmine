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
   }
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

<div class="container">
   <h1>About Auction</h1>
</div>

<br />
<div align="center">
   <br />
   <h2>${auction.title}</h2>
   <br />
</div>

<div class="container">
   <div class="row align-items-center">
      <div class="col-md-6 mb-5 mb-md-0">
         <img src="${auction.img}"
            onerror="this.src='<%=request.getContextPath()%>/resources/static/images/snoopy.gif'"
            alt="Image">
      </div>

      <div class="col-md-5 ml-auto">

         <p>
            작성자 : &nbsp; &nbsp; ${writer} <br /> 작성일 : &nbsp; &nbsp;
            <fmt:formatDate value="${auction.uploadDate}" pattern="yyyy-MM-dd" />
            <br /> 조회수 : &nbsp; &nbsp; ${auction.count} <br />
         </p>
         <h5>
            시작 금액 : &nbsp; &nbsp;
            <fmt:formatNumber value="${auction.startPrice}" pattern="#,###원" />
         </h5>
         <h5>
            마감일 : &nbsp; &nbsp;
            <fmt:formatDate value="${auction.endDate}"
               pattern="yyyy-MM-dd HH:mm" />
         </h5>
         <br />

         <h5 align="center">
            <b>현재 최고가</b>
         </h5>

         <div class="alert alert-primary" role="alert">
            <h4 class="text-danger">
               <fmt:formatNumber value="${auction.maxPrice}" pattern="#,###원" />
            </h4>
            <p>
               <fmt:formatDate value="${date_maxBid}" pattern="yyyy-MM-dd" />
               <br /> ${user_maxBid}
            </p>

         </div>
         <br />
         <br />

         <!-- betting -->
         <c:if test="${isWriter eq false}">
            <div class="d-flex">
               <form:form modelAttribute="bidForm" method="post"
                  action="/goodsom/auction/bid/create.do">
                  <h5>베팅 금액</h5>
                  <div class="d-flex">
                     <form:input type="hidden" path="bid.auctionId"
                        value="${auction.auctionId}" />
                     <c:if test="${auction.state eq 'proceeding'}">
                        <form:input type="number" path="bid.bidPrice"
                           class="form-control" />
                        <input type="button" value="신청하기" onClick="bid()">
                     </c:if>

                     <c:if test="${auction.state eq 'closed'}">
                        <form:input type="number" path="bid.bidPrice"
                           class="form-control" readonly="true" />
                        <input type="button" value="신청하기" onClick="bid()" disabled>

                        <c:if
                           test="${completeOrder ne 1 && successBidderUserId eq userSession.user.userId}">
                                 &nbsp;&nbsp; <!-- 아래 버튼은 낙찰자만 볼 수 있도록 -->
                           <input type="button" value="결제하기" onClick="orderAuction()">
                        </c:if>
                     </c:if>
                  </div>
                  <form:errors path="bid.bidPrice" cssClass="error" />
               </form:form>
            </div>
         </c:if>

      </div>
   </div>
   <br />
   <br />

   <div>
      <h5>${auction.content}</h5>
   </div>
   <br />
   <br />
   <br />

   <div class="form-group" align="right"></div>
   <br />

   <div class="form-group" align="right">
      <%-- <c:if test="${(isWriter eq true) and (empty bids) and (auction.state eq 'proceeding')}"> --%>
      <c:if test="${(isWriter eq true) and (empty auction.bids)}">
         <a href="javascript:updateAuction()">수정</a>
         <a href="javascript:deleteAuction()">삭제</a>
      </c:if>
      <a href="<c:url value='/auction/auction_list'></c:url>">목록</a>
   </div>
</div>