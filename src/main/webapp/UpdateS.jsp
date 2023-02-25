<%@page import="java.io.PrintWriter"%>
<%@page import="Student.Student"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
<style type="text/css">
label{
    width:100px;
    display:inline-block;
}
#form{
     border-radius:10px;
     background:black;
     color:white;
     width:290px;
     padding:4px;
     }
     h2{
     text-align:center;
     }
     #submit{
     width:100%;
     margin-top:10px;
     }
</style>
</head>
<body>
<%
int id1=Integer.parseInt(request.getParameter("Id"));
EntityManagerFactory emf=Persistence.createEntityManagerFactory("prathamesh");
EntityManager em=emf.createEntityManager();
Student t=em.find(Student.class, id1);
if(t==null)
{
	PrintWriter pw=response.getWriter();
	pw.write("No Student Found");
	RequestDispatcher rd=request.getRequestDispatcher("UpdateS.html");
	rd.include(request, response);
}	
%>
<div id="form">
<h2>You can Update </h2>
<form action="updateS" method="post">
        <label> Id</label>
		 <input type="number" value="<%=t.getId()%>" name="id"><br><br>
		 <label>Name</label>
		<input type="text" value="<%=t.getName()%>" name="name"><br><br>
		<label>Stream</label>
		<input type="text" value="<%=t.getStream()%>" name="stream"><br><br>
		<label>Fees</label>
		<input type="number" value="<%=t.getFees()%>"name="fees"><br><br>
		<input type="submit" value="UPDATE" id="submit">
	
	</form>
</div>
</body>
</html>