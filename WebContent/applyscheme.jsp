<html>
<head>
<title>Apply Scheme</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' type='text/css' media='screen' href='style.css'>
<script src='main.js'></script>
</head>

<body>
	<%
		String citizenId = request.getParameter("citizenId");
	String schemeId = request.getParameter("schemeId");
	System.out.println(schemeId);
	session.setAttribute("schemeId", schemeId);
	%>

	<script>
		function go() {
			window.location
					.replace(
							"logout.jsp",
							'window',
							'toolbar=1,location=1,directories=1,status=1,menubar=1,scrollbars=1,resizable=1');
		}
	</script>
	<div class="sidebar">
		<a href="viewscheme.html">View all Schemes</a>
		<hr>
		
	</div>

	<div class="topnav">
		<div class="topnav-left">
			<a href="Logo">Logo</a>
		</div>
		<a href="citizenhome.html">Home</a> 
		<a class="redirect" href="javascript:go()">Logout</a>
	</div>

	<div class="headName">
		<h2>Apply Scheme</h2>
	</div>

	<div class="main">
		<form method="POST" action="apply.jsp" class="formClass">
			<label class="labelClass">Select Bank:</label> <select id="selectbox">
				<option value="None">select bank</option>
				<option value="SBI">State bank of India</option>
				<option value="YESBANK">Yes Bank</option>
				<option value="PNB">Punjab National Bank</option>
				<option value="UNIONBANK">union Bank</option>
				<option value="HSBC">HSBC Bank</option>
			</select><br>
			<br> <label class="labelClass">Account Number:</label><input
				id="ACCNO" placeholder="Account No" type="text" /> <br>
			<br> <label class="labelClass">Bank Name: </label><input
				id="Bank" placeholder="Bank Name" type="text" /> <br>
			<br> <label class="labelClass">Type of Account:</label> <input
				id="Type" placeholder="Type Of Account" type="text" /> <br>
			<br> <label class="labelClass">Branch:</label> <input
				id="Branch" placeholder="Branch" type="text" /> <br>
			<br> <label class="labelClass">IFSC Code:</label> <input
				id="IFSC" placeholder="IFSC code" type="text" /> <br> <br>
			<input type="submit" class="button1" onclick="">
			<button onclick="" class="button1">cancel</button>
		</form>

	</div>

	<footer>
		<p>
			Footer text<br> <a href="mailto:hege@example.com">hege@example.com</a>
		</p>
	</footer>


</body>

</html>
