package io.github.lishangbu.orange.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 管理应用
 *
 * @author lishangbu
 * @since 2025/10/11
 */
@SpringBootApplication(scanBasePackages = "io.github.lishangbu.orange")
public class OrangeAdminApplication {
  public static void main(String[] args) {
    SpringApplication.run(OrangeAdminApplication.class, args);
  }
}
