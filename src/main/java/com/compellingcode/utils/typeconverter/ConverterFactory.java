package com.compellingcode.utils.typeconverter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

import com.compellingcode.utils.typeconverter.exception.UnknownTypeException;

public class ConverterFactory {
	private List<Converter> converters = new ArrayList<Converter>();
	
	public ConverterFactory() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Reflections reflections = new Reflections("com.compellingcode.utils.typeconverter.converters");
		Set<Class<? extends Converter>> allClasses = reflections.getSubTypesOf(Converter.class);
		Iterator<Class<? extends Converter>> i = allClasses.iterator();
		while(i.hasNext()) {
			Class<? extends Converter> clazz = i.next();
			converters.add(clazz.getDeclaredConstructor().newInstance());
		}
	}
	
	public Converter getConverter(Type t) throws UnknownTypeException {
		for(Converter converter : converters) {
			if(converter.handles(t))
				return converter;
		}
		
		throw new UnknownTypeException("No converter for type " + t);
	}
	
}
