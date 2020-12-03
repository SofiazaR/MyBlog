package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationContext;
import ru.itis.dto.PostDto;
import ru.itis.models.User;
import ru.itis.services.PostService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/posts")
public class PostServlet extends HttpServlet {
    private PostService postService;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        ApplicationContext applicationContext = (ApplicationContext) servletContext.getAttribute("applicationContext");
        postService = applicationContext.getBean(PostService.class);
        objectMapper = applicationContext.getBean(ObjectMapper.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<PostDto> posts = postService.findAll();

        req.setAttribute("posts",posts);
        req.getRequestDispatcher("/WEB-INF/jsp/posts.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = objectMapper.readValue(req.getReader(), User.class);
        ArrayList<PostDto> posts = postService.findAllByUser(user);
        String postsAsJson = objectMapper.writeValueAsString(posts);
        resp.setContentType("application/json");
        resp.getWriter().println(postsAsJson);


    }
}
