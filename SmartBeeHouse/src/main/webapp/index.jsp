<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue dans SmartBeeHouse</title>
</head>
<body>
    <h1>Bienvenue dans le système SmartBeeHouse !</h1>
    <p>Ceci est notre première page JSP fonctionnelle.</p>
    <%
        // Exemple de code Java dans JSP (à éviter pour la logique complexe)
        String message = "La date actuelle est : " + new java.util.Date();
        out.println("<p>" + message + "</p>");
    %>
</body>
</html>