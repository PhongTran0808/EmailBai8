<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="includes/header.html" %>

<div class="container">
    <h1>Join our email list</h1>
    <p>To join our email list, enter your name and email address below.</p>

    <form action="emailList" method="post">
        <input type="hidden" name="action" value="add">

        <label>Email:</label>
        <input type="email" name="email" value="${sessionScope.user.email}" required><br>

        <label>First Name:</label>
        <input type="text" name="firstName" value="${sessionScope.user.firstName}" required><br>

        <label>Last Name:</label>
        <input type="text" name="lastName" value="${sessionScope.user.lastName}" required><br>

        <input type="submit" value="Join Now">
    </form>
</div>

<%@ include file="includes/footer.jsp" %>
