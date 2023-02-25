package Teacher;

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
@WebServlet("/updateT")
public class Update extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("prathamesh");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String subject=req.getParameter("subject");
		String sal=req.getParameter("salary");
		
		Teacher t=new Teacher();
		t.setId(Integer.parseInt(id));
		t.setName(name);
		t.setSal(Integer.parseInt(sal));
		t.setSubject(subject);
		
		et.begin();
		em.merge(t);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Updated Successfully");
		RequestDispatcher rd=req.getRequestDispatcher("TS.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
	}

}
