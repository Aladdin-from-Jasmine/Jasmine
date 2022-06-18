<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script>
function auctionSubmit(isNewAuction) {

   if(isNewAuction){
      alert("경매를 등록합니다.");
      document.auctionForm.action="create";
   }else{
      alert("경매를 수정합니다.");
      document.auctionForm.action="update";
   }
   document.auctionForm.submit();
}
</script>

<div class="container">
   <h1>Add Auction</h1>
   <form:form modelAttribute="auctionForm" name="auctionForm"
      method="post" enctype="multipart/form-data">


      <div class="auction-form-sub">
         <label for="auction.title">제목</label>
         <form:errors path="auction.title" cssClass="error" />
         <form:input path="auction.title" class="form-control"
            placeholder="Title" />
      </div>

      <div class="auction-form-sub">
         <label for="auction.startPrice">최소 입찰 금액</label>
         <form:errors path="auction.startPrice" cssClass="error" />

         <c:choose>
            <c:when test="${auctionForm.newAuction}">
               <form:input type="number" path="auction.startPrice"
                  class="form-control" placeholder="10000" />
            </c:when>
            <c:otherwise>
               <form:input type="number" path="auction.startPrice"
                  class="form-control" value="${auctionForm.auction.startPrice}" />
            </c:otherwise>
         </c:choose>
      </div>

      <div class="auction-form-sub">
         <label for="auction.endDate">마감일</label>
         <form:errors path="auction.endDate" cssClass="error" />

         <c:choose>
            <c:when test="${auctionForm.newAuction}">
               <form:input type="date" path="auction.endDate" class="form-control"
                  placeholder="yyyy-MM-dd" />
            </c:when>
            <c:otherwise>
               <fmt:formatDate value='${groupBuyForm.groupBuy.endDate}'
                  pattern='yyyy-MM-dd' var="dateFormat" />
               <form:input type="date" path="auction.endDate" class="form-control"
                  value="${dateFormat}" />
            </c:otherwise>
         </c:choose>

         <form:select path="auction.hour" class="select">
            <form:options path="auction.hour" items="${hourData}"
               itemLabel="label" itemValue="code" />
         </form:select>
         <form:select path="auction.minute" class="select">
            <form:options path="auction.minute" items="${minuteData}"
               itemLabel="label" itemValue="code" />
         </form:select>


         <form:radiobuttons items="${amPm}" id="amPm" path="auction.isAmPm" />
         <form:errors path="auction.isAmPm" cssClass="error" />

      </div>


      <div class="auction-form-sub">
         <label for="auction.content">상세 설명</label>
         <form:errors path="auction.content_" cssClass="error" />
         <c:choose>
            <c:when test="${auctionForm.newAuction}">
               <form:textarea path="auction.content_" class="form-control"
                  placeholder="Write description." id="auction-des-form" />
            </c:when>
            <c:otherwise>
               <form:textarea path="auction.content_" class="form-control" id="auction-des-form"/>
            </c:otherwise>
         </c:choose>
      </div>

      <div class="auction-form-sub">
         <label for="auction.report">대표 이미지</label>
         <form:errors path="auction.report" cssClass="error" />

         <form:input type="file" path="auction.report" />   
      </div>
      
      <div class="auction-form-sub">
         <label for="auction.booktitle">책 제목</label> 
         <form:input path="auction.booktitle" class="form-control" />     
         <form:errors path="auction.booktitle" cssClass="error" />
      </div>
      
      <div class="auction-form-sub">
         <label for="auction.bookauthor">책 저자</label> 
         <form:input path="auction.bookauthor" class="form-control" />
         <form:errors path="auction.bookauthor" cssClass="error" />
      </div>
      
      <div class="auction-form-sub">
         <label for="auction.bookpublisher">책 출판사</label> 
         <form:input path="auction.bookpublisher" class="form-control" />
         <form:errors path="auction.bookpublisher" cssClass="error" />
      </div>
      

      <div class="form-group" align="right">
         <a id="a-btn" href="<c:url value='/auction/list' ></c:url>">Cancel</a>
         <input id="register-btn" type="button" value="Save"
            onClick="auctionSubmit(${auctionForm.newAuction})">
      </div>
   </form:form>
</div>
