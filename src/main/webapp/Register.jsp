<%@ page import="com.Register.java.Register" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>
<!-- Font Icon -->
<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<input type="hidden" id="obj" value="<%= request.getAttribute("obj")%>">
	<div class="main">
		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
					
						<form method="post" action="Register" class="register-form" id="register-form">
							<div class="form-group">
								<label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
								<input type="text" name="userName" id="name" placeholder="Your Name" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label>
								<input type="email" name="email" id="email" placeholder="Your Email" />
							</div>
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label>
								<input type="password" name="password" id="pass" placeholder="Password" />
							</div>
							<div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="phoneNO" id="contact" placeholder="Contact no" />
							</div>
							<div>
								<a href="login.jsp" class="signup-image-link">I am already Resgister </a>
							</div>
							
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup" class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					
				</div>
			</div>
		</section>
	</div>
	
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">

<script type="text/javascript">
	var a = document.getElementById("obj").value;
	if (a == "success") {
		swal("Congratulation", "You are Successfully Register Go back and Login", "success");
	}

</script>
</body>
<!-- This template was made by Colorlib (https://colorlib.com) -->
</html>
