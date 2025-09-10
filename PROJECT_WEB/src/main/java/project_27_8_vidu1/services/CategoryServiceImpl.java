package project_27_8_vidu1.services;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import project_27_8_vidu1.dao.CategoryDAO;
import project_27_8_vidu1.dao.CategoryDAOImpl;
import project_27_8_vidu1.models.Category;


public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDao = new CategoryDAOImpl();

    @Override
    public void insert(Category category) throws SQLException {
        if (category == null || category.getCatename() == null || category.getCatename().trim().isEmpty()) {
            throw new IllegalArgumentException("Danh mục hoặc tên danh mục không được rỗng");
        }
        categoryDao.insert(category);
    }

    @Override
    public void edit(Category newCategory) throws SQLException {
        if (newCategory == null || newCategory.getCateid() <= 0) {
            throw new IllegalArgumentException("Danh mục hoặc ID không hợp lệ");
        }
        Category oldCategory = categoryDao.get(newCategory.getCateid());
        if (oldCategory == null) {
            throw new SQLException("Danh mục không tồn tại với ID: " + newCategory.getCateid());
        }
        oldCategory.setCatename(newCategory.getCatename());
        if (newCategory.getIcon() != null && !newCategory.getIcon().trim().isEmpty()) {
            // Xóa ảnh cũ nếu tồn tại
            String oldIcon = oldCategory.getIcon();
            if (oldIcon != null && !oldIcon.trim().isEmpty()) {
                final String dir = "E:\\upload\\category\\";
                File file = new File(dir + oldIcon);
                if (file.exists()) {
                    try {
                        file.delete();
                    } catch (SecurityException e) {
                        throw new SQLException("Không thể xóa ảnh cũ: " + oldIcon, e);
                    }
                }
            }
            oldCategory.setIcon(newCategory.getIcon());
        }
        categoryDao.edit(oldCategory);
    }

    @Override
    public void delete(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID danh mục không hợp lệ");
        }
        categoryDao.delete(id);
    }

    @Override
    public Category get(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID danh mục không hợp lệ");
        }
        return categoryDao.get(id);
    }

    @Override
    public Category get(String name) throws SQLException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên danh mục không được rỗng");
        }
        return categoryDao.get(name);
    }

    @Override
    public List<Category> getAll() throws SQLException {
        return categoryDao.getAll();
    }

    @Override
    public List<Category> search(String keyword) throws SQLException {
        if (keyword == null) {
            keyword = "";
        }
        return categoryDao.search(keyword);
    }
}