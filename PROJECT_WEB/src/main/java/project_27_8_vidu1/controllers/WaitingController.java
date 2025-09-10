package project_27_8_vidu1.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import project_27_8_vidu1.models.User;

import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/waiting")
public class WaitingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WaitingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		if(session != null && session.getAttribute("account") != null) {
			User u=(User) session.getAttribute("account");
			req.setAttribute("username", u.getUserName());
			if(u.getRoleid()==1) {
				resp.sendRedirect(req.getContextPath()+"/admin/home.jsp");
			}else if(u.getRoleid()==2) {
				resp.sendRedirect(req.getContextPath()+"/manager/home.jsp");
			}else {
				resp.sendRedirect(req.getContextPath()+"/home.jsp");
			}
		}
		else {
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
