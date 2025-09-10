package project_27_8_vidu1.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import project_27_8_vidu1.services.CategoryService;
import project_27_8_vidu1.services.CategoryServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class CategoryDeleteController
 */
@WebServlet("/CategoryDeleteController")
public class CategoryDeleteController extends HttpServlet {
	CategoryService cateService = new CategoryServiceImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String message = null;

        try {
            if (id != null && !id.trim().isEmpty()) {
                int categoryId = Integer.parseInt(id);
                cateService.delete(categoryId);
                resp.sendRedirect(req.getContextPath() + "/admin/category/list?message=deleteSuccess");
            } else {
                message = "ID danh mục không được cung cấp.";
                resp.sendRedirect(req.getContextPath() + "/admin/category/list?error=" + message);
            }
        } catch (NumberFormatException e) {
            message = "ID danh mục không hợp lệ.";
            resp.sendRedirect(req.getContextPath() + "/admin/category/list?error=" + message);
        } catch (SQLException e) {
            e.printStackTrace();
            message = "Lỗi khi xóa danh mục: " + e.getMessage();
            resp.sendRedirect(req.getContextPath() + "/admin/category/list?error=" + message);
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
