<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>

<%--
Redirect default requests to Welcome global ActionForward.
By using a redirect, the user-agent will change address to match the path of our Welcome ActionForward. 
--%>

<logic:redirect forward="welcome" />