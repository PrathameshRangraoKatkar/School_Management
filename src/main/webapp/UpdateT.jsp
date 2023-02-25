<%@page import="java.io.PrintWriter"%>
<%@page import="Teacher.Teacher"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
String id=request.getParameter("Id");
int id1=Integer.parseInt(id);
EntityManagerFactory emf=Persistence.createEntityManagerFactory("prathamesh");
EntityManager em=emf.createEntityManager();
Teacher t=em.find(Teacher.class, id1);
if(t==null)
{
	PrintWriter pw=response.getWriter();
	pw.write("No Teacher Found");
	RequestDispatcher rd=request.getRequestDispatcher("UpdateT.html");
	rd.include(request, response);
}	
%>
<div id="form">
<h2>You can Update </h2>
<form action="updateT" method="post">
        <label> ID</label>
	    <input type="number" value="<%=t.getId()%>" name="id"><br><br>
	    <label>Name</label>
		<input type="text" value="<%=t.getName()%>" name="name"><br><br>
		<label>Salary</label>
		<input type="number" value="<%=t.getSal()%>" name="salary"><br><br>
		<label>Subject</label>
		<input type="text" value="<%=t.getSubject()%>"name="subject"><br><br>
		<input type="submit" value="UPDATE" id="submit">
	</form>
</div>
</body>
</html>