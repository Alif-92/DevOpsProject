<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Page</title>
<link rel="icon" href="./resources/images/3dhomeicon.png" type="image/png" sizes="16x16">
<link type="text/css" rel="stylesheet" href="./resources/css/login.css">
<link rel="stylesheet" type="text/css" href="./resources/css/style.css" />
<link rel="stylesheet" type="text/css" href="./resources/css/animate-custom.css" />
<script type="text/javascript" src="./resources/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="./resources/js/login.js"></script>
<script type="text/javascript">
	var dbMsg = "${msg}";
</script>
</head>
<body>
<div class="container">

<div id="alertMsg" class="alert">
  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  <span id="alertMsgText"></span>
</div>
          
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form:form method="post" action="doAppLogin.htm" modelAttribute="userDetails" autocomplete="off"> 
                                <h1>Log in</h1> 
                                <p>
                                    <label for="username" class="uname" data-icon="u" > Username </label>
                                    <form:input path="userName" id="username" name="username" required="required" type="text" placeholder="mysuperusername690" autofocus="true" />
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Password </label>
                                    <form:input path="userPassword" id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" /> 
                                </p>
                                <!-- <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">Keep me logged in</label>
								</p> -->
                                <p class="login button">
                                    <input type="submit" value="Login" /> 
								</p>
                                <p class="change_link">
									Not a member yet ?
									<a href="#toregister" class="to_register">Join us</a>
								</p>
                            </form:form>
                        </div>

                        <div id="register" class="animate form">
                            <form:form method="post" action="saveUser.htm" modelAttribute="userDetails" enctype="multipart/form-data" 
                            autocomplete="off" onsubmit="return validateRegisterForm();">
                                <h1> Sign up </h1> 
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Username</label>
                                    <form:input path="userName" id="usrname" name="usrname" required="required" type="text" placeholder="mysuperusername690" autofocus="true" />
                                </p>
                               <!--  <p> 
                                    <label for="emailsignup" class="youmail" data-icon="e" > Your email</label>
                                    <input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="mysupermail@mail.com"/> 
                                </p> -->
                                <p>
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">Password </label>
                                    <form:input path="userPassword" id="usrpwd" name="usrpwd" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password </label>
                                    <input id="usrcnfpwd" name="usrcnfpwd" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="u">Full Name </label>
                                    <form:input path="userFullName" id="usrfullname" name="usrfullname" required="required" type="text" placeholder="eg. Raju Das"/>
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="u">Profile Image</label>
                                    <input id="usrimage" name="usrimage" accept="image/jpeg" required="required" type="file" placeholder="Choose image"/>
                                </p>
                                <p class="signin button"> 
									<input type="submit" value="Sign up"/> 
								</p>
                                <p class="change_link">  
									Already a member ?
									<a href="#tologin" class="to_register"> Go and log in </a>
								</p>
                            </form:form>
                        </div>
						
                    </div>
                </div>  
            </section>
        </div>


</body>
</html>