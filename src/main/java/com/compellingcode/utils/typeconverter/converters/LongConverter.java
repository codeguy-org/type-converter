package com.compellingcode.utils.typeconverter.converters;

import java.lang.reflect.Type;
import java.math.BigDecimal;

import com.compellingcode.utils.typeconverter.Converter;
import com.compellingcode.utils.typeconverter.exception.ConversionErrorException;

public class LongConverter extends Converter {
	private BigDecimalConverter bigDecimalConverter = new BigDecimalConverter();

	@Override
	public Long convert(Object o, Type type) throws ConversionErrorException {
		if(o == null) {
			if(type == long.class) {
				throw new ConversionErrorException("Cannot assign null to long");
			} else {
				return null;
			}
		}
		
		if(o.getClass() == Long.class)
			return (Long)o;
		
		BigDecimal bd = bigDecimalConverter.convert(o, BigDecimal.class);
		
		try {
			return bd.longValueExact();
		} catch(Exception ex) {
			throw new ConversionErrorException(String.format("Unable to convert %s to Long", o.toString()));
		}
	}
	
	@Override
	public boolean handles(Type type) {
		if(type == long.class)
			return true;
		
		if(type == Long.class)
			return true;
		
		return false;
	}

}
