<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="includes/header.html" %>

<div class="thanks-container">
    <h2>Thanks for joining our email list!</h2>
    <p><b>Email:</b> ${sessionScope.user.email}</p>
    <p><b>First Name:</b> ${sessionScope.user.firstName}</p>
    <p><b>Last Name:</b> ${sessionScope.user.lastName}</p>

    <hr>
    <h3>Extra Info:</h3>
    <p><b>Current Year:</b> ${requestScope.currentDate}</p>
    <p><b>First User Email:</b> ${sessionScope.users[0].email}</p>
    <p><b>Customer Service Email:</b> ${initParam.custServEmail}</p>

    <form action="index.jsp" method="get">
        <input type="submit" value="Return">
    </form>
</div>

<%@ include file="includes/footer.jsp" %>
