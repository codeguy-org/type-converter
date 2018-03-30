package com.compellingcode.utils.typeconverter.converters;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

import com.compellingcode.utils.typeconverter.Converter;
import com.compellingcode.utils.typeconverter.exception.ConversionErrorException;

public class BigIntegerConverter extends Converter {

	@Override
	public BigDecimal convert(Object o, Type type) throws ConversionErrorException {
		if(o == null)
			return null;
		
		Class<?> clazz = o.getClass();
		
		if(clazz == BigDecimal.class)
			return (BigDecimal)o;
		
		if(clazz == int.class || clazz == Integer.class) {
			return BigDecimal.valueOf((Integer)o);
		} else if(clazz == long.class || clazz == Long.class) {
			return BigDecimal.valueOf((Long)o);
		} else if(clazz == float.class || clazz == Float.class) {
			return BigDecimal.valueOf((Float)o);
		} else if(clazz == double.class || clazz == Double.class) {
			return BigDecimal.valueOf((Double)o);
		} else if(clazz == BigInteger.class) {
			return new BigDecimal((BigInteger)o);
		} else if(clazz == String.class) {
			try {
				return new BigDecimal((String)o);
			} catch(Exception ex) {
				throw new ConversionErrorException(ex);
			}
		} else {
			throw new ConversionErrorException(String.format("Cannot convert %s to BigDecimal", clazz.getSimpleName()));
		}
	}

	@Override
	public boolean handles(Type type) {
		if(type == BigInteger.class)
			return true;
		
		return false;
	}

}
