package Driver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Principle.Principle;

@WebServlet("/Create")
public class Driver extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name=req.getParameter("name");
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		String age=req.getParameter("age");
		int age1=Integer.parseInt(age);
		String email=req.getParameter("email");
		String mob=req.getParameter("mob");
		long mob1=Long.parseLong(mob);
		String password=req.getParameter("password");
		Principle p=new Principle();
		p.setId(id1);
		p.setName(name);
		p.setMob(mob1);
		p.setPassword(password);
		p.setAge(age1);
		p.setEmail(email);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("prathamesh");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(p);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Account created");
		RequestDispatcher rd=req.getRequestDispatcher("PLogin.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
		
	}
	
	

}
