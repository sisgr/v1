<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container">
		<div class="hero-unit">
	<div class="row-fluid">
		<div class="span3"></div>
			<div class="span6" align="center">
				<div class="area">
					<form class="form-horizontal" action="adicionaUsuario"
						method="POST">
						<div class="heading">
							<h2>Cadastre-se!</h2>
							<hr>
						</div>
						
						
						<div class="control-group">
							<label class="control-label" for="nome">Nome <form:errors path="nome"/></label>
							<div class="controls">
								
								<input type="text" name="nome" id="nome" placeholder="Seu nome"> 
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="sobrenome">Sobrenome</label>
							<div class="controls">
								<input type="text" name="sobrenome" id="sobrenome"
									placeholder="Seu sobrenome">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="email">Email</label>
							<div class="controls">
								<input type="text" name="email" id="email"
									placeholder="email@exemplo.com">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="senha">Senha</label>
							<div class="controls">
								<input type="password" name="senha" id="senha"
									placeholder="Defina sua senha">
							</div>
						</div>
						<hr>
						<div>
								<button type="submit" class="btn btn-success">Cadastrar</button>
							
						</div>
					</form>
				</div>
				<div class="span3"></div>
			</div>
		</div>
	</div>

</div>