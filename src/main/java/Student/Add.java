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

@WebServlet("/addS")
public class Add extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id =req.getParameter("id");
		int id1=Integer.parseInt(id);
		String name=req.getParameter("name");
		String stream=req.getParameter("stream");
		String fees=req.getParameter("fees");
		int fees1=Integer.parseInt(fees);
		
		Student s=new Student();
		s.setId(id1);
		s.setName(name);
		s.setStream(stream);
		s.setFees(fees1);
		
		
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("prathamesh");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student s2=em.find(Student.class, id1);
		if(s2!=null)
		{
			PrintWriter pw=resp.getWriter();
			pw.write("Student Already Exist");
			RequestDispatcher rd=req.getRequestDispatcher("AddS.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
			return;
		}
		
		et.begin();
		em.persist(s);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Added Successfully");
		RequestDispatcher rd=req.getRequestDispatcher("TS.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
	}

}
