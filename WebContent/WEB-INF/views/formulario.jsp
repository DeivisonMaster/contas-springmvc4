<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Adicionar Contas</h3>

	<form action="adicionaConta" method="POST">
	
		<label>Descrição:</label>
		<textarea name="descricao" rows="5" cols="100"></textarea>	
		<form:errors path="conta.descricao"/>
		<br/>
		
		<label>Valor:</label>
		<input type="text" name="valor"/>
		<br/>
		
		<label>Tipo:</label>
		<select name="tipo">
			<option value="ENTRADA">Entrada</option>
			<option value="SAIDA">SAIDA</option>
		</select>
		<br/>
		
		<input type="submit" value="adicionar"/>
	</form>

</body>
</html>