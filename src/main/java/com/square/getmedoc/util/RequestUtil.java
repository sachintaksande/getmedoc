package com.square.getmedoc.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

public class RequestUtil {

	public static Map<String, String> getMapFromString(String source){
		return getMapFromString(source, null, null);
	}
	
	public static Map<String, String> getMapFromString(String source, String separator, String equator){
		if(StringUtils.isEmpty(source))
			return null;
		Map<String,String> ret = new HashMap<String, String>(10);
		if(StringUtils.isEmpty(separator))
			separator = "@_@";
		if(StringUtils.isEmpty(equator))
			equator = "$_$";
		String items[] = StringUtils.split(source, separator);
		Properties vals = StringUtils.splitArrayElementsIntoProperties(items, equator);
		CollectionUtils.mergePropertiesIntoMap(vals, ret);
		return ret;
	}
}
