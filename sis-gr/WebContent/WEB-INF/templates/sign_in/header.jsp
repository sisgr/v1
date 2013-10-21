<div class="navbar">

	<div class="row-fluid">
		<div class="span12">
			<div class="span3">
				<h1 class="muted">SisGR</h1>
			</div>
			<div class="span8">
				<h2 class="muted">Gerenciamento de Reuniões</h2>
			</div>
		</div>
	</div>

	<div class="navbar-inner">
		<div class="container-fluid">
			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li><a href="inicio"><i class="icon-home"></i>Home</a></li>
					<li class="divider-vertical"></li>
				</ul>
				<ul class="nav pull-right">
					<li><a>Bem Vindo!</a></li>
					<li class="divider-vertical"></li>
					<li class="dropdown"><a class="dropdown-toggle" href="#"
						data-toggle="dropdown">Sua conta<strong class="caret"></strong></a>


						<ul class="dropdown-menu" >
							<li><a href="/user/preferences" ><i class="icon-cog"></i>
									Preferências</a></li>
							<li><a href="#"><i class="icon-envelope"></i>
									Contato Suporte</a></li>
							<li class="divider"></li>
							<li><a href="sair"><i class="icon-off"></i>
									Sair</a></li>
						</ul>
						
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid -->
	</div>
	<!--/.navbar-inner -->
</div>
<!--/.navbar -->

<script>
	$(document).ready(function() {
		//Handles menu drop down
		$('.dropdown-menu').find('form').click(function(e) {
			e.stopPropagation();
		});
	});
</script>