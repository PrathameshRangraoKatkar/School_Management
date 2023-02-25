package Student;

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
@WebServlet("/updateS")
public class Update extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("prathamesh");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
	
		Student s=new Student();

		s.setId(Integer.parseInt(req.getParameter("id")));
		s.setName(req.getParameter("name"));
		s.setStream(req.getParameter("stream"));
		s.setFees(Integer.parseInt(req.getParameter("fees")));
		
		et.begin();
		em.merge(s);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Updated Successfully");
		RequestDispatcher rd=req.getRequestDispatcher("TS.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
	}

}
