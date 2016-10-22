<%-- 
    Document   : protect
    Created on : May 5, 2016, 9:39:58 AM
    Author     : joanne.ong.2014
--%>

<%@page import="entity.Driver"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    // check if user is authenticated

    Driver user = (Driver) session.getAttribute("loggedInUser");
    if (user == null) {
        response.sendRedirect("Login.jsp");
        return;
    }


%>
