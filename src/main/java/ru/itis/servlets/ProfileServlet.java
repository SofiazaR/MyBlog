package ru.itis.servlets;

import org.springframework.context.ApplicationContext;
import ru.itis.dto.ChangePasswordForm;
import ru.itis.dto.UserDto;
import ru.itis.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userProfile")
public class ProfileServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        ApplicationContext applicationContext = (ApplicationContext) servletContext.getAttribute("applicationContext");
        usersService = applicationContext.getBean(UsersService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChangePasswordForm changePasswordForm = new ChangePasswordForm();
        UserDto userDto = (UserDto) req.getSession().getAttribute("userDto");
        changePasswordForm.setUserId(userDto.getId());
        changePasswordForm.setOldPassword(req.getParameter("old_password").trim());
        changePasswordForm.setNewPassword(req.getParameter("new_password").trim());
        changePasswordForm.setRepeatedNewPassword(req.getParameter("repeated_new_password").trim());
        Boolean result = usersService.changePassword(changePasswordForm);
        System.out.println(result);
        if (result) {
            resp.sendRedirect("/logout");
        }
    }
}
