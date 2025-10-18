package io.github.lishangbu.orange.oauth2.common.web.access;

import io.github.lishangbu.orange.oauth2.common.result.SecurityErrorResultCode;
import io.github.lishangbu.orange.web.util.JsonResponseWriter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * 默认的访问拒绝处理器，在用户已认证但无权限访问资源时返回统一的 JSON 错误响应
 * <p>
 * 返回 HTTP 403 状态以及统一的业务错误码，便于前端和网关识别和处理
 *
 * @author lishangbu
 * @since 2025/8/22
 */
@Slf4j
public class DefaultAccessDeniedHandler implements AccessDeniedHandler {

  @Override
  public void handle(
      HttpServletRequest request,
      HttpServletResponse response,
      AccessDeniedException accessDeniedException) {

    log.error("AccessDeniedHandler invoked for request [{}], reason [{}]", request.getRequestURI(), accessDeniedException.getMessage());

    JsonResponseWriter.writeFailedResponse(
      response,
      HttpStatus.FORBIDDEN,
      SecurityErrorResultCode.FORBIDDEN,
      accessDeniedException.getMessage());
  }
}
