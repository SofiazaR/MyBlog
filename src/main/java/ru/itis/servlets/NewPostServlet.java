package ru.itis.servlets;

import org.springframework.context.ApplicationContext;
import ru.itis.dto.UserDto;
import ru.itis.services.FileService;
import ru.itis.services.PostService;
import ru.itis.services.TagService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet("/newPost")
@MultipartConfig
public class NewPostServlet extends HttpServlet {

    private FileService filesService;
    private PostService postService;
    private TagService tagService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        ApplicationContext applicationContext = (ApplicationContext) servletContext.getAttribute("applicationContext");
        filesService = applicationContext.getBean(FileService.class);
        postService = applicationContext.getBean(PostService.class);
        tagService = applicationContext.getBean(TagService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/newPost.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("photo");

        Long fileId = filesService.saveFileToStorage(part.getInputStream(),
                part.getSubmittedFileName(),
                part.getContentType(),
                part.getSize());

        HttpSession session = req.getSession(false);
        UserDto userDto = (UserDto) session.getAttribute("userDto");

        Long postId = postService.savePost(req.getParameter("text"),
                req.getParameter("name"),
                userDto.getId(),
                req.getParameter("category"),
                fileId);

        tagService.saveTag(postId, req.getParameter("tags"));

        resp.sendRedirect("/newPost");
    }
}
