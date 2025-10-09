package io.github.lishangbu.orange.json.autoconfiguration;

import io.github.lishangbu.orange.json.util.JsonUtils;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import tools.jackson.core.StreamReadFeature;
import tools.jackson.core.json.JsonFactory;
import tools.jackson.core.json.JsonReadFeature;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.module.SimpleModule;
import tools.jackson.databind.ser.std.ToStringSerializer;

/**
 * jackson自动配置
 *
 * <p>具体变更内容参考<a href="https://github.com/FasterXML/jackson/wiki/Jackson-Release-3.0">github</a>
 *
 * @author lishangbu
 * @since 2022/12/22
 */
@AutoConfiguration(
    before = org.springframework.boot.jackson.autoconfigure.JacksonAutoConfiguration.class)
public class JacksonAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public JsonMapper jsonMapper() {
    // 处理长整型数据,序列换成json时,将所有的long变成string,避免js中精度丢失的问题
    SimpleModule longToStringSerializerModule = new SimpleModule();
    longToStringSerializerModule.addSerializer(Long.class, ToStringSerializer.instance);
    longToStringSerializerModule.addSerializer(Long.TYPE, ToStringSerializer.instance);

    return JsonMapper.builder(
            JsonFactory.builder()
                .enable(JsonReadFeature.ALLOW_JAVA_COMMENTS)
                // 支持单引号
                .enable(JsonReadFeature.ALLOW_SINGLE_QUOTES)
                // 支持未转义控制字符
                .enable(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS)
                .enable(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION)
                .build())
        .addModules(longToStringSerializerModule)
        .build();
  }

  @Bean
  @ConditionalOnMissingBean
  public JsonUtils jsonUtils() {
    return new JsonUtils();
  }
}
