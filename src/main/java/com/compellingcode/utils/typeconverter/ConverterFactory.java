package com.compellingcode.utils.typeconverter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.compellingcode.utils.typeconverter.converters.StringConverter;

public class ConverterFactory {
	
	public Converter getConverter(Type t) {
		Converter c = null;
		
		if(t instanceof Class) {
			c = getClassConverter((Class<?>)t);
		}
		
		if(t  instanceof ParameterizedType) {
			
		}
		
		return c;
	}
	
	private Converter getClassConverter(Class<?> clazz) {
		if(clazz == String.class) {
			return new StringConverter();
		}
		
		return null;
	}
	
}
