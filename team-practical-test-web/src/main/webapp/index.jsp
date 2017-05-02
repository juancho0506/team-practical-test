<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
	<head>
		<meta charset="utf-8">
		<title>Team Practical Test Client Form</title>
		
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		
		<!-- Bootstrap imports -->
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
		
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		
		<!-- Handlebars -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.7/handlebars.js"></script>
	</head>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	      <div class="container">
	        <div class="navbar-header">
	          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	            <span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <a class="navbar-brand" href="#">Team International Test</a>
	        </div>
	        <div id="navbar" class="collapse navbar-collapse">
	          <ul class="nav navbar-nav">
	            <li class="active"><a href="#">Home</a></li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
    	</nav>
    	<br>
    	<br>
    	<c:if test="${message ne null }">
	    	<div class="alert alert-warning">
			  <strong> ${message} </strong>
			</div>
		</c:if>
	    <div id="mainContainer" class="container">
	    	
	    		<h1>Team International Practice Test by Juan Rodrigo Torres Escobar</h1>
				<p class="lead">Client form. Please fill all the required fields to create a new client.</p>
				<form id="clientForm" method="post" action="client">
				  <div class="form-group">
				    <input id="clientId" type="text" class="form-control" placeholder="ID">
				  </div>
				  <div class="form-group">
				    <input id="clientName" type="text" class="form-control" placeholder="Full Name">
				  </div>
				  <div class="form-group">
				    <input id="clientAge" type="text" class="form-control" placeholder="Age">
				  </div>
				  <div class="form-group">
				    <input id="clientAddress" type="text" class="form-control" placeholder="Address">
				  </div>
				  <div class="form-group"> 
				  	<button id="btnClientSave" type="submit" class="btn btn-default">Save</button>
				  </div>
				</form>
	    </div>
		
		<div id="resultsContainer" class="container">
			<div>
				<script id="resultsTemplate" type="text/x-handlebars-template">
					{{#if error}}
						<h2><b>{{error}}</b></h2>
					{{else}}
	
					{{#each responseData.results}}
						<div class="panel panel-default">
	  						<div class="panel-heading">
	    					<h3 class="panel-title">{{{clientId}}}</h3>
	  					</div>
	  					<div class="panel-body">
	    					{{{name}}}
	  					</div>
						</div>
					{{/each}}
	
					{{/if}}
				</script>
			</div>
			<div id="resultsDiv"></div>
		</div>
	</body>
	<!-- Javascript del servicio AJAX -->
	<script src="<c:url value="/resources/js/main.js" />"></script>
	<script type="text/javascript">
		var ctx = '${ctx}'
		$(document).ready(function() {
			console.log("enters document ready");
			renderTemplate(ctx);
		});
	</script>
</html>
