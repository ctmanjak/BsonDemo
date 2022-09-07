package com.blocko.sample.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseModel {
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    Class<?> thisClass = this.getClass();
    List<Field> fields = new ArrayList<>();

    result.append("[" + this.getClass().getSimpleName() + "]");
    result.append("\n");
    
    while (thisClass != Object.class) {
      fields.addAll(Arrays.asList(thisClass.getDeclaredFields()));
      thisClass = thisClass.getSuperclass();
    }

    for (Field field : fields) {
      field.setAccessible(true);
      
      try {
        result.append(field.getName() + ": " + field.get(this));
      } catch (IllegalArgumentException | IllegalAccessException e) {
        e.printStackTrace();
      }
      result.append("\n");
    }
    
    return result.toString();
  }
}
