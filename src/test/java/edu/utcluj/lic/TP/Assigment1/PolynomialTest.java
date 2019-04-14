package edu.utcluj.lic.TP.Assigment1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.utcluj.lic.TP.Assigment1.Logic.Operation;
import edu.utcluj.lic.TP.Assigment1.Model.Polinom;

public class PolynomialTest {

	@Test
	public void testAdd() {
		String p1, p2, prez, ret;
		p1 = new String("1x^5+3x^2+25x^0");
		p2 = new String("2x^3+5x^2+1x^1+10x^0");
		prez = new String("1.0x^5+2.0x^3+8.0x^2+1.0x^1+35.0");

		ret =(Operation.add(new Polinom(p1), new Polinom(p2))).toStringg();
		assertEquals("p1+p2", prez, ret);

	}

	@Test
	public void testSub() {
		String p1, p2, prez, ret;
		p1 = new String("1x^5+3x^2+25x^0");
		p2 = new String("2x^3+5x^2+1x^1+10x^0");
		prez = new String("1.0x^5-2.0x^3-2.0x^2-1.0x^1+15.0");

		ret = (Operation.sub(new Polinom(p1), new Polinom(p2))).toStringg();
		assertEquals("p1-p2", prez, ret);
	}

	@Test
	public void testDeriv() {
		String p1, prez, ret;
		p1 = new String("1x^5+3x^2+25x^0");
		prez = new String("5.0x^4+6.0x^1");

		ret = (Operation.deriv(new Polinom(p1))).toStringg();
		assertEquals("(p1)'", prez, ret);

	}

	@Test
	public void testInteg() {
		String p1, prez, ret;
		p1 = new String("1x^5+3x^2+25x^0");
		prez = new String("0.16666666666666666x^6+1.0x^3+25.0x^1");

		ret = (Operation.integ(new Polinom(p1))).toStringg();
		assertEquals("Integral(p1)", prez, ret);

	}

	@Test
	public void testMul() {
		String p1, p2, prez, ret;
		p1 = new String("1x^5+3x^2+25x^0");
		p2 = new String("2x^3+5x^2+1x^1+10x^0");
		prez = new String("2.0x^8+5.0x^7+1.0x^6+16.0x^5+15.0x^4+53.0x^3+155.0x^2+25.0x^1+250.0");

		ret = (Operation.mul(new Polinom(p1), new Polinom(p2))).toStringg();
		assertEquals("p1*p2", prez, ret);
	}

	@Test
	public void testImp() {
		String p1, p2, prez, ret;
		p1 = new String("1x^3-4x^2+2x^1-3x^0");
		p2 = new String("1x^1+2x^0");
		prez = new String("1.0x^2-6.0x^1+14.0+(-31.0)/(1.0x^1+2.0)");

		Polinom[] p = Operation.div(new Polinom(p1), new Polinom(p2));
		ret = (new Polinom(p2)).concatRezDiv(p);
		assertEquals("p1/p2", prez, ret);
	}

}
