package ru.itis.filters;

import ru.itis.dto.UserDto;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        Boolean isAuthenticated = false;
        Boolean sessionExists = session != null;
        Boolean isLoginPage = request.getRequestURI().equals("/signIn");
        Boolean isSignUpPage = request.getRequestURI().equals("/signUp");
        if (sessionExists) {
            UserDto userDto = (UserDto) session.getAttribute("userDto");
            if (userDto != null) {
                isAuthenticated = true;
            }
        }
        if (isAuthenticated) {
            if (isLoginPage || isSignUpPage) {
                response.sendRedirect("/");
            } else {
                filterChain.doFilter(request, response);
            }
        } else {
            if (isLoginPage || isSignUpPage) {
                filterChain.doFilter(request, response);
            } else {
                response.sendRedirect("/signIn");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
