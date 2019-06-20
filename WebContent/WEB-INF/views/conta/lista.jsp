<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript">

	function deuCerto(dadosDaResposta){
		alert("Conta paga com sucesso!");
	}

	function pagaAgora(id){
		$.get("pagaConta?id=" + id, deuCerto);
	}

</script>
</head>
<body>

	<table>
		<tr>
			<th>Código</th>
			<th>Descrição</th>
			<th>Valor</th>
			<th>Tipo</th>
			<th>Pago?</th>
			<th>Data de Pagamento</th>
		</tr>

		<c:forEach items="#{listaContas}" var="conta">
			<tr>
				<td>${conta.id}</td>
				<td>${conta.descricao}</td>
				<td>${conta.valor}</td>
				<td>${conta.tipo}</td>
				<td>
					<c:if test="${conta.paga eq false}">
						Não paga
					</c:if>
					<c:if test="${conta.paga eq true}">
						Paga!
					</c:if>
				</td>
				<td>
					<fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyy"/>
				</td>
				<td>
					<a href="removeConta?id=${conta.id}">Excluir</a> |
					
					<c:if test="${conta.paga eq false}">
						<a href="#" onclick="pagaAgora(${conta.id});">Pagar</a>
					</c:if> 
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>