package project_27_8_vidu1.dao;

import java.sql.SQLException;
import java.util.List;

import project_27_8_vidu1.models.Category;

public interface CategoryDAO {
    void insert(Category category) throws SQLException;
    void edit(Category category) throws SQLException;
    void delete(int id) throws SQLException;
    Category get(int id) throws SQLException;
    Category get(String name) throws SQLException;
    List<Category> getAll() throws SQLException;
    List<Category> search(String keyword) throws SQLException;
}