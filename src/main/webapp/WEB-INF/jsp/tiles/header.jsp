<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>Jasmine</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="Cache-Control" content="max-age=0">
  <meta http-equiv="Cache-Control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT">
  <meta http-equiv="Pragma" content="no-cache">
  <link rel="stylesheet" href="../style/jasmine.css" type="text/css" />
</head>
<body bgcolor="white">

	<table id="header"> <!--  class="top"> -->
	  <tr>
	      <td class="top_logo" width="10%">
	        <a href="/index">
	          <img border="0" src="/images/logo.png" /></a>
	      </td>
	      <td style="text-align:right" width="63%">
	       	<img border="0" name="img_magicine" src="/images/magicine2.gif"/>
	      </td>
	      <td style="text-align:right" width="27%">
				<c:if test="${empty userSession.user}" > <!-- no login -->
			        <a href="/user/cart">
			          		<img border="0" name="img_cart" src="/images/cart.png" /></a>
			           	<img border="0" src="/images/separator.gif" />
			           	<a href="/user/mypage">
			            	<img border="0" name="img_mypage" src="/images/mypage.png" /></a> 
			         	<img border="0" src="/images/separator.gif" />
			            <a href="/user/login">
			            	<img border="0" name="img_join" src="/images/login.png" /></a>	
				</c:if>
			    <c:if test="${!empty userSession.user}" > <!-- login -->
			    	<c:if test="${isManager==true}" ><!-- manager -->
		    			<img border="0" src="/images/isManager.png" alt="isManager" />
			    	</c:if>
				     <c:if test="${isManager==false}"> 
						<a href="/user/cart">
			          		<img border="0" name="img_cart" src="/images/cart.png" /></a>
			           	<img border="0" src="/images/separator.gif" />
			           	<a href="/user/mypage">
			            	<img border="0" name="img_mypage" src="/images/mypage.png" /></a> 
			         	<img border="0" src="/images/separator.gif" />
			         </c:if>
			         <a href="/user/logout">
			            <img border="0" name="img_logout" src="/images/logout.png" />
			         </a>	  
			    </c:if>
	 		</td>
	    </tr>
	</table>
