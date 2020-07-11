<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.Model.Client"%>
<%@page import="com.Model.Account"%>
<%@page import="com.Model.typeAccount"%>
<%@page import="com.Model.Transaction"%>
<%@page import="com.Model.typeMove"%>
<%@page import="com.Model.Cmd"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	if (session.getAttribute("user") == null || !(session.getAttribute("user").getClass().equals(Client.class)))
	response.sendRedirect("redirectIndex.do");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="Include.html"></jsp:include>
<title>ARVO Bank - Resumen de cuenta</title>
</head>
<body>
<%@ include file="Include.html"%>
	<jsp:include page="masterMenuClient.jsp"></jsp:include>
<div class="container-fluid mt-3">
<div class="row">
 <div class="col">
   <!-- Columna vacía izquierda--> 
    </div>
    <div class="col-8">
      <h4 class="text-blue">Resumen de Movimientos</h4>
   
   <!-- Datos cuenta -->
   <table class="my-4">
   <tr>
   <td><span class="text-blue font-weight-bold">Cuenta: </span> ${account.getTypeAcc().getDescription()}</td>
   <td class="ml-4"><span class="text-blue font-weight-bold"> &nbsp &nbsp CBU: </span>${account.getCBU()}</td>
   </tr>
   </table>
   
   <!-- Resumen Movimientos -->   
 <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Fecha</th>
      <th scope="col">Tipo Movimiento</th>
      <th scope="col">Concepto</th>
      <th scope="col">Monto</th>
      <th scope="col">Saldo</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="trans" items="${transactions}">
    <tr>
      <td>${Cmd.getFormattedDate(trans.getDate(), false)}</td>
      <td> ${trans.getTm().getDescription()}</td>
      <td> ${trans.getConcept()} </td>
      <td>$ ${trans.getAmmount()}</td>
      <td>$ ${trans.getHistory()}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>        
         
  
          
    </div>
    
    
    <div class="col">
     <!-- Columna vacía derecha --> 
    </div>
    </div>
</div>

</body>
</html>