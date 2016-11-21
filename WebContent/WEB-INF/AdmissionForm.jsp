
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admission Form</title>
</head>
<body>
<h1>Student Admission Form</h1>
<form action="/SpringMVC/submitAdmissionForm.html" method="post">
<table>
<tr>
<td>Student's Name :</td><td> <input type="text" name="studentName"/></td></tr>
<tr>
<td>Student's Hobby :</td><td> <input type="text" name="studentHobby"/></td></tr>
<tr>
<td>Student's Mobile :</td><td> <input type="text" name="studentMobile"/></td></tr>
<tr><td>Student's DOB :</td><td> <input type="text" name="studentDOB"/></td></tr>
<tr><td>Student's Skill set :</td><td> <select  name="studentSkills" multiple>
<option value="Java Core">Java Core</option>
<option value="Spring MVC">Spring MVC</option>
<option value="Spring Core">Spring Core</option>
</select>
</td>
</tr>
</table>
<input type="submit" value="Submit"/>
</form>
</body>
</html>