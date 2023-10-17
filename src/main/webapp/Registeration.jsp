<%@page import="com.webcam.java.WebcamApplication"%>
<%@page import="com.webcam.java.Getimage"%>
<%@page import="com.RegisterationForm.controller.java.RegisterationForm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Techskills IT Solution</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f1f1f1;
}
.container {
	max-width: 700px;
	margin: 0 auto;
	padding: 20px;
	background-color: #ffffff;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
	margin-bottom: 20px;
}

.header {
	display: flex;
	align-items: center;
	justify-content: space-between;
	margin-bottom: 20px;
}

.company-info {
	flex: 1;
}

.company-info h2 {
	margin: 0;
}

.company-info p {
	margin: 0;
}

.photo-frame {
	width: 190px;
	height: 190px;
	border: 2px solid #ddd;
	border-radius: 50%;
	overflow: hidden;
}

.photo {
	width: 100%;
	height: 100%;
	object-fit: cover;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

.form-group input, .form-group select {
	width: 100%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 8px;
	box-sizing: border-box;
}

.form-group input[type="submit"] {
	background-color: #4CAF50;
	color: #fff;
	cursor: pointer;
}

#photo-preview {
	width: 120px;
	height: 120px;
	border-radius: 50%;
	object-fit: cover;
}

#camera-button, .ok-btn {
	padding: 8px;
	background-color: #4CAF50;
	color: #fff;
	cursor: pointer;
}

.photo-container {
	text-align: center;
}

.circular-image {
	border-radius: 50%;
}
</style>
</head>
<body>
	<div class="header">
		<div class="company-info">
			<h1 align="center">Techskills IT Solution</h1>
			<p align="center" style="font-size:20px;">
				A-101, First Floor, Above A-20, Sakinaka Industrial Market,<br>
				Beside Holiday Inn Hotel Ghatkopar-Andheri Link Road,<br>
				Sakinaka, Andheri(E), Mumbai-400072<br>
			</p>
		</div>


		<div>

			<div class="photo-frame">
				<c:if test="${not empty images}">
					<img src="${images}" class="photo" alt="not showing">
				</c:if>
				<c:if test="${empty images}">
					<!-- Display an alternative message when no image found -->
				<p></p>
				</c:if>
			</div>

			<div style="display:flex;justify-content:center;gap:10px;">
				<form action="Getimage" method="post"
					style="WIDTH: FI-CONTENT; DISPLAY: INLINE;">
					<input type="submit" value="Done" class="ok-btn">
				</form>
				<form action="WebcamApplication" method="post"
					style="WIDTH: FI-CONTENT; DISPLAY: INLINE;">
					<input type="submit" value="Take Photo" name="takephoto"
						id="camera-button">
				</form>
			</div>

		</div>


	</div>
	</div>
	<tr>
		<!--               <th>Form no :</th> -->
		<td>Form no :<input type="text" name="id" value="${id}"></td>
	</tr>

	<form action="RegisterForm" method="post">
		<table>
			<tr>
				<!-- <th>Form no :<input type="text" name="form"></th> -->
				<th><h3 align="left">Registration Form</h3></th>
				<th>Date :<input type="date" name="date"></th>
			</tr>
		</table>
		<table>
			<tr>
				<th><label for="applicantName">Applicant Name:</label></th>
				<td><input type="text" id="applicantName" name="applicantName"
					required></td>
			</tr>
			<tr>
				<th><label for="address">Residential Address:</label></th>
				<td><textasynchronizedrea id="address" name="address" required></textarea></td>
			</tr>
			<tr>
				<th><label for="gender">Gender:</label></th>
				<td><select id="gender" name="gender" required>
						<option value="">Select gender</option>
						<option value="Male">Male</option>
						<option value="Female">Female</option>
						<option value="Other">Other</option>
				</select></td>
			</tr>
			<tr>
				<th><label for="maritalStatus">Marital Status:</label></th>
				<td><select id="maritalStatus" name="maritalStatus" required>
						<option value="">Select marital status</option>
						<option value="Single">Single</option>
						<option value="Married">Married</option>
						<option value="Divorced">Divorced</option>
						<option value="Widowed">Widowed</option>
				</select></td>
			</tr>
			<tr>
				<th><label for="dob">Date of Birth:</label></th>
				<td><input type="date" id="dob" name="dob" required></td>
			</tr>
			<tr>
				<th><label for="pan">Identity Proof (PAN):</label></th>
				<td><input type="text" id="pan" name="pan" required></td>
			</tr>
			<tr>
				<th><label for="aadhar">Address Proof (Aadhar No):</label></th>
				<td><input type="text" id="aadhar" name="aadhar" required></td>
			</tr>
			<tr>
				<th><label for="email">Email Id:</label></th>
				<td><input type="email" id="email" name="email" required></td>
			</tr>
			<tr>
				<th><label for="contact">Contact No:</label></th>
				<td><input type="tel" id="contact" name="contact" required></td>
			</tr>

			<tr>
				<th>Academic Qualification</th>
				<td><input type="radio" name="qualification" value="graduate" />
					Graduate</td>
				<td><input type="radio" name="qualification"
					value="undergraduate" /> Undergraduate</td>
				<td><input type="radio" name="qualification" value="backlog" />
					Graduate With Backlog</td>
			</tr>
			<tr>
				<th>Qualification Detail</th>
				<th>Name of School/College</th>
				<th>Percentage</th>
				<th>Year of Passing</th>
			</tr>
			<tr>
				<th>SSC:</th>
				<td><input type="text" name="SSC" required></td>
				<td><input type="text" name="SSC_Percentage"></td>
				<td><input type="text" name="SSC_Year"></td>
			</tr>
			<tr>
				<th>HSC:</th>
				<td><input type="text" name="HSC" required></td>
				<td><input type="text" name="HSC_Percentage"></td>
				<td><input type="text" name="HSC_Year"></td>
			</tr>
			<tr>
				<th>Graduate:</th>
				<td><input type="text" name="Graduate" required></td>
				<td><input type="text" name="Graduate_Percentage"></td>
				<td><input type="text" name="Graduate_Year"></td>
			</tr>
			<tr>
				<th>Post Graduate:</th>
				<td><input type="text" name="Post_Graduate" required></td>
				<td><input type="text" name="Post_Graduate_Percentage"></td>
				<td><input type="text" name="Post_Graduate_Year"></td>
			</tr>
			<tr>
				<th align="right">Signature</th>
				<td><input type="text" name="sign"></td>
			</tr>

		</table>
		<div style="text-align: center;">
			<input type="submit" value="Register">
		</div>
	</form>
	</div>
	<!-- JS -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="js/main.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">

<script type="text/javascript">
	var a = document.getElementById("obj").value;
	if (a == "failed") {
		swal("Sorry", "Wrong phoneNo and password Not match Create a register Form and Try again", "error");
	}
</script>
</body>
</html>




