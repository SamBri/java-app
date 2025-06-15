package com.app;

public interface Utils {

	public static final int MAX = 0;

	// functional interface
	public abstract void whoami();

	public static int sum(int a, int b) {

		return a + b;
	}

	default public String guess() {
		return "";
	}

}
