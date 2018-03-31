package com.compellingcode.utils.typeconverter.converters;

import java.lang.reflect.Type;

import com.compellingcode.utils.typeconverter.Converter;
import com.compellingcode.utils.typeconverter.exception.ConversionErrorException;

public class BooleanConverter extends Converter {

	@Override
	public Boolean convert(Object o, Type type) throws ConversionErrorException {
		if(o == null) {
			if(type == boolean.class) {
				 throw new ConversionErrorException("Cannot assign null to boolean");
			} else {
				return null;
			}
		}
		
		if(o.getClass() == Boolean.class)
			return (Boolean)o;
		
		if(o.getClass() == String.class) {
			if("true".equalsIgnoreCase((String)o)) {
				return Boolean.TRUE;
			} else if("false".equalsIgnoreCase((String)o)) {
				return Boolean.FALSE;
			} else {
				throw new ConversionErrorException(String.format("Can't convert \"%s\" to Boolean", (String)o));
			}
		} else {
			throw new ConversionErrorException(String.format("Unable to convert %s to Boolean", o.getClass().getSimpleName()));
		}
	}

	@Override
	public boolean handles(Type type) {
		if(type == Boolean.class)
			return true;
		
		if(type == boolean.class)
			return true;
		
		return false;
	}

}
