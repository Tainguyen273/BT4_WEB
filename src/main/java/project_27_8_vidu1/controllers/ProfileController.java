package project_27_8_vidu1.controllers;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import project_27_8_vidu1.models.User;
import project_27_8_vidu1.services.UserService;
import project_27_8_vidu1.services.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/profile")
@MultipartConfig
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("account") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		req.getRequestDispatcher("profile.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("account") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		User current = (User) session.getAttribute("account");
		String fullName = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		Part imagePart = null;
		try {
			imagePart = req.getPart("image");
		} catch (Exception ignored) {}

		String avatarPath = null;
		if (imagePart != null && imagePart.getSize() > 0) {
			String fileName = System.currentTimeMillis() + "_" + imagePart.getSubmittedFileName();
			String uploadDir = req.getServletContext().getRealPath("/images/uploads");
			File dir = new File(uploadDir);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File file = new File(dir, fileName);
			imagePart.write(file.getAbsolutePath());
			avatarPath = "images/uploads/" + fileName;
		}

		userService.updateProfile(current.getId(), fullName, phone, avatarPath);
		if (fullName != null) current.setFullName(fullName);
		if (phone != null) current.setPhone(phone);
		if (avatarPath != null) current.setAvatar(avatarPath);
		session.setAttribute("account", current);
		resp.sendRedirect(req.getContextPath() + "/profile");
	}
}


