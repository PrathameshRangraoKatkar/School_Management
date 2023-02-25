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
</head>
<body>
<%
String id =request.getParameter("ID");
int id1=Integer.parseInt(id);
EntityManagerFactory emf=Persistence.createEntityManagerFactory("prathamesh");
EntityManager em=emf.createEntityManager();

Teacher t=em.find(Teacher.class, id1);
if(t==null)
{
	PrintWriter pw=response.getWriter();
	pw.write("No Teacher Found");
	RequestDispatcher rd=request.getRequestDispatcher("ShowT.html");
	rd.include(request, response);
}	
%>
<table align="center" cellpadding="20px" border="1">
<th>id</th>
<th>name</th>
<th>salary</th>
<th>subject</th>
<tr align="center">
<td><%=t.getId()%></td>
<td><%=t.getName() %></td>
<td><%=t.getSal() %></td>
<td><%=t.getSubject() %></td>
</tr>
</table>
<form action="TS.html" method="post">
<input type="submit"  value="Menu">
</form>
</body>
</html>