package Driver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Principle.Principle;
@WebServlet("/login")
public class Validation extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email=req.getParameter("email");
		String password=req.getParameter("Password");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("prathamesh");
		EntityManager em=emf.createEntityManager();
		 Query q=em.createQuery("select p from Principle p");
		 List<Principle> principle =q.getResultList();
		 for(Principle p:principle)
		 {
			 if(p.getEmail().equals(email) && p.getPassword().equals(password))
			 {
				 System.out.println("hi");
				 RequestDispatcher rd=req.getRequestDispatcher("TS.html");
				 rd.forward(req, resp);
				 resp.setContentType("text/html");
				 return;
			 }
		 }
		 PrintWriter pw=resp.getWriter();
		 pw.write("Invalid credentials");
		 RequestDispatcher rd=req.getRequestDispatcher("PLogin.html");
		 rd.include(req, resp);
		 resp.setContentType("text/html");
	
	}

}
