<!DOCTYPE html>

<html lang="fr">
	<head>
	    <title>Bienvenue</title>
	    <meta charset="UTF-8">  
	  	<meta name="viewport" content="width=device-width, initial-scale=1">
	    
		<!--  CSS nécessaires à la plupart des pages  -->
		<%@include file="includes/includeCSSProjet.jsp" %>
		<!-- CSS nécessaire à l'utilisation du composant fullcalendar  -->
		<link rel="stylesheet" href="fullcalendar/fullcalendar.css" />
	
	</head>
	
	<body data-spy="scroll" data-target="#myScrollspy" data-offset="15">
	
		<nav class="navbar navbar-default">
			<div class="container-fluid">
		    	<div class="navbar-header">
		      		<a class="navbar-brand" href="#">Bengor Website</a>
		    	</div>
		    	<ul class="nav navbar-nav">
		    		<li class="active"><a href="#">Home</a></li>
		    	</ul>
			</div>
		</nav>
		<div class="container">
		    <div class="row">
		    	<!-- Header-->
		        <div class="col-xs-12">
		        
		        </div>
		    </div>
		    <div class="row">
		    
		    	<!-- Side -->
		        <div class="col-md-2">
		        	<div class="panel panel-default ">
	    				<div class="panel-heading">Options</div>
				        <div class="panel-body">
 							<button type="button" class="btn btn-info" data-toggle="modal" data-target="#EventsDetailModal">Today's events<span class="badge">3</span></button>
				        </div>
			        </div>
		        </div>
		        
		        
		    	<!-- Main panel -->
		        <div class="col-md-10 ">
		        
		        	<div class="panel panel-default ">
	    				<div class="panel-heading">Calendrier</div>
				        <div class="panel-body" id='calendar'></div>
			        </div>
			        
		        </div>
		    </div>
				
		</div>
		
		
		<!-- Event's details Modal -->
		<div class="modal fade" id="EventsDetailModal" role="dialog">
		  	<div class="modal-dialog">
		    
		    	<!-- Modal content-->
			    <div class="modal-content">
			    
			    	<div class="modal-header">
			        	<button type="button" class="close" data-dismiss="modal">&times;</button>
			        	<h4 class="modal-title">Today's events details</h4>
			        </div>
			        
			        <div class="modal-body">
			        	
						<div class="panel panel-danger">
							<div class="panel-heading">Very Important Buisness Meeting</div>
							<div class="panel-body">15:00 at Incity Tower</div>
						</div>
							
						<div class="panel panel-warning">
							<div class="panel-heading">Buy a gift for Mum</div>
							<div class="panel-body">12:00 at La Part-Dieu</div>
						</div>
						
			        	<div class="panel panel-info">
							<div class="panel-heading">Have a beer with Ted</div>
							<div class="panel-body">20:30 at St Patrick's pub (Lyon)</div>
						</div>
			        	
			        </div>
			        
			        <div class="modal-footer">
			        	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        </div>
			        
		    	</div>
		  	</div>
		</div>
		
		<!-- Scripts nécessaires à la plupart des pages -->
		<%@include file="includes/includeJSProjet.jsp" %>
		<!-- Script nécessaire à l'utilisation du composant fullcalendar  -->
		<script src='fullcalendar/fullcalendar.js'></script>
		
	</body>
</html>

<script>

$( document ).ready(function() {
	
		var today = new Date();
		
		console.log(today);
		// expected output: 2011-10-05T14:48:00.000Z
		var todayString = today.toISOString();

  		// page is now ready, initialize the calendar...

 		 $('#calendar').fullCalendar({
 			  events: [
 				    {
 				      title  : 'Very Important Buisness Meeting',
 				      backgroundColor : '#f2dede',
 				      borderColor : '#ebccd1',
 				      textColor : '#333',
 				      start  : todayString
 				    },
 				    {
 				      title  : 'Buy a gift for Mum',
 				      backgroundColor : '#fcf8e3',
 				      borderColor : '#faebcc',
 				      textColor : '#333',
 				      start  : todayString
 				    },
 				    {
 				      title  : 'Have a beer with Ted',
 				      backgroundColor : '#d9edf7',
 				      borderColor : '#bce8f1',
 				      textColor : '#333',
 				      start  : todayString
 				    }
 				  ]
  		})

	});

</script>