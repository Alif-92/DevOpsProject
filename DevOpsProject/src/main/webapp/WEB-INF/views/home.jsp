<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>HomePage</title>
<link rel="icon" href="./resources/images/3dhomeicon.png" type="image/png" sizes="16x16">
<link type="text/css" rel="stylesheet" href="./resources/css/home.css">
</head>
<body>
	<!-- <div class="header">
	  <h1>My Website</h1>
	  <p>A <b>responsive</b> website created by me.</p>
	</div> -->

	<div class="navbar">
	  <a href="#" class="active">Home</a>
	  <!-- <a href="#">Link</a>
	  <a href="#">Link</a> -->
	  <div class="navigation">
		<span class="greetings">${greetings} ${loggedInUser.userFullName}!</span>
        <img class="avatar" alt="image" src="data:image/jpeg;base64,${loggedInUserImage}" />
        <span class="logout"><a href="doAppLogout.htm">LOGOUT</a></span>
	  </div>
	  <!-- <a href="#" class="right">Link</a> -->
	</div>

<div class="row">
  <div class="side">
    <h2>About Me</h2>
    <div class="fakeimg" style="height:200px; width:204px;">
		<img alt="pranabimage" src="./resources/images/pranabimage.jpg" width="200px" height="196px" />
	</div>
    <p>Hi! This is Kusum Kumar Ganwala, a software developer and a reputed freelancer</p>
    <!-- <h3>More Text</h3>
    <p>Lorem ipsum dolor sit ame.</p>
    <div class="fakeimg" style="height:60px;">Image</div><br>
    <div class="fakeimg" style="height:60px;">Image</div><br>
    <div class="fakeimg" style="height:60px;">Image</div> -->
  </div>
  <div class="main">
    <h2>Welcome to the world of DevOps</h2>
    <div class="fakeimg" style="height:200px; width:815px;">
		<img alt="devops1" src="./resources/images/devops1.webp" width="200px" height="196px" />
		<img alt="devops2" src="./resources/images/devops2.png" width="200px" height="196px" />
		<img alt="devops3" src="./resources/images/devops3.jpg" width="200px" height="196px" />
		<img alt="devops4" src="./resources/images/devops4.jpg" width="200px" height="196px" />
	</div>
    <p>DevOps is a set of practices that combines software development (Dev) and information-technology operations (Ops) which aims to shorten the systems development life cycle and provide continuous delivery with high software quality.</p>
    <p>As DevOps is intended to be a cross-functional mode of working, those who practice the methodology use different sets of tools, referred to as "toolchains" rather than a single one. These toolchains are expected to fit into one or more of the following categories, reflective of key aspects of the development and delivery process:
<br /><br />
1) Coding : code development and review, source code management tools, code merging
<br />
2) Building : continuous integration tools, build status
<br />
3) Testing : continuous testing tools that provide quick and timely feedback on business risks
<br />
4) Packaging : artifact repository, application pre-deployment staging
<br />
5) Releasing : change management, release approvals, release automation
<br />
6) Configuring : infrastructure configuration and management, infrastructure as code tools
<br />
7) Monitoring : applications performance monitoring, end-user experience
<br /><br />
Some categories are more essential in a DevOps toolchain than others; especially continuous integration (e.g. Jenkins, Gitlab, Bitbucket pipelines) and infrastructure as code (e.g., Terraform, Ansible, Puppet).
<br />
Forsgren et al. found that IT performance is strongly correlated with DevOps practices like source code management and continuous delivery.</p>
    <br>
    <!-- <h2>TITLE HEADING</h2>
    <h5>Title description, Sep 2, 2017</h5>
    <div class="fakeimg" style="height:200px;">Image</div>
    <p>Some text..</p>
    <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p> -->
  </div>
</div>

<div class="footer">
  <h4>&copy 2020 All right reserved to Kusum Kumar Ganwala</h4>
</div>

</body>
</html>