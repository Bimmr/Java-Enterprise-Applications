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
        <title>Geographic Areas</title>
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
                </div>
                <div class="panel-body">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#countries">Countries</a></li>
                        <li><a data-toggle="tab" href="#provinces">Provinces & Territories</a></li>
                        <li><a data-toggle="tab" href="#cities">Cities</a></li>
                    </ul>

                    <div class="tab-content">
                        <div id="countries" class="tab-pane fade in active">
							<ul class="nav nav-tabs nav-pills nav-justified">
		                        <li class="active"><a data-toggle="tab" href="#countryList">List</a></li>
		                        <li><a data-toggle="tab" href="#ageGroups">Age Groups</a></li>
                    		</ul>

	                    	<div class="tab-content">
                        		<div id="countryList" class="tab-pane fade in active">
                        		
                            		<h3>Countries</h3>
		                            <table class="table">
		                                <tr>
		                                    <th>Name</th>
		                                    <th>Code</th>
		                                    <th>Level</th>
		                                    <th>Alternative Code</th>
		                                </tr>
		                                <c:forEach var="country" items="${countries}">
		                                    <tr>
		                                        <td><a href="GeographicAreaSingleServlet?id=${country.geographicAreaID}">${country.name}</a></td>
		                                        <td>${country.code}</td>
		                                        <td>${country.level}</td>
		                                        <td>${country.alternativeCode}</td>
		                                    </tr>
		                                </c:forEach>
		                            </table>
	                            </div>
                        		<div id="ageGroups" class="tab-pane fade">
                           		 <h3>Age Groups for Canada</h3>
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
                        <div id="provinces" class="tab-pane fade">
                        <ul class="nav nav-tabs nav-pills nav-justified">
		                        <li class="active"><a data-toggle="tab" href="#provList">List</a></li>
		                        <li><a data-toggle="tab" href="#incomeMedian">Income Medians</a></li>
                    		</ul>

	                    	<div class="tab-content">
                        		<div id="provList" class="tab-pane fade in active">
		                            <h3>Provinces & Territories</h3>
		                            <table class="table">
		                                <tr>
		                                    <th>Name</th>
		                                    <th>Code</th>
		                                    <th>Level</th>
		                                    <th>Alternative Code</th>
		                                </tr>
		                                <c:forEach var="prov" items="${provs}">
		                                    <tr>
		                                        <td><a href="GeographicAreaSingleServlet?id=${prov.geographicAreaID}">${prov.name}</a></td>
		                                        <td>${prov.code}</td>
		                                        <td>${prov.level}</td>
		                                        <td>${prov.alternativeCode}</td>
		                                    </tr>
		                                </c:forEach>
		                            </table>
		                        </div>
		                        <div id="incomeMedian" class="tab-pane fade">
		                        <h3>Median Household Income</h3>
		                        <br>                        
 		                        <h3>Households that fit:</h3>
		                            <table class="table">
			                            <tr>
				                             <ul>
				                            	<li>2016 Canada Census Year</li>
				                            	<li>One couple census family without other persons in the household</li>
				                            	<li>2 or more members in the household</li>
				                            	<li>At least 1 earner in the household</li>
				                            	<li>At least 1 household member between 0 and 17 years old</li>
				                            </ul>
			                            </tr>
		                                <tr>
		                                    <th>Name</th>
		                                    <th>Median Income</th>
		                                </tr>
		                                <c:forEach var="house" items="${medianIncome}">
		                                    <tr>
		                                        <td><a href="GeographicAreaSingleServlet?id=${house.geographicArea.geographicAreaID}">${house.geographicArea.name}</a></td>
		                                        <td><fmt:formatNumber value = "${house.numberReported}" type = "currency"/></td>
		                                    </tr>
		                                </c:forEach>
		                            </table>
		                        </div>
                        	</div>
                        </div>
                        <div id="cities" class="tab-pane fade">
                            <h3>Cities</h3>
                            <table class="table">
                                <tr>
                                    <th>Name</th>
                                    <th>Code</th>
                                    <th>Level</th>
                                    <th>Alternative Code</th>
                                </tr>
                                <c:forEach var="city" items="${cities}">
                                    <tr>
                                        <td><a href="GeographicAreaSingleServlet?id=${city.geographicAreaID}">${city.name}</a></td>
                                        <td>${city.code}</td>
                                        <td>${city.level}</td>
                                        <td>${city.alternativeCode}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
    </body>
    </html>