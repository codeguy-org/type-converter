package com.compellingcode.utils.typeconverter;

import java.lang.reflect.Type;

import com.compellingcode.utils.typeconverter.exception.ConversionErrorException;

public abstract class Converter {
	public abstract Object convert(Object o, Type t) throws ConversionErrorException;
	public abstract boolean handles(Type type);
}
