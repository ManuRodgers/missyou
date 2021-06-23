package com.isw.missyou.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenericAndJson {
  private static ObjectMapper mapper;

  @Autowired
  public static void setMapper(ObjectMapper mapper) {
    GenericAndJson.mapper = mapper;
  }

  public static <T> String objectToJSON(T object) {
    try {
      return GenericAndJson.mapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static <T> T jsonToObject(String json, Class<T> tClass) {
    if (json == null) {
      return null;
    }
    try {
      return GenericAndJson.mapper.readValue(json, tClass);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static <T> List<T> jsonToList(String json) {
    if (json == null) {
      return null;
    }
    try {
      return GenericAndJson.mapper.readValue(json, new TypeReference<List<T>>() {});
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
  }

  //  public static <T> T jsonToList(String json, TypeReference<T> tTypeReference) {
  //    if (json == null) {
  //      return null;
  //    }
  //    try {
  //      return GenericAndJson.mapper.readValue(json, tTypeReference);
  //    } catch (JsonProcessingException e) {
  //      e.printStackTrace();
  //    }
  //    return null;
  //  }
}
