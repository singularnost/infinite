package io.adana.infinite.admin.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sakura
 * @version 1.0
 * @description
 * @date 2020/10/22 18:38
 */
@Component
public class ILogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Authentication authentication) throws IOException, ServletException {
        String redirectUrl = httpServletRequest.getParameter("redirect_url");
        httpServletRequest.getSession().invalidate();
        httpServletResponse.sendRedirect(redirectUrl);
    }
}
