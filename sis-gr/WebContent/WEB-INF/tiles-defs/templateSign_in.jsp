
<%-- Pagina define o template da aplicacao, no Tiles. --%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=8" />

<spring:url value="/resources/css/bootstrap.min.css" var="bootstrap_url" />
<spring:url value="/resources/css/springmvc_gae.css" var="css_url" />

<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapjs_url" />
<spring:url value="/resources/js/jquery-1.7.2.min.js" var="jquery_url" />
<spring:url value="/resources/js/jquery.validate.min.js"
	var="jquery_validate_url" />

<link rel="stylesheet" type="text/css" media="screen"
	href="${bootstrap_url}" />
<link rel="stylesheet" type="text/css" media="screen" href="${css_url}" />

<script type="text/javascript" src="${bootstrapjs_url}"></script>
<script type="text/javascript" src="${jquery_url}"></script>
<script type="text/javascript" src="${jquery_validate_url}"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>

<script src='resources/js/bootstrap.min.js'></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src='resources/js/jquery-ui.custom.min.js'></script>

<link href='resources/fullcalendar/fullcalendar.css' rel='stylesheet' />
<link href='resources/fullcalendar/fullcalendar.print.css'
	rel='stylesheet' media='print' />
<script src='resources/lib/jquery.min.js'></script>
<script src='resources/js/jquery-ui.custom.min.js'></script>
<script src='resources/fullcalendar/fullcalendar.min.js'></script>
<script>
	$(document).ready(function() {

		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();

		var calendar = $('#calendar').fullCalendar({
			header : {
				left : 'prev,next today',
				center : 'title',
				right : 'month,agendaWeek,agendaDay'
			},
			selectable : true,
			selectHelper : true,
			select : function(start, end, allDay) {
				var title = prompt('Event Title:');
				if (title) {
					calendar.fullCalendar('renderEvent', {
						title : title,
						start : start,
						end : end,
						allDay : allDay
					}, true // make the event "stick"
					);
				}
				calendar.fullCalendar('unselect');
			},monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
			monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
			dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
			dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb'],
			buttonText: {
				prev: '&nbsp;&#9668;&nbsp;',
				next: '&nbsp;&#9658;&nbsp;',
				prevYear: '&nbsp;&lt;&lt;&nbsp;',
				nextYear: '&nbsp;&gt;&gt;&nbsp;',
				today: 'hoje',
				month: 'mês',
				week: 'semana',
				day: 'dia'
			},		
			titleFormat: {
				month: 'MMMM yyyy',
				week: "d [ yyyy]{ '&#8212;'[ MMM] d MMM yyyy}",
				day: 'dddd, d MMM, yyyy'
			},
			columnFormat: {
				month: 'ddd',
				week: 'ddd d/M',
				day: 'dddd d/M'
			},
			allDayText: 'dia todo',
			axisFormat: 'H:mm',
			timeFormat: {
				'': 'H(:mm)',
				agenda: 'H:mm{ - H:mm}'
			},
			editable : true,
			events : [ {
				title : 'All Day Event',
				start : new Date(y, m, 1)
			}, {
				title : 'Long Event',
				start : new Date(y, m, d - 5),
				end : new Date(y, m, d - 2)
			}, {
				id : 999,
				title : 'Repeating Event',
				start : new Date(y, m, d - 3, 16, 0),
				allDay : false
			}, {
				id : 999,
				title : 'Repeating Event',
				start : new Date(y, m, d + 4, 16, 0),
				allDay : false
			}, {
				title : 'Meeting',
				start : new Date(y, m, d, 10, 30),
				allDay : false
			}, {
				title : 'Lunch',
				start : new Date(y, m, d, 12, 0),
				end : new Date(y, m, d, 14, 0),
				allDay : false
			}, {
				title : 'Birthday Party',
				start : new Date(y, m, d + 1, 19, 0),
				end : new Date(y, m, d + 1, 22, 30),
				allDay : false
			}, {
				title : 'Click for Google',
				start : new Date(y, m, 28),
				end : new Date(y, m, 29),
				url : 'http://google.com/'
			} ]
		});

	});
</script>
<!-- // -->
<style>
body {
	
	text-align: center;
	font-size: 14px;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
}

#calendar {
	width: 735px;
	margin: 0 auto;
}
</style>
<title>SisGR</title>
</head>

<body>
	<div class="header">
		<div class="container">
			<tiles:insertAttribute name="header" ignore="true" />  
		</div>
	</div>

	<div class="container">
		<div class="row-fluid">
			<div class="span2">
				<tiles:insertAttribute name="menu" />
			</div>
			<div class="span10">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>
	<footer>
		<tiles:insertAttribute name="footer" ignore="true" />
	</footer>
</body>
</html>