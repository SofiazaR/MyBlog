package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationContext;
import ru.itis.dto.PostDto;
import ru.itis.dto.UserDto;
import ru.itis.dto.VideoDto;
import ru.itis.models.User;
import ru.itis.models.Video;
import ru.itis.services.FileService;
import ru.itis.services.VideosService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/videos")
public class VideosServlet extends HttpServlet {
    private VideosService videosService;
    private ObjectMapper objectMapper;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        ApplicationContext applicationContext = (ApplicationContext) servletContext.getAttribute("applicationContext");
        videosService = applicationContext.getBean(VideosService.class);
        objectMapper = applicationContext.getBean(ObjectMapper.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<VideoDto> videos = videosService.findAllVideos();
        req.setAttribute("videos", videos);
        req.getRequestDispatcher("/WEB-INF/jsp/videos.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        videosService.saveVideo(req.getParameter("resume"),
                req.getParameter("link"));

        resp.sendRedirect("/videos");
    }

}