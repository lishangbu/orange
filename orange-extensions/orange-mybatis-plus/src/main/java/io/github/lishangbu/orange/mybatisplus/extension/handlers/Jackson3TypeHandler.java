package io.github.lishangbu.orange.mybatisplus.extension.handlers;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import java.lang.reflect.Field;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.type.TypeFactory;

/**
 * Jackson 实现 JSON 字段类型处理器
 *
 * @author lishangbu
 * @since 2025/10/11
 */
@MappedTypes({Object.class})
@MappedJdbcTypes(JdbcType.OTHER)
public class Jackson3TypeHandler extends AbstractJsonTypeHandler<Object> {

  private static JsonMapper JSON_MAPPER;

  public Jackson3TypeHandler(Class<?> type) {
    super(type);
  }

  public Jackson3TypeHandler(Class<?> type, Field field) {
    super(type, field);
  }

  @Override
  public Object parse(String json) {
    JsonMapper jsonMapper = getJsonMapper();
    TypeFactory typeFactory = jsonMapper.getTypeFactory();
    JavaType javaType = typeFactory.constructType(getFieldType());
    return jsonMapper.readValue(json, javaType);
  }

  @Override
  public String toJson(Object obj) {
    return getJsonMapper().writeValueAsString(obj);
  }

  public static JsonMapper getJsonMapper() {
    if (null == JSON_MAPPER) {
      JSON_MAPPER = new JsonMapper();
    }
    return JSON_MAPPER;
  }

  public static void setJsonMapper(JsonMapper jsonMapper) {
    Assert.notNull(jsonMapper, "JsonMapper should not be null");
    Jackson3TypeHandler.JSON_MAPPER = jsonMapper;
  }
}
