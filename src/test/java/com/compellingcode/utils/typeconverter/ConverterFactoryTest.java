package com.compellingcode.utils.typeconverter;

import org.junit.Test;

import com.compellingcode.utils.typeconverter.converters.StringConverter;

import junit.framework.TestCase;

public class ConverterFactoryTest extends TestCase {
	
	@Test
	public void testStringConverter() throws Exception {
		ConverterFactory cf = new ConverterFactory();
		
		Converter c = cf.getConverter(String.class);
		
		assertTrue(c instanceof StringConverter);
	}
	
}

