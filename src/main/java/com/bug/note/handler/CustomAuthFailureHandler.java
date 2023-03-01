package com.bug.note.handler;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		String errorMessage = null;

		if (exception instanceof BadCredentialsException) {
			errorMessage = "아이디 또는 비밀번호 맞지 않습니다.";
		}

		errorMessage = URLEncoder.encode(errorMessage, "UTF-8");

		setDefaultFailureUrl("/auth/login?error=true&exception=" + errorMessage);
		super.onAuthenticationFailure(request, response, exception);
	}

}
