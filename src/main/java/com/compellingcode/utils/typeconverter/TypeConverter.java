package com.compellingcode.utils.typeconverter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

import com.compellingcode.utils.typeconverter.exception.ConversionErrorException;
import com.compellingcode.utils.typeconverter.exception.UnknownTypeException;

public class TypeConverter {
	private ConverterFactory converterFactory;
	
	public TypeConverter() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		converterFactory = new ConverterFactory();
	}
	
	public Object Convert(Type toType, Object value) throws UnknownTypeException, ConversionErrorException {
		Converter converter = converterFactory.getConverter(toType);
		return converter.convert(value, toType);
	}
}
