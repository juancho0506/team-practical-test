<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
	<head>
		<meta charset="utf-8">
		<title>Team Practical Test Client Form</title>
		
		<!-- Bootstrap imports -->
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
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
	    <div id="mainContainer" class="container">
	    	<div class="starter-template">
	    		<h1>Team International Practice Test by Juan Rodrigo Torres Escobar</h1>
				<p class="lead">Client form. Please fill all the required fields to create a new client.</p>
				<form id="queryForm" class="navbar-form navbar-left" role="search">
				  <div class="form-group">
				    <input id="inputQuery" type="text" class="form-control" placeholder="Search">
				  </div>
				  <button id="btnSearch" type="button" class="btn btn-default">Search</button>
				</form>	
	    	</div>
	    </div>
		
		<div id="resultsContainer" class="container">
			
		</div>
	</body>
</html>
