<!DOCTYPE html>
<% String eventModalId = "EventDetailModal";
	int eventId = 0;%>

<%@ page import="com.bengor.website.fullcalendar.Priority" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
 							<button type="button" class="btn btn-info" data-toggle="modal" data-target="#EventsDetailModal">Events details<span class="badge">${eventList.size()}</span></button>
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
			        	<h4 class="modal-title">Events details</h4>
			        </div>
			        
					<c:forEach items="${eventList}" var="ev">
				        <div class="modal-body">
				        	
				        	<!-- Selection of the panel type regarding priority -->
				        	<c:choose>
					        	<c:when test="${ev.priority.equals(Priority.HIGH)}">
					        	
									<div class="panel panel-danger">
								
					        	</c:when>
					        	<c:when test="${ev.priority.equals(Priority.MEDIUM)}">
					        	
									<div class="panel panel-warning">
								
					        	</c:when>
					        	<c:when test="${ev.priority.equals(Priority.LOW)}">
					        	
									<div class="panel panel-info">
								
					        	</c:when>
					        	<c:otherwise>
					        	
									<div class="panel">
									
					        	</c:otherwise>
					        </c:choose>
				
										<!-- Panel content -->
										<div class="panel-heading">${ev.name}</div>
										<div class="panel-body">${ev.startingTime} at ${ev.location.toString()}</div>
									</div>	
				        	
				        </div>
					</c:forEach>
			        
			        <div class="modal-footer">
			        	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        </div>
			        
		    	</div>
		  	</div>
		</div>
		
		<c:forEach items="${eventList}" var="ev">
					<!-- Event's details Modal -->
			<div class="modal fade" id="<%=eventModalId+eventId%>" role="dialog">
			  	<div class="modal-dialog">
			    
			    	<!-- Modal content-->
				    <div class="modal-content">
				    
				    	<div class="modal-header">
				        	<button type="button" class="close" data-dismiss="modal">&times;</button>
				        	<h4 class="modal-title">Event details</h4>
				        </div>
				        
				        <div class="modal-body">
				        	        	
				        	<!-- Selection of the panel type regarding priority -->
				        	<c:choose>
					        	<c:when test="${ev.priority.equals(Priority.HIGH)}">
					        	
									<div class="panel panel-danger">
								
					        	</c:when>
					        	<c:when test="${ev.priority.equals(Priority.MEDIUM)}">
					        	
									<div class="panel panel-warning">
								
					        	</c:when>
					        	<c:when test="${ev.priority.equals(Priority.LOW)}">
					        	
									<div class="panel panel-info">
								
					        	</c:when>
					        	<c:otherwise>
					        	
									<div class="panel">
									
					        	</c:otherwise>
					        </c:choose>
										<div class="panel-heading">${ev.name}</div>
										<div class="panel-body">${ev.startingTime} at ${ev.location.toString()}</div>
									</div>			        	
				        </div>
				        
				        <div class="modal-footer">
				        	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				        </div>
				        
			    	</div>
			  	</div>
			</div>
			<%eventId = eventId + 1;%>
		</c:forEach>
		
		
		<!-- Scripts nécessaires à la plupart des pages -->
		<%@include file="includes/includeJSProjet.jsp" %>
		<!-- Script nécessaire à l'utilisation du composant fullcalendar  -->
		<script src='fullcalendar/fullcalendar.js'></script>
		
	</body>
</html>

<script>

$( document ).ready(function() {
	
		var eventList = gettingEventsParam();

 		 $('#calendar').fullCalendar({
 			  events: eventList,
 			  eventClick: function(event){
 				  var idModalName = "#"+"<%=eventModalId%>" + event.id;
 				 $(idModalName).modal();
 			  }
  		})

	});
	
	
	//Function that run through the eventList attribute of the model map to create a list
	//of JS object containing events
	function gettingEventsParam(){
		
		var eventList = new Array();
		var eventId = 0;
		<c:forEach items="${eventList}" var="ev">
		    var event = new Object();
		    event.title = '${ev.name}';
		    
		    //Récupération de la date en format milisecondes puis conversion en date javascript
			var msec = '${ev.startingTime.getTime()}';
			var date = new Date(+msec);
			var dateString = date.toISOString();
			event.id = eventId;
			event.start= dateString;
	
		    event.textColor = '#333';
		    
		    //Attribution d'une couleur de fond et de bord en fonction de la prioritée
		    var priority = '${ev.priority}';
			switch (priority){
			case "<%=Priority.HIGH%>":

				event.backgroundColor = '#f2dede';
				event.borderColor = '#ebccd1';
				break;
			case "<%=Priority.MEDIUM%>":

				event.backgroundColor = '#fcf8e3';
				event.borderColor = '#faebcc';
				break;
			case "<%=Priority.LOW%>":

				event.backgroundColor = '#d9edf7';
				event.borderColor = '#bce8f1';
				break;
			default:
				break;
			}
			
		    eventList.push(event);
		    eventId++;
		</c:forEach>

		return eventList;
	}

	
	function formatDate(msec){
		var date = new Date(+msec);
		return date.toLocaleDateString("en-US");
	}
</script>