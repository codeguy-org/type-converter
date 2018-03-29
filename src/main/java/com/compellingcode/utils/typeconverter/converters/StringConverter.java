package com.compellingcode.utils.typeconverter.converters;

import com.compellingcode.utils.typeconverter.Converter;

public class StringConverter implements Converter {

	public Object convert(Object o) {
		if(o == null)
			return null;
		
		return o.toString();
	}

}
