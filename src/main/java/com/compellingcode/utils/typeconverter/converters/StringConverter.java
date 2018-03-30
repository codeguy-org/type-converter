package com.compellingcode.utils.typeconverter.converters;

import java.lang.reflect.Type;

import com.compellingcode.utils.typeconverter.Converter;

public class StringConverter extends Converter {

	@Override
	public Object convert(Object o, Type type) {
		if(o == null)
			return null;
		
		return o.toString();
	}

	@Override
	public boolean handles(Type type) {
		if(type == String.class)
			return true;
		
		return false;
	}

}
