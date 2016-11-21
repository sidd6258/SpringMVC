<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admission Success</title>
</head>
<body>
<h1>Congratulations!! You are Admitted</h1>
<h2>${msg}</h2>
<table>
<tr><td>Name:</td><td> ${student1.studentName}</td></tr>
<tr><td>Hobby:</td><td> ${student1.studentHobby}</td></tr>
<tr><td>Mobile:</td><td> ${student1.studentMobile}</td></tr>
<tr><td>DOB:</td><td> ${student1.studentDOB}</td></tr>
<tr><td>Skill Set:</td><td> ${student1.studentSkills}</td></tr>
</table>
</body>
</html>