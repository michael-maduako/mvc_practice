<%@ page import="com.michael.general_page_module.LoginBean"%>

<%
LoginBean bean=(LoginBean) session.getAttribute("abc");
out.print("Welcome, "+ bean.getUsername());

%>

<form action="logout" method="post">
<input type="submit" value="Logout"/>
</form>
