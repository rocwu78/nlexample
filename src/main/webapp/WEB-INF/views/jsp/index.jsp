<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>National Library Sprint MVC Example</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
	$(document).ready(
			function() {
				$("button").click(
						function() {
							$.get('/nlexample/record/'
									+ $(this).attr('borrowerid'),
									setBorrowRecords);
						});
			});

	function setBorrowRecords(records) {
		var h = $("#borrowRecords");
		h.empty();
		if (records.length > 0) {
			$("#recordsTitle").text(
					"Borrow records for " + records[0].borrower.name);
			var t = $("<table class=\"table  table-bordered table-responsive \"> <thead><tr> <th>Title</th> <th>Author</th> <th>ISBN</th> <th>Borrow Date</th> <th>Returned</th> </tr></thead><tbody> ");
			for (var i = 0; i < records.length; i++) {
				var returned = records[i].returned ? "Yes" : "No";
				var r = $("<tr><td>" + records[i].book.title + "</td> <td>"
						+ records[i].book.author + "</td> <td> "
						+ records[i].book.isbn + "</td> <td>"
						+ records[i].borrowDate + "</td> <td>" + returned
						+ "</td>");
				t.append(r);
			}
			var tend = $("</tbody></table>");
			t.append(tend);
			h.append(t);
		}

	}
</script>
</head>
<body>
	<nav class="navbar navbar-static-top navbar-dark bg-inverse">
		<a class="navbar-brand" href="#">Project name</a>
		<ul class="nav navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="#">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#">About</a></li>
		</ul>
	</nav>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">National Library Example</h1>
			<p>This is a simple example of creating a web application by Spring MVC, Bootstrap, Jquery and Ajax.</p>
			<p>Please click the borrow Details button on each borrower to see the book borrow history </p>
		</div>
	</div>

	<div class="container ">
		<div class="row">
			<div class="col-lg-6">
				<h2>Borrowers</h2>
				<table
					class="table table-striped table-bordered table-condensed table-responsive ">
					<thead>
						<tr>
							<th>Name</th>
							<th>Phone</th>
							<th>Email</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${borrowers}" var="current">
							<tr>
								<td><c:out value="${current.name}" />
								<td><c:out value="${current.phone}" />
								<td><c:out value="${current.email}" />
								<td><button type="button" class="btn btn-primary btn-sm"
										borrowerid="${current.id}">Borrow Details</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-lg-6">
				<h2 id="recordsTitle"></h2>
				<div id="borrowRecords"></div>
			</div>
		</div>
	</div>

	<div></div>

	<hr>
	<footer>
		<p>&copy; Roc 2016</p>
	</footer>

</body>
</html>