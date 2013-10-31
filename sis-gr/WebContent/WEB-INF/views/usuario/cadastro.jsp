<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
		<div class="hero-unit">
	<div class="row-fluid">
		<div class="span3"></div>
			<div class="span6" align="center">
				<div class="area">
				<c:if test="${empty editar}">
					<form:form commandName="Cadastro" class="form-horizontal" action="cadastro"
						method="POST">
						<div class="heading">
							<h2>Cadastre-se!</h2>
							<hr>
						</div>					
						<div class="control-group">
							<label class="control-label" for="nome">Nome</label>
							<div class="controls">
								<input type="text" name="nome" id="nome" placeholder="Seu nome"></input> 
							</div>
						</div>
						<form:errors class="alert alert-error" path="nome"></form:errors>
						<div class="control-group">
						<br />
							<label class="control-label" for="nome">Sobrenome</label>
							<div class="controls">
								<input type="text" name="sobrenome" id="sobrenome"
									placeholder="Seu sobrenome">
							</div>
						</div>
						<form:errors class="alert alert-error" path="sobrenome"></form:errors>
						<div class="control-group">
						<br />
							<label class="control-label" for="email">Email</label>
							<div class="controls">
								<input type="text" name="email" id="email"
									placeholder="email@exemplo.com">
							</div>
						</div>
						<form:errors class="alert alert-error" path="email"></form:errors>
						<div class="control-group">
						<br />
							<label class="control-label" for="senha">Senha</label>
							<div class="controls">
								<input type="password" name="senha" id="senha"
									placeholder="Defina sua senha">
							</div>
						</div>									
						<form:errors class="alert alert-error" path="senha"></form:errors>
            			<hr>
						<div>
								<button type="submit" class="btn btn-info">Cadastrar</button>
							
						</div>
					</form:form>
					</c:if>
					<c:if test="${not empty editar}">
					<form:form commandName="Cadastro" class="form-horizontal" action="cadastro"
						method="POST">
						<div class="heading">
							<h2>Editar!</h2>
							<hr>
						</div>					
						<td><input type="hidden" value="${editar.id}" name="id" id="id"/></td>
						<div class="control-group">
							<label class="control-label" for="nome">Nome</label>
							<div class="controls">
								<input type="text" name="nome" id="nome" value="${editar.nome}"></input> 
							</div>
						</div>
						<form:errors class="alert alert-error" path="nome"></form:errors>
						<div class="control-group">
						<br />
							<label class="control-label" for="nome">Sobrenome</label>
							<div class="controls">
								<input type="text" name="sobrenome" id="sobrenome"
									value="${editar.sobrenome}">
							</div>
						</div>
						<form:errors class="alert alert-error" path="sobrenome"></form:errors>
						<div class="control-group">
						<br />
							<label class="control-label" for="email">Email</label>
							<div class="controls">
								<input type="text" name="email" id="email"
									value="${editar.email}">
							</div>
						</div>
						<form:errors class="alert alert-error" path="email"></form:errors>
						<div class="control-group">
						<br />
							<label class="control-label" for="senha">Senha</label>
							<div class="controls">
								<input type="hidden" name="senha" id="senha"
									value="${editar.senha}">
							</div>
						</div>									
						<form:errors class="alert alert-error" path="senha"></form:errors>
            			<hr>
						<div>
								<button type="submit" class="btn btn-info">Editar</button>
								<a href="/sis-gr/agenda"><input type="button" name="cancelar" value="Cancelar" /></a>
							
						</div>
						</form:form>
						</c:if>
				</div>
				<div class="span3"></div>
			</div>
		</div>
	</div>

</div>