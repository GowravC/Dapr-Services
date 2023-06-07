<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Shopping Deatils</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>


<body>
	<div style="margin: 20%, auto;">
		<table class="table table-hover"
			style="text-align: center; background-color: hsla(0, 0%, 96%, 0.8); width: 60%;">

			<tbody id="tbody">
				<tr>
					<th></th>
					<th>ShoppingData</th>
					<th></th>
				</tr>

				<tr>
					<td><c:out value="${shop.customerName}" /></td>
					<td><c:forEach var="prod" items="${shop.products}">
							<c:out value="${prod}"></c:out>
						</c:forEach></td>
					<td><c:out value="${shop.totalAmt}" /></td>
					<td><c:out value="${shop.paymentMode}" /></td>
				</tr>
			</tbody>
		</table>

	</div>


</body>
</html>

