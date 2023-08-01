<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Model.Contato_Model"%>
<%@ page import="java.util.ArrayList"%>
<%
@ SuppressWarnings ("unchecked")
ArrayList<Contato_Model> lista = (ArrayList<Contato_Model>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="imagens/telefone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda</h1>
	<a href="Novo.html" class="acessar"> Novo Contato</a>
	<a href="report" class="acessar2">Relatório</a>
	<table id="tabela">
		<thead>
			<tr>
			<th><span class = "th">id</span></th>
			<th>Nome</th>
			<th>Telefone</th>
			<th>Email</th>
			
			</tr>
		</thead>
		<tbody>
		<% for (Contato_Model contato : lista){%>
			<tr>
			<td><%=contato.getIdcon()%></td>
			<td><%=contato.getNome()%></td>
			<td><%=contato.getFone()%></td>
			<td><%=contato.getEmail()%></td>
			<td><a href="select?idcon= <%= contato.getIdcon()%>"><img  src="imagens/lapis.png"></a></td>
			<td><a href="javascript: confirmar(<%= contato.getIdcon()%>) "><img  src="imagens/lixeira.png"></a></td>
			</tr>
			
			<%} %>
		</tbody>
	</table>
	
	<script src="scripts/confirmador.js"> </script>
</body>
</html>