package com.isw.missyou.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

@Converter
public class ListAndJson implements AttributeConverter<List<Object>, String> {

  @Autowired private ObjectMapper mapper;

  @Override
  public String convertToDatabaseColumn(List<Object> objects) {
    try {
      return mapper.writeValueAsString(objects);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Object> convertToEntityAttribute(String s) {
    if (s == null) {
      return null;
    }
    try {
      return mapper.readValue(s, List.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
  }
}
