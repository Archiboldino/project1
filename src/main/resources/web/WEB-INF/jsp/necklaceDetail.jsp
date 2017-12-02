<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="static util.Constants.NECKLACE_ATTRIBUTE_KEY" %>
<%@ page import="model.entity.Necklace" %>
<%@ page import="model.entity.Stone" %>
<%@ page import="static util.Constants.STONES_LIST_ATTRIBUTE_KEY" %>
<%@ page import="java.util.List" %>
<%@ page import="static util.Constants.NECKLACES_LIST_ATTRIBUTE_KEY" %>
<%@ page import="util.NecklaceUtil" %>
<%@ page import="static util.NecklaceUtil.getTotalWeight" %>
<html>
<head>
    <title><%out.print(((Necklace) request.getAttribute(NECKLACE_ATTRIBUTE_KEY)).getName());%></title>
    <style>
        <%@include file="css/style.css"%>
    </style>
</head>
<body>
    <%
        Necklace necklace = ((Necklace) request.getAttribute(NECKLACE_ATTRIBUTE_KEY));
        List<Stone> stones = (List<Stone>) request.getAttribute(STONES_LIST_ATTRIBUTE_KEY);
    %>
    <a href="/"><H1><%out.print(necklace.getName());%></H1></a>
    <div id="container">
        <div class="col">
            <H2>STONES IN NECKLACE</H2>
            <% for (int i = 0; i < necklace.getPreciousStones().size(); i++) { %>
            <div class="item">
                <%out.println(String.format("<div>%d. %s</div>", i + 1, necklace.getPreciousStones().get(i)));%>
            </div>
            <%}%>
            <div id="info">
                <h3>Weight: <%= NecklaceUtil.getTotalWeight(necklace)%></h3>
            </div>
        </div>
        <div class="col">
            <H2>ALL STONES</H2>
            <form method="post" action="${pageContext.request.contextPath}/necklace">
            <% for (int i = 0; i < stones.size(); i++) { %>
            <div class="item">
                <input type="submit" name="stoneId" value="<%=i%>" >
                <%=String.format("<div> %s</div>", stones.get(i))%>
            </div>
            <%} %>
            </form>
        </div>
    </div>
</body>
</html>
