<div id="non_logger">
    <td>
        <div>
            <input type="button" onclick="inscription();" value="INSCRIPTION"/>
        </div>
        <form action="LoginServlet" method="post">
<!--            <c:if test="${estLogger==false}">
                <div>Login ou mot de passe Errone, veuillez reessayer</div>
            </c:if>-->
            LOGIN
            <label>login :</label>
            <input type="text" name="login"/>
            <label>mdp :</label>
            <input type="text" name="mdp"/>
            <input type="submit"/>
        </form>
    </td> 
</div>