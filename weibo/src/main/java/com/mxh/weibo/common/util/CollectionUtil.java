package com.mxh.weibo.common.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class CollectionUtil {

	@SuppressWarnings("unchecked")
	public static <V, T> List<T> FiledToList(List<V> list, String filed, Class<T> clazz) {
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}

		List<T> result = new ArrayList<>();

		try {
			for (V v : list) {
				Object object = v.getClass().getDeclaredField(filed).get(v);
				if (object instanceof String || object instanceof Integer) {
					result.add((T) object);
				} else {
					throw new RuntimeException("不支持的字段类型。");
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	public static void main(String[] args) {
		Model m1 = new Model("mm1", 13);
		Model m2 = new Model("mm2", 14);
		Model m3 = new Model("mm3", 15);
		List<Model> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		// List<String> stringFiledToList = StringFiledToList(list, "name",
		// String.class);
		System.out.println();
	}

}

class Model {
	String name;
	Integer age;

	Model(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
