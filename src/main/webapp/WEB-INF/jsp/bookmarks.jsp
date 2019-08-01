<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>

<html>

<head>
    <title>Bookmarks</title>
</head>

<body>

    <h1>Welcome to bookmarks.</h1>
    This is a place that lists many resources useful for generating your Java project.<br/>
    You can browse the list, search by category, or add new bookmarks to share with your peers.<br/>

    <!--If bookmarks is missing from the model, the rest just silently won't load.-->
    <!--Since that's confusing, instead of silently skipping the render, explain that something is wrong -->
    <c:if test = "${bookmarks == null}">
        <p>Something went wrong. Unable to load bookmarks</p>
    </c:if>

    <br/><br/>
    Number of bookmarks currently in the system: ${count}.

    <ul>
    <c:forEach items="${bookmarks}" var="bookmark">
        <c:if test="${bookmark.webAddress == null}">
            <li><c:out value="${bookmark.title}"/></li>
        </c:if>
        <c:if test="${bookmark.webAddress != null}">
            <li><a href="${bookmark.webAddress}">
                <c:out value="${bookmark.title}"/>
            </a></li>
        </c:if>
    </c:forEach>
    </ul>

    <form method="post" action="/bookmarks/new">
        Description: <input type="text" name="bookmarkDescription" />
        <br/>Web Address: <input type="text" name="bookmarkAddress" />
        <br/><input type="submit" value="Add this bookmark"/>

    </form>

</h1>
</head>
<body>

</body>
</html>