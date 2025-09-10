package project_27_8_vidu1.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import project_27_8_vidu1.models.Category;
import project_27_8_vidu1.services.CategoryService;
import project_27_8_vidu1.services.CategoryServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet(urlPatterns = { "/admin/category/list" })
public class CategoryController extends HttpServlet {
	CategoryService cateService = new CategoryServiceImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = null;
        List<Category> cateList = null;
        try {
            cateList = cateService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            message = "Lỗi khi lấy danh sách danh mục: " + e.getMessage();
        }
        req.setAttribute("cateList", cateList);
        req.setAttribute("message", message);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/list-category.jsp");
        dispatcher.forward(req, resp);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
