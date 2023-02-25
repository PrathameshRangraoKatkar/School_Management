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
@WebServlet("/addT")
public class Add extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("prathamesh");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		String name=req.getParameter("name");
		String subject=req.getParameter("subject");
		String sal=req.getParameter("salary");
		int sal1=Integer.parseInt(sal);
		
		Teacher t1=em.find(Teacher.class, id1);
		if(t1!=null)
		{
			PrintWriter pw=resp.getWriter();
			pw.write("Teacher Already Exist");
			RequestDispatcher rd=req.getRequestDispatcher("AddT.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
			return;
		}
		
		Teacher t=new Teacher();
		t.setId(id1);
		t.setName(name);
		t.setSal(sal1);
		t.setSubject(subject);
		
		et.begin();
		em.persist(t);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Added Successfully");
		RequestDispatcher rd=req.getRequestDispatcher("TS.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
	}

}
