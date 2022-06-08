<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<h1>Auction</h1>

<div class="container">
   <a id="auction-register-btn"
      href="<c:url value='/auction/auction_form'></c:url>">경매 등록</a> <br />
   <br />

   <div>
      <c:forEach var="auction" items="${auctionList}" varStatus="status">
         

         <div id="auctionForm">
         <a
            href="<c:url value='/auction/detail'><c:param name="auctionId" value="${auction.auctionId}"/></c:url>">
            <img src="${auction.img}" alt="Image">
         </a>
            <div>
               <c:if test="${auction.state eq 'proceeding'}">
                  <h5>Proceeding</h5>
               </c:if>

               <c:if test="${auction.state eq 'closed'}">
                  <h5>Closed</h5>
               </c:if>

               <span> &nbsp; ~ <fmt:formatDate value="${auction.endDate}"
                     pattern="yyyy-MM-dd" />
               </span>
            </div>

            <h2>
               <a
                  href="<c:url value='/auction/detail'>
                                 <c:param name="auctionId" value="${auction.auctionId}"/>
                                 </c:url>">${auction.title}</a>
            </h2>

            <span> <span>현재 최고 금액</span> &nbsp; <a href="#"><fmt:formatNumber
                     value="${auction.maxPrice}" pattern="#,###원" /></a>
            </span>

            <p>${auction.content}</p>
         </div>
      </c:forEach>

<!-- 
      <div class="col-12 mt-5 text-center">
      		<span class="p-3">1</span> <a href="#" class="p-3">2</a> <a href="#"
      		<class="p-3">3</a> <a href="#" class="p-3">4</a>
      </div>
      
       -->

   </div>
</div>