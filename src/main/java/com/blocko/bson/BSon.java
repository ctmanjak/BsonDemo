package com.blocko.bson;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;

public class BSon {
	public <T> T parse(Class<T> cls, String json) throws Exception {
		T obj = cls.getDeclaredConstructor().newInstance();
		JSONObject jsonObject = new JSONObject(json);
		List<Field> fields = new ArrayList<>();
		Class<?> parseClass = obj.getClass();

		while(parseClass != Object.class) {
			fields.addAll(Arrays.asList(parseClass.getDeclaredFields()));
			parseClass = parseClass.getSuperclass();
		}
		
		for (Field field : fields) {
			String fieldName = field.getName();
			Object fieldValue = jsonObject.get(fieldName);

			field.setAccessible(true);
			field.set(obj, fieldValue);
		}
		return obj;
	}
}