package com.compellingcode.utils.typeconverter.converters;

import java.lang.reflect.Type;
import java.math.BigDecimal;

import com.compellingcode.utils.typeconverter.Converter;
import com.compellingcode.utils.typeconverter.exception.ConversionErrorException;

public class IntegerConverter extends Converter {
	private BigDecimalConverter bigDecimalConverter = new BigDecimalConverter();

	@Override
	public Integer convert(Object o, Type type) throws ConversionErrorException {
		if(o == null) {
			if(type == int.class) {
				throw new ConversionErrorException("Cannot assign null to int");
			} else {
				return null;
			}
		}
		
		if(o.getClass() == Integer.class)
			return (Integer)o;
		
		BigDecimal bd = bigDecimalConverter.convert(o, BigDecimal.class);
		
		try {
			return bd.intValueExact();
		} catch(Exception ex) {
			throw new ConversionErrorException(String.format("Unable to convert %s to Integer", o.toString()));
		}
	}
	
	@Override
	public boolean handles(Type type) {
		if(type == int.class)
			return true;
		
		if(type == Integer.class)
			return true;
		
		return false;
	}

}
