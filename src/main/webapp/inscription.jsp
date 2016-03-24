<%-- 
    Document   : Ajouter_utilisateur
    Created on : 10 mars 2016, 15:13:23
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${etatInscription==false}">
    <div>
        Login deja utilise, utilisez un autre login s'il vous plait !
    </div>
</c:if>
<form action="InscriptionJoueurServlet" method="post">
    <label>Login</label>
    <input type="text" name="login"/>
    <br>
    <label>Mot de passe</label>
    <input type="text" name="mdp"/>
    <br>
    <input type="submit"/>
</form>