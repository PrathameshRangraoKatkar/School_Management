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
String id =request.getParameter("ID");
int id1=Integer.parseInt(id);
EntityManagerFactory emf=Persistence.createEntityManagerFactory("prathamesh");
EntityManager em=emf.createEntityManager();

Student s=em.find(Student.class, id1);
if(s==null)
{
	PrintWriter pw=response.getWriter();
	pw.write("No Student Found");
	RequestDispatcher rd=request.getRequestDispatcher("ShowS.html");
	rd.include(request, response);
}	
%>
	

<table align="center" cellpadding="20px" border="1">
<th>id</th>
<th>Name</th>
<th>Fees</th>
<th>Stream</th>
<tr align="center">
<td><%=s.getId()%></td>
<td><%=s.getName() %></td>
<td><%=s.getFees() %></td>
<td><%=s.getStream() %></td>
</tr>
</table>
<form action="TS.html" method="post">
<input type="submit"  value="Menu">
</form>
</body>
</html>