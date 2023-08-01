<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import ="Model.Contato_Model" %>
	
	<%
	Contato_Model contato = (Contato_Model)request.getAttribute("editar");
	
	
	%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Editar Contado</title>
<!-- linha que torna um icone como favorito, ou seja o icone que fuca do lad-->
<link rel="icon" href="imagens/agenda.png">
<!--cria um link entre esta pÃ¡gina com a pÃ¡gina css-->
<link rel="stylesheet" href="style.css">
</head>

<body>
	<h1>Editar contato</h1>
	<form name="NomeDoForm" action="update">
		<table>
		<tr>
				<td><input type="number" name="idcon" id="caixa3" value="<% out.print(contato.getIdcon()); %>" required readonly>
				</td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="caixa1" value="<% out.print(contato.getNome());%>" required>
				</td>
			</tr>
			<tr>
				<td><input type="text" name="fone" class="caixa2" value="<% out.print(contato.getFone()); %>" required>
				</td>
			</tr>
			<tr>
				<td><input type="email" name="email" class="caixa1" value= "<% out.print(contato.getEmail());%>"required>
				</td>
			</tr>
		</table>
		<input type="submit" value="Editar" class="acessar"
			onclick="validar()">
	</form>
	<script src="scripts/Validador.js"></script>
</body>

</html>