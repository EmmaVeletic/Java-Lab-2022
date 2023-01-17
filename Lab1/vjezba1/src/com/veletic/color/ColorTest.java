package com.veletic.color;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.*;

public class ColorTest {

	@Test
	public void decodeTest() {
		String givenHex = "0xB12D9B";
		int expectedRed = 177;
		int expectedGreen = 45;
		int expectedBlue = 155;

		ColorCustom result = ColorCustom.decode(givenHex);

		assertEquals(expectedRed, result.getRed());
		assertEquals(expectedGreen, result.getGreen());
		assertEquals(expectedBlue, result.getBlue());
		assertNotEquals(expectedRed, result.getBlue());
	}

	@Test
	public void RGBtoHSBTest() {
		int givenRed = 45;
		int givenGreen = 220;
		int givenBlue = 250;
		float[] givenHSB = new float[3];
		float[] expectedHSB = { (float) 0.5243902, (float) 0.82, (float) 0.98039215 };

		float[] result = ColorCustom.RGBtoHSB(givenRed, givenGreen, givenBlue, givenHSB);

		assertEquals(expectedHSB[0], result[0], 1e-7);
		assertEquals(expectedHSB[1], result[1], 1e-7);
		assertEquals(expectedHSB[2], result[2], 1e-7);
	}

	@Test
	public void RGBtoHSLTest() {
		int givenRed = 45;
		int givenGreen = 220;
		int givenBlue = 250;
		float[] givenHSL = new float[3];
		float[] expectedHSL = { (float) 3.1463412385, (float) 0.95348834, (float) 0.5784313 };

		float[] result = ColorCustom.RGBtoHSL(givenRed, givenGreen, givenBlue, givenHSL);

		assertEquals(expectedHSL[0], result[0], 1e-7);
		assertEquals(expectedHSL[1], result[1], 1e-7);
		assertEquals(expectedHSL[2], result[2], 1e-7);
	}

	@Test
	public void RGBtoCMYKTest() {
		int givenRed = 45;
		int givenGreen = 220;
		int givenBlue = 250;
		float[] givenCMYK = new float[4];
		float[] expectedCMYK = { (float) 0.81999999, (float) 0.11999999, (float) 0.0, (float) 0.0 };

		float[] result = ColorCustom.RGBtoCMYK(givenRed, givenGreen, givenBlue, givenCMYK);

		assertEquals(expectedCMYK[0], result[0], 1e-7);
		assertEquals(expectedCMYK[1], result[1], 1e-7);
		assertEquals(expectedCMYK[2], result[2], 1e-7);
	}
}