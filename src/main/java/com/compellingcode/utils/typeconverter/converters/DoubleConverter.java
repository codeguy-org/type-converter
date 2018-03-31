package com.compellingcode.utils.typeconverter.converters;

import java.lang.reflect.Type;
import java.math.BigDecimal;

import com.compellingcode.utils.typeconverter.Converter;
import com.compellingcode.utils.typeconverter.exception.ConversionErrorException;

public class DoubleConverter extends Converter {
	private BigDecimalConverter bigDecimalConverter = new BigDecimalConverter();

	@Override
	public Double convert(Object o, Type type) throws ConversionErrorException {
		if(o == null) {
			if(type == double.class) {
				throw new ConversionErrorException("Cannot assign null to double");
			} else {
				return null;
			}
		}
		
		if(o.getClass() == Double.class)
			return (Double)o;
		
		BigDecimal bd = bigDecimalConverter.convert(o, BigDecimal.class);
		Double d = bd.doubleValue();
		
		return d;
	}

	@Override
	public boolean handles(Type type) {
		if(type == double.class)
			return true;
		
		if(type == Double.class)
			return true;
		
		return false;
	}

}
