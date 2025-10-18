package io.github.lishangbu.orange.oauth2.common.web.authentication;

import io.github.lishangbu.orange.oauth2.common.result.SecurityErrorResultCode;
import io.github.lishangbu.orange.web.util.JsonResponseWriter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.ExceptionTranslationFilter;

/**
 * 统一的认证入口点，用于在未认证或认证失败时返回统一的 JSON 错误响应
 * <p>
 * 此类由 {@link ExceptionTranslationFilter} 在需要发起认证流程时调用（commence），
 * 返回 HTTP 401 状态以及统一的业务错误码，便于前端和网关识别和处理
 *
 * @author lishangbu
 * @since 2025/8/22
 */
public class DefaultAuthenticationEntryPoint implements AuthenticationEntryPoint {

  private static final Logger log = LoggerFactory.getLogger(DefaultAuthenticationEntryPoint.class);

  @Override
  public void commence(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException authException) {
    log.error("AuthenticationEntryPoint invoked for request [{}], reason=[{}]", request.getRequestURI(),  authException.getMessage());


    JsonResponseWriter.writeFailedResponse(
        response,
        HttpStatus.UNAUTHORIZED,
        SecurityErrorResultCode.UNAUTHORIZED,
        authException.getMessage());
  }
}
