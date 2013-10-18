<%-- Fragmento com trecho utilizado no cabecalho das paginas. --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="navbar" style="background-color: #ffffff">
	<spring:url var="banner" value="/resources/img/logotipo.png" />

	<div class="navbar-inner">
		<ul class="nav">
			<li><img src="${banner}" class="img-rounded" /></li>
			
			<li><h2 class="title" align="justify">SisGR - Sistema de Gerenciamento de Reuniões</h2></li>
			
		</ul>
	</div>
			
	
</div>