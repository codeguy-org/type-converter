package com.compellingcode.utils.typeconverter.converters;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.compellingcode.utils.typeconverter.exception.ConversionErrorException;

@RunWith(JUnit4.class)
public class BooleanConverterTest {

	@Test
	public void testSuccessfulConversions() throws Exception {
		BooleanConverter bc = new BooleanConverter();
		
		assertEquals(bc.convert("true", Boolean.class), Boolean.TRUE);
		assertEquals(bc.convert("True", Boolean.class), Boolean.TRUE);
		assertEquals(bc.convert("TRUE", Boolean.class), Boolean.TRUE);
		assertEquals(bc.convert("false", Boolean.class), Boolean.FALSE);
		assertEquals(bc.convert("False", Boolean.class), Boolean.FALSE);
		assertEquals(bc.convert("FALSE", Boolean.class), Boolean.FALSE);
	}

	@Test(expected = ConversionErrorException.class)
	public void testNullConversionOfPrimitiveType() throws ConversionErrorException {
		BooleanConverter bc = new BooleanConverter();
		
		assertEquals(bc.convert(null, boolean.class), Boolean.TRUE);
	}

	@Test()
	public void testNullConversion() throws ConversionErrorException {
		BooleanConverter bc = new BooleanConverter();
		
		assertEquals(bc.convert(null, Boolean.class), null);
	}

}
