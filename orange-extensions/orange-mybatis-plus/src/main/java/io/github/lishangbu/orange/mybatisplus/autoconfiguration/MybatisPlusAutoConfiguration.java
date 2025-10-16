package io.github.lishangbu.orange.mybatisplus.autoconfiguration;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Mybatis Plus 自动配置
 *
 * @author lishangbu
 * @since 2025/10/15
 */
@AutoConfiguration
@SuppressWarnings("SpringComponentScan")
@MapperScan("io.github.lishangbu.orange.**.mapper")
public class MybatisPlusAutoConfiguration {
  /** 添加分页插件 */
  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    // 如果配置多个插件, 切记分页最后添加
    interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
    return interceptor;
  }
}
