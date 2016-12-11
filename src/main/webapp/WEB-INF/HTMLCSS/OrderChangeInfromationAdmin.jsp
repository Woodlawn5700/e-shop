<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pavelpetrov
  Date: 14.10.16
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Change Information</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>

<c:import url="Header.jsp"/>

<div class="container">
<table class="table table-hover">
    <thead>
    <tr>
        <th class="text-left">Client</th>
        <th class="text-left">Payment Method</th>
        <th class="text-left">Payment State</th>
        <th class="text-left">Order State</th>
        <th class="text-left">Delivery Method</th>
        <th class="text-left">Date of order</th>
        <th class="text-left">Comments</th>
    </tr>
    </thead>

    <c:set var="orderAdminList" value="${orderToChange}"></c:set>

    <tbody class="table-hover">
    <tr>
        <td class="text-left">${orderAdminList.client.login}</td>
        <td class="text-left">${orderAdminList.paymentMethod.paymetnMethod}</td>
        <td class="text-left">${orderAdminList.paymentState.paymentState}</td>
        <td class="text-left">${orderAdminList.orderState.orderState}</td>
        <td class="text-left">${orderAdminList.deliveryMethod.deliveryMethod}</td>
        <td class="text-left">${orderAdminList.dateOfOrder}</td>
        <td class="text-left">${orderAdminList.comments}</td>
    </tr>
    </tbody>
</table>

<hr>

<form action="/admin/OrderStatusChangerServlet" method="post">
    <div class="container">
        <div class="left">
            <p>State of this order is  <strong><c:out value="${orderAdminList.orderState.orderState}"/> </strong></p>
        </div>
        <div class="center">
            <p><select name="changeOrder" id="sort">
                <option value="in the stock" id="inTheStoc">In the stock</option>
                <option value="sent" id="sent">Sent</option>
                <option value="delivered" id="dalivered">Delivered</option>
            </select>
            </p>
        </div>
        <div class="right">
            <p>
                <button type="submit" id="buttonStateOrder">Change Order State</button>
            </p>
        </div>
    </div>
</form>

<hr>

<form action="/admin/OrderPaymentStateChangerServlet" method="post">
    <div class="container">
        <div class="left">
            <p>Payment state of order is <strong> <c:out value="${orderAdminList.paymentState.paymentState}"/></strong> </p>
        </div>
        <div class="center">
            <p><select name="cahngePaymentState" id="selectPaymentState">
                <option value="paid">Paid</option>
                <option value="wait for payment">Wait for payment</option>
            </select>
            </p>
        </div>
        <div class="right">
            <p>
                <button type="submit">Change Order State</button>
            </p>
        </div>
    </div>
</form>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>
