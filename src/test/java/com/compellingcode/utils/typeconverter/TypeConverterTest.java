package com.compellingcode.utils.typeconverter;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.compellingcode.utils.typeconverter.exception.ConversionErrorException;
import com.compellingcode.utils.typeconverter.exception.UnknownTypeException;

@RunWith(JUnit4.class)
public class TypeConverterTest {

	@Test
	public void testConversionToString() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, UnknownTypeException, ConversionErrorException {
		TypeConverter tc = new TypeConverter();
		
		assertEquals(tc.Convert(String.class, 10), "10");
	}

	@Test
	public void testConversionToInteger() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, UnknownTypeException, ConversionErrorException {
		TypeConverter tc = new TypeConverter();
		
		assertEquals(tc.Convert(int.class, "10"), 10);
	}

	@Test
	public void testConversionToFloat() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, UnknownTypeException, ConversionErrorException {
		TypeConverter tc = new TypeConverter();
		
		assertEquals(tc.Convert(float.class, "10.7"), (float)10.7);
		assertEquals(tc.Convert(double.class, "10.7"), (double)10.7);
	}

}
