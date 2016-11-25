<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>Boot Sample | Staff</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css" type="text/css"/>
<link rel="stylesheet" href="static/css/style.css" type="text/css"/>
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="nav navbar-nav">
				<ul class="nav navbar-nav">
					<li><a href="staffs">Staff</a></li>
					<li><a href="new-staff">New staffs</a></li>
					<li><a href="all-staffs">All staffs</a></li>
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
	<c:when test="${mode=='MODE_STAFF'}">
	<div class="container">
		<div class="jumbotron text-center" id="homeDiv">
			<h1>Welcome to Staff Manager</h1>
		</div>
	</div>
	</c:when>
	<c:when test="${mode=='MODE_STAFFS'}">
			<div class="container text-center" id="staffsDiv">
				<h3>My Staffs</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						
						<tbody>
							<c:forEach var="staff" items="${staffs}">
								<tr>
									<td>${staff.id}</td>
									<td>${staff.gender==true?"Mujer":"Hombre"}</td>
									<td>${staff.jobTitle}</td>
									<td>${staff.firstName}</td>
									<td>${staff.middelName}</td>
									<td>${staff.lastName}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd"
											value="${staff.birthDay}" /></td>
											<td>${staff.otherDetails}</td>
									
									<td><a href="update-staff?id=${staff.id}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-staff?id=${staff.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW_STAFF' || mode=='MODE_UPDATE_STAFFS'}">
			<div class="container text-center" id="staffs">
				<h3>Manage Staff</h3>
				<hr />
									
				<form class="form-horizontal" method="POST" action="save-staff">
					<input type="hidden" name="id" value="${staff.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Gender:</label>
						<div class="col-sm-7">
							<input type="radio" class="col-sm-1" name="gender"
								value="true" />
								<div class="col-sm-2">Mujer</div>
							<input type="radio" class="col-sm-1" name="gender"
								value="false" checked="checked"/>
								<div class="col-sm-2">Hombre</div>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Job Title:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="jobTitle"
								value="${staff.jobTitle}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">First Name:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="firstName"
								value="${staff.firstName}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Middel Name:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="middelName"
								value="${staff.middelName}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Last Name:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="lastName"
								value="${staff.lastName}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Birth Day:</label>
						<div class="col-sm-7">
							<input type="date" class="form-control" name="birthDay"
								value="${staff.birthDay}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Other Details:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="otherDetails"
								value="${staff.otherDetails}" />
						</div>
					</div>

					
					
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>

				</form>
			</div>
		</c:when>
	</c:choose>
	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>