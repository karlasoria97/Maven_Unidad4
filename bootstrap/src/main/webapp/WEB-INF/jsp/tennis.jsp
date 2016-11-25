<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>Boot Sample | Tennis</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css" type="text/css"/>
<link rel="stylesheet" href="static/css/style.css" type="text/css"/>
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="nav navbar-nav">
				<ul class="nav navbar-nav">
					<li><a href="new-tenni">New tennis</a></li>
					<li><a href="all-tennis">All tennis</a></li>
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
	<c:when test="${mode== 'MODE_TENNI'}">
	<div class="container">
		<div class="jumbotron text-center" id="homeDiv">
			<h1>Welcome to Tennis Manager</h1>
		</div>
	</div>
	</c:when>
		<c:when test="${mode=='MODE_TENNIS'}">
			<div class="container text-center" id="tennisDiv">
				<h3>My Tennis</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Type</th>
								<th>Color</th>
								<th>Brand</th>
								<th>Size</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="tenni" items="${tennis}">
								<tr>
									<td>${tenni.id}</td>
									<td>${tenni.type}</td>
									<td>${tenni.color}</td>
									<td>${tenni.brand}</td>
									<td>${tenni.size}</td>
									<td><a href="update-tenni?id=${tenni.id}"><span
											class="glyphicon glyphicon-pencil"></span> </a></td>
									<td><a href="delete-tenni?id=${tenni.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW_TENNI' || mode=='MODE_UPDATE_TENNIS'}">
			<div class="container text-center" id="tennis">
				<h3>Manage Tennis</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-tenni">
					<input type="hidden" name="id" value="${tenni.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Type:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="type"
								value="${tenni.type}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Color:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="color"
								value="${tenni.color}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Brand:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="brand"
								value="${tenni.brand}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Size:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="size"
								value="${tenni.size}" />
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