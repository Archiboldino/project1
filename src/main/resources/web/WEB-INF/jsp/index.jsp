<%@ page pageEncoding="UTF-8" %>

<%@ page import="model.entity.Necklace" %>
<%@ page import="model.entity.Stone" %>
<%@ page import="java.util.List" %>

<%@ page import="static util.Constants.STONES_LIST_ATTRIBUTE_KEY" %>
<%@ page import="static util.Constants.NECKLACES_LIST_ATTRIBUTE_KEY" %>
<%@ page import="static util.Constants.NECKLACE_DETAIL_URL" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="static util.Constants.*" %>

<html lang="<%=request.getLocalName()%>">
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
        ResourceBundle bundle = ((ResourceBundle) request.getAttribute(BUNDLE_ATTRIBUTE_KEY));
    %>
    <div class="col">
        <h3><%=bundle.getString(BUNDLE_INDEX_NECKLACES_TITLE)%>
        </h3>
        <% for (int i = 0; i < necklaces.size(); i++) { %>
        <a href="${pageContext.request.contextPath}<%=NECKLACE_DETAIL_URL%><%=i%>" class="item">
            <%=String.format("<div>%d. %s</div>", i + 1, necklaces.get(i))%>
        </a>
        <%} %>
    </div>
    <div class="col">
        <h3><%=bundle.getString(BUNDLE_INDEX_STONES_TITLE)%>
        </h3>
        <% for (int i = 0; i < stones.size(); i++) { %>
        <div class="item"><%=String.format("<div>%d. %s</div>", i + 1, stones.get(i))%>
        </div>
        <%} %>
    </div>
    <form method="post" action="${pageContext.request.contextPath}/}">
        <input type="text" name="necklaceName"
               placeholder="<%=bundle.getString(BUNDLE_INDEX_NECKLACE_INPUT_PLACEHOLDER)%>">
        <input type="submit" value="<%=bundle.getString(BUNDLE_INDEX_NECKLACE_ADDBUTTON)%>">
    </form>
</div>
</body>
</html>
