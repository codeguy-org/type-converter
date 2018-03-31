package com.compellingcode.utils.typeconverter.converters;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

import com.compellingcode.utils.typeconverter.Converter;
import com.compellingcode.utils.typeconverter.exception.ConversionErrorException;

public class BigIntegerConverter extends Converter {
	private BigDecimalConverter bigDecimalConverter = new BigDecimalConverter();

	@Override
	public BigInteger convert(Object o, Type type) throws ConversionErrorException {
		if(o == null)
			return null;
		
		Class<?> clazz = o.getClass();
		
		if(clazz == BigInteger.class)
			return (BigInteger)o;
		
		BigDecimal bd = bigDecimalConverter.convert(o, type);
		try {
			return bd.toBigIntegerExact();
		} catch(Exception ex) {
			throw new ConversionErrorException(String.format("Unable to convert %s to BigInteger", o.toString()));
		}
	}

	@Override
	public boolean handles(Type type) {
		if(type == BigInteger.class)
			return true;
		
		return false;
	}

}
