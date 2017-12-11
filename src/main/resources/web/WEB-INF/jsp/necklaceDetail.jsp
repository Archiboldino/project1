<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>

<%@ page import="static util.Constants.NECKLACE_ATTRIBUTE_KEY" %>
<%@ page import="model.entity.Necklace" %>
<%@ page import="model.entity.Stone" %>
<%@ page import="static util.Constants.STONES_LIST_ATTRIBUTE_KEY" %>
<%@ page import="model.entity.util.NecklaceUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="static util.Constants.*" %>
<%@ page import="model.entity.PreciousStone" %>
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
    List<PreciousStone> stones = (List<PreciousStone>) request.getAttribute(STONES_LIST_ATTRIBUTE_KEY);
    ResourceBundle bundle = ((ResourceBundle) request.getAttribute(BUNDLE_ATTRIBUTE_KEY));
%>
<a href="/"><H1><%=necklace.getName()%>
</H1></a>
<div id="container">
    <div class="col">
        <H2><%=bundle.getString(BUNDLE_DETAIL_STONES_TITLE_KEY)%>
        </H2>
        <% for (int i = 0; i < necklace.getPreciousStones().size(); i++) { %>
        <div class="item">
            <%=String.format("<div>%d. %s</div>", i + 1, NecklaceUtil.sortPrice(necklace).get(i))%>
        </div>
        <%}%>
        <div id="info">
            <h3><%=bundle.getString(BUNDLE_DETAIL_WEIGHT)%> <%= NecklaceUtil.getTotalWeight(necklace)%>
            </h3>
        </div>
    </div>
    <div class="col">
        <H2><%=bundle.getString(BUNDLE_DeTAIL_ALLSTONES_TITLE)%>
        </H2>
        <form method="post" action="${pageContext.request.contextPath}/necklace">
            <% for (int i = 0; i < stones.size(); i++) { %>
            <div class="item">
                <input type="submit" name="stoneId" value="<%=stones.get(i).getId()%>">
                <%=String.format("<div> %s</div>", stones.get(i))%>
            </div>
            <%} %>
        </form>
    </div>
</div>
</body>
</html>
