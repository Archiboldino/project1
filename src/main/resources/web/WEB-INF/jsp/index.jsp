<%@ page import="model.entity.Stone" %>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.Necklace" %>

<%@ page import="static util.Constants.STONES_LIST_ATTRIBUTE_KEY" %>
<%@ page import="static util.Constants.NECKLACES_LIST_ATTRIBUTE_KEY" %>

<html lang="java">
    <head>
        <title>Test Index</title>
        <style>
            <%@include file="css/style.css"%>
        </style>
    </head>
    <body>
    <div id="container">
        <%
            List<Stone> stones = (List<Stone>) request.getAttribute(STONES_LIST_ATTRIBUTE_KEY);
            List<Necklace> necklaces = (List<Necklace>) request.getAttribute(NECKLACES_LIST_ATTRIBUTE_KEY);
        %>
        <div class="col">
            <h3>NECKLACES</h3>
            <% for (int i = 0; i < necklaces.size(); i++) { %>
                <a href="/necklace?id=<%out.print(i);%>" class="item"><%out.println(String.format("<div>%d. %s</div>", i + 1, necklaces.get(i)));%></a>
            <%} %>
        </div>
        <div class="col">
            <h3>STONES</h3>
            <% for (int i = 0; i < stones.size(); i++) { %>
                <div class="item"><%out.println(String.format("<div>%d. %s</div>", i + 1, stones.get(i)));%></div>
            <%} %>
        </div>
        <form method="post" action="${pageContext.request.contextPath}/}">
            <input type="text" name="necklaceName" placeholder="Necklace Name">
            <input type="submit" value="Add Necklace">
        </form>
    </div>
    </body>
</html>
