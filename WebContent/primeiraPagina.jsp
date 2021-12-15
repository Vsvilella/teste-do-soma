<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
//for (int i = 0; i<lista.size();i++){
//out.println(lista.get(i).getId());
//out.println(lista.get(i).getNome());
//out.println(lista.get(i).getFone());
//}
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Apresentacao</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<!-- 	<a href="novoContato.html">Novo contato</a> -->
	<table class="table table-striped">
		<thead>
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Nome</th>
			<th scope="col">Fone</th>
			<th scope="col">Opções</th>
			
<!-- 			<th scope="col">Opções</th> -->
		</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++) { %>
			<tr>
				<td><%=lista.get(i).getId()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getFone()%></td>
				<td><a href="javascript:confirmar(<%=lista.get(i).getId()%>)">Excluir</a> | 
				<a href="javascript:envioSMS(<%=lista.get(i).getFone()%>)">Enviar SMS</a>
				
<!-- 				<button class="btn btn-primary" onclick="dispararSMS()">Enviar SMS</button> -->
<%-- 				<input type="hidden" id="testanumero" readonly value="<%=lista.get(i).getFone()%>"/> --%>
				
			</tr>
			<% } %>
		</tbody>
		
		
	</table>
	<a style="font-align:center;" href="novoContato.html">Novo contato</a><br><br>
	Digite a mensagem que você quer enviar: 
	<input type="text" class="form-control" id="mensagem">
	Resultado:
	<input type="text" class="form-control" readonly id="result" value=""/>
<script src="scripts/Confirmador.js"></script>
<script src="scripts/EnvioSMS.js"></script>
</body>
</html>