package com.compellingcode.utils.typeconverter.converters;

import java.lang.reflect.Type;
import java.math.BigDecimal;

import com.compellingcode.utils.typeconverter.Converter;
import com.compellingcode.utils.typeconverter.exception.ConversionErrorException;

public class FloatConverter extends Converter {
	private BigDecimalConverter bigDecimalConverter = new BigDecimalConverter();

	@Override
	public Float convert(Object o, Type type) throws ConversionErrorException {
		if(o == null) {
			if(type == float.class) {
				throw new ConversionErrorException("Cannot assign null to float");
			} else {
				return null;
			}
		}
		
		if(o.getClass() == Float.class)
			return (Float)o;
		
		BigDecimal bd = bigDecimalConverter.convert(o, BigDecimal.class);
		Float f = bd.floatValue();
		
		return f;
	}
	
	@Override
	public boolean handles(Type type) {
		if(type == float.class)
			return true;
		
		if(type == Float.class)
			return true;
		
		return false;
	}

}
