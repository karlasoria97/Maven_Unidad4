<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>Boot Sample | Song</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css" type="text/css"/>
<link rel="stylesheet" href="static/css/style.css" type="text/css"/>
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="nav navbar-nav">
				<ul class="nav navbar-nav">
					<li><a href="songs">Song</a></li>
					<li><a href="new-song">New song</a></li>
					<li><a href="all-songs">All songs</a></li>
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
	<c:when test="${mode=='MODE_SONG'}">
	<div class="container">
		<div class="jumbotron text-center" id="homeDiv">
			<h1>Welcome to Song Manager</h1>
		</div>
	</div>
	</c:when>
	<c:when test="${mode=='MODE_SONGS'}">
			<div class="container text-center" id="songsDiv">
				<h3>My Songs</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Gender</th>						
								<th>Artist</th>
								<th>Year</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="song" items="${songs}">
								<tr>
									<td>${song.id}</td>
									<td>${song.name}</td>
									<td>${song.gender}</td>
									<td>${song.artist}</td>
									<td>${song.year}</td>
									
									<td><a href="update-song?id=${song.id}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-song?id=${song.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW_SONG' || mode=='MODE_UPDATE_SONGS'}">
			<div class="container text-center" id="songs">
				<h3>Manage Song</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-song">
					<input type="hidden" name="id" value="${song.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Name:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="name"
								value="${song.name}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Gender:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="gender"
								value="${song.gender}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Artist:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="artist"
								value="${song.artist}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3">Year:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="year"
								value="${song.year}" />
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