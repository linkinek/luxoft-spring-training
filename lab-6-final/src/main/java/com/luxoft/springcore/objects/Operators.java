package com.luxoft.springcore.objects;

import org.springframework.stereotype.Component;

@Component
public class Operators {
	
	private boolean ageComparisonTest;
	private boolean distanceComparisonTest;
	
	public boolean isAgeComparisonTest() {
		return ageComparisonTest;
	}

	public void setAgeComparisonTest(boolean ageComparisonTest) {
		this.ageComparisonTest = ageComparisonTest;
	}

	public boolean isDistanceComparisonTest() {
		return distanceComparisonTest;
	}

	public void setDistanceComparisonTest(boolean distanceComparisonTest) {
		this.distanceComparisonTest = distanceComparisonTest;
	}

}
