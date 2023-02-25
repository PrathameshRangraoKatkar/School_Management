<%@page import="Teacher.Teacher"%>
<%@page import="java.io.PrintWriter"%>
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
</head>
<body>
<%
String id=request.getParameter("ID1");
int id1=Integer.parseInt(id);
EntityManagerFactory emf=Persistence.createEntityManagerFactory("prathamesh");
EntityManager em=emf.createEntityManager();
Teacher t=em.find(Teacher.class, id1);
if(t==null)
{
	PrintWriter pw=response.getWriter();
	pw.write("No Teacher Found");
	RequestDispatcher rd=request.getRequestDispatcher("DeleteT.html");
	rd.include(request, response);
}	
%>
<form action="deleteT" method="post">
		id: <input type="number" value="<%=t.getId()%>" name="id"><br><br>
		name: <input type="text" value="<%=t.getName()%>" name="name"><br><br>
		Subject: <input type="text" value="<%=t.getSubject()%>" name="subject"><br><br>
		Salary: <input type="number" value="<%=t.getSal()%>"name="sal"><br><br>
		<input type="submit" value="DELETE">
	</form>
</body>
</html>