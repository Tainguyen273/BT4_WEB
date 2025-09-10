package project_27_8_vidu1.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@WebServlet("/image")
public class ImageServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "D:\\Web";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fname = req.getParameter("fname");
        if (fname != null && !fname.isEmpty()) {
            File file = new File(UPLOAD_DIR + File.separator + fname);
            if (file.exists()) {
                resp.setContentType("image/*");
                Files.copy(file.toPath(), resp.getOutputStream());
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}