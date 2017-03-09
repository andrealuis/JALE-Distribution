<table>
  <c:forEach var="atraccion" items="${formaAtraccion.atraccion}">
    <tr>
      <td><c:out value="${atraccion.nombreAtraccion}"/></td>
    </tr>
    <tr>
      <td><img src="/images/ImanegesAtracciones/${atraccion.path}.jpg" height="70" width="70"></td>
  </c:forEach>        

</table>  