<!-- 
	Login JSP
	2/9/18
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login To Database</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
        	.populationTable tr:nth-child(odd) td:nth-child(1){
	    		color:white;
			}
        </style>
    </head>

    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
            <div class="panel panel-primary">
               <div class="panel-heading">
                	<div class="page-header">
 			   			<h1>Java Enterprise - Assignment 2</h1>
 			   		</div>
  					<button class="btn btn-primary" onclick="window.history.back();"><span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>&nbsp;Back</button>
                </div>
                <div class="panel-body">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#information">Information</a></li>
                        <c:if test="${area.level < 2}">
	                        <li><a data-toggle="tab" href="#subLocations">Sub Locations</a></li>
	                    </c:if>
                        <li><a data-toggle="tab" href="#population">Population</a></li>
                    </ul>

                    <div class="tab-content">
                        <div id="information" class="tab-pane fade in active">
                            <h3>Information</h3>
                            <table class="table">
                           		<tr>
                                    <td>Name:</td>
                                    <td>${area.name}</td>
                                </tr>
                           		<tr>
                                    <td>Code</td>
                                    <td>${area.code}</td>
                                </tr>
                           		<tr>
                                    <td>Level:</td>
                                    <td>${area.level}</td>
                                </tr>
                           		<tr>
                                    <td>Alternative Code:</td>
                                    <td>${area.alternativeCode}</td>
                                </tr>
                            </table>
                            <h3>Total Population</h3>
                            <table class="table populationTable">
                           		<tr>
                                    <th>Age Group</th>
                                    <th>Year</th>
                                    <th>Male</th>
                                    <th>Female</th>
                                    <th>Combined</th>
                                </tr>
                                    <tr>
                                        <td>${ages[0].ageGroup.description}</td>
                                        <td>${ages[0].censusYear.censusYear}</td>
                                        <td><fmt:formatNumber type = "number" value = "${ages[0].male}" /></td>
                                        <td><fmt:formatNumber type = "number" value = "${ages[0].female}" /></td>
                                        <td><fmt:formatNumber type = "number" value = "${ages[0].combined}" /></td>
                                    </tr>
                                    <tr>
                                        <td>${ages[1].ageGroup.description}</td>
                                        <td>${ages[1].censusYear.censusYear}</td>
                                        <td><fmt:formatNumber type = "number" value = "${ages[1].male}" /></td>
                                        <td><fmt:formatNumber type = "number" value = "${ages[1].female}" /></td>
                                        <td><fmt:formatNumber type = "number" value = "${ages[1].combined}" /></td>
                                    </tr>
                            </table>
                            <c:if test="${area.level < 2}">
	                            <h3>Households that fit:</h3>
	                            <table class="table">
	                           		<tr>
			                            <ul>
			                            	<li>2016 Canada Census Year</li>
			                            	<li>One couple census family without other persons in the household</li>
			                            	<li>2 or more members in the household</li>
			                            	<li>At least 1 earner in the household</li>
			                            	<li>Total income between $80,000 and $89,99</li>
			                            </ul>
	                            	</tr>
	                           		<tr>
	                                    <td>Total:</td>
	                                    <td>${households}</td>
	                                </tr>
	                            </table>
                            </c:if>
                        </div>
                        <c:if test="${area.level < 2}">
	                        <div id="subLocations" class="tab-pane fade">
	                            <h3>Sub Locations</h3>
	                            <table class="table">
	                                <tr>
	                                    <th>Name</th>
	                                    <th>Code</th>
	                                    <th>Level</th>
	                                    <th>Alternative Code</th>
	                                </tr>
	                                <c:forEach var="sub" items="${subLocations}">
	                                    <tr>
	                                        <td><a href="GeographicAreaSingleServlet?id=${sub.geographicAreaID}">${sub.name}</a></td>
	                                        <td>${sub.code}</td>
	                                        <td>${sub.level}</td>
	                                        <td>${sub.alternativeCode}</td>
	                                    </tr>
	                                </c:forEach>
	                            </table>
	                        </div>
                        </c:if>
                        <div id="population" class="tab-pane fade">
                            <h3>Population</h3>
                            <table class="table populationTable">
                                <tr>
                                    <th>Age Group</th>
                                    <th>Year</th>
                                    <th>Male</th>
                                    <th>Female</th>
                                    <th>Combined</th>
                                </tr>
                                <c:forEach var="age" items="${ages}">
                                    <tr>
                                        <td>${age.ageGroup.description}</td>
                                        <td>${age.censusYear.censusYear}</td>
                                        <td><fmt:formatNumber type = "number" value = "${age.male}" /></td>
                                        <td><fmt:formatNumber type = "number" value = "${age.female}" /></td>
                                        <td><fmt:formatNumber type = "number" value = "${age.combined}" /></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
    </body>
    </html>