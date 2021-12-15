<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Envio do SMS</title>
</head>
<body>
	<h1>Insira sua mensagem abaixo</h1>
	<form name="disparoSMS" >
			<input type="text" name="mensagem" placeholder="Insira a mensagem aqui">
		<input type="button" value="enviar" onclick="envioSMS">
	</form>
</body>
</html>