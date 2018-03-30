package com.compellingcode.utils.typeconverter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.compellingcode.utils.typeconverter.converters.StringConverter;
import com.compellingcode.utils.typeconverter.exception.UnknownTypeException;

import junit.framework.TestCase;

@RunWith(JUnit4.class)
public class ConverterFactoryTest extends TestCase {
	
	@Test
	public void testStringConverter() throws Exception {
		ConverterFactory cf = new ConverterFactory();
		
		Converter c = cf.getConverter(String.class);
		
		assertTrue(c instanceof StringConverter);
	}
	
	@Test(expected=UnknownTypeException.class)
	public void testInvalidConverter() throws Exception {
		ConverterFactory cf = new ConverterFactory();
		
		cf.getConverter(Test.class);
	}
	
}

