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
<title>Insert title here</title>
</head>
<body>
<%
String id=request.getParameter("ID1");
int id1=Integer.parseInt(id);
EntityManagerFactory emf=Persistence.createEntityManagerFactory("prathamesh");
EntityManager em=emf.createEntityManager();
Student t=em.find(Student.class, id1);
if(t==null)
{
	PrintWriter pw=response.getWriter();
	pw.write("No Student Found");
	RequestDispatcher rd=request.getRequestDispatcher("DeleteS.html");
	rd.include(request, response);
}	
%>
<form action="deleteS" method="post">
		id: <input type="number" value="<%=t.getId()%>" name="id"><br><br>
		name: <input type="text" value="<%=t.getName()%>" name="name"><br><br>
		Stream: <input type="text" value="<%=t.getStream()%>" name="stream"><br><br>
		Fees: <input type="number" value="<%=t.getFees()%>"name="fees"><br><br>
		<input type="submit" value="DELETE">
	</form>
</body>
</html>