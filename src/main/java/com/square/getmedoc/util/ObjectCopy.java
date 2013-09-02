package com.square.getmedoc.util;

import java.lang.reflect.Method;
import java.util.List;

public class ObjectCopy {
	
	public static Object copyObject(Object src, Object tgt, Class<?> classDef, List<String> excludeFields, List<String> includeFields){
		if(src == null || tgt == null || classDef == null)
			return null;
		try{
			Method methods[] = classDef.getMethods();
			for(int i=0; i<methods.length; i++){
				Method m = methods[i];
				if(!m.getName().startsWith("set") || m.getName().length() <= 3)
					continue;
				String capField = m.getName().substring(3);
				String field = capField.substring(0,1).toLowerCase() + capField.substring(1);
				Method getter = classDef.getMethod("get"+capField);
				if(getter == null)
					continue;
				if(includeFields != null && includeFields.size() > 0 && includeFields.contains(field)){
					m.invoke(tgt, getter.invoke(src));
					continue;
				}else if(excludeFields != null && excludeFields.size() > 0 && excludeFields.contains(field))
					continue;
				else
					m.invoke(tgt, getter.invoke(src));
			}
			return tgt;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object copyObject(Object src, Object tgt, Class<?> classDef){
		return copyObject(src, tgt, classDef, null, null);
	}
}
