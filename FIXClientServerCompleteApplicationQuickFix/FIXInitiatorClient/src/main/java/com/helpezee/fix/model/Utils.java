package com.helpezee.fix.model;

public class Utils {
	
	private final static double EPSILON = 0.00001;

	public static boolean areDoublesEqual(double left, double right) {
		return Math.abs(left - right) < EPSILON;
	}

}
