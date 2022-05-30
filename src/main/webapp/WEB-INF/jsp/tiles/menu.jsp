<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <table class="t1">
  <tr>
	  <td rowspan="2">
	  	<table class="t1-1">
	  		<tr>
	  			<th>
	           		<img border="0" name="img_signin" src="images/menu.png" /></a>
		  		</td>
			</tr>
			<c:if test="${user.isManager==true}" ><!-- manager -->		
				<tr>
			  		<td> 
			  			<a href="manager/user">
		           		<img border="0" name="img_signin" src="images/user_menu.png" /></a>
			  		</td>
				</tr>
				<tr>
			  		<td> 
			  			<a href="manager/bookDelete">
		           		<img border="0" name="img_signin" src="images/book_menu.png" /></a>
			  		</td>
				</tr>
				<tr>
					<td>
			  			<a href="manager/auctionDelete">
		            	<img border="0" name="img_signin" src="images/auction_menu.png" /></a>
			  		</td>
				</tr>
				<tr>
					<td>
				  		<a href="manager/communityDelete">
			            <img border="0" name="img_signin" src="images/community_menu.png" /></a>
			  		</td>
				</tr>
			</c:if>
			<%-- <c:if test="${user.isManager==false}" > --%><!-- user -->		
				<tr>
			  		<td> 
			  			<a href="book/list">
		           		<img border="0" name="img_signin" src="images/book_menu.png" /></a>
			  		</td>
				</tr>
				<tr>
					<td>
			  			<a href="auction/list">
		            	<img border="0" name="img_signin" src="images/auction_menu.png" /></a>
			  		</td>
				</tr>
				<tr>
					<td>
				  		<a href="community/list">
			            <img border="0" name="img_signin" src="images/community_menu.png" /></a>
			  		</td>
				</tr>
			<%-- </c:if> --%>
	  	</table>
	  </td>
  </tr>
    <tr>
      <td valign="top" width="100%">
        
      

