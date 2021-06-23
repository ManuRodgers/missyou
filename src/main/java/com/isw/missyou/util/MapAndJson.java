package com.isw.missyou.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.HashMap;
import java.util.Map;

@Converter
public class MapAndJson implements AttributeConverter<Map<String, Object>, String> {

  @Autowired private ObjectMapper mapper;

  @Override
  public String convertToDatabaseColumn(Map<String, Object> stringObjectMap) {
    try {
      return mapper.writeValueAsString(stringObjectMap);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      //      it has to be runtime exception
      //      异常分为两种，一种是对前端有意义的异常，此时返回给前端相对应的错误信息。另一种就像是这种情况下对于前端无意义的异常，直接返回500
      //      server error 异常就可以了

    }
    return null;
  }

  @Override
  @SuppressWarnings("unchecked")
  public Map<String, Object> convertToEntityAttribute(String s) {
    try {
      if (s == null) {
        return null;
      }
      return mapper.readValue(s, HashMap.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
  }
}
