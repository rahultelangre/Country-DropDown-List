<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Dependent Drop downs</title>
<script src="./js/jquery-1.7.1.js"></script>
<script src="./js/app.js"></script>
<style>
select, input[type="text"] {
	width: 200%;
	box-sizing: border-box;
	padding: 10px 20px;
	margin: 4px 0;
	box-sizing: border-box;
}
</style>

<script type="text/javascript">
	
</script>
</head>
<body>
	<h1>Countries-States-Cities Loading using AJAX</h1>
	<table>
		<tr>
			<td><b>Select Country :</b></td>
			<td><select id="country">
					<option value="">-Select Country-</option>
			</select></td>
		</tr>
		<tr>
			<td><b>Select State :</b></td>
			<td><select id="state">
					<option value="">-Select State-</option>
			</select></td>
		</tr>
		<tr>
			<td><b>Select City :</b></td>
			<td><select id="city">
					<option value="">-Select City-</option>
			</select></td>
		</tr>

	</table>
</body>
</html>