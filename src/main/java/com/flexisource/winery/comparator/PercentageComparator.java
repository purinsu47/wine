package com.flexisource.winery.comparator;

import java.util.Comparator;

import com.flexisource.winery.model.GrapeComponent;


public class PercentageComparator implements Comparator<GrapeComponent>{

	@Override
	public int compare(GrapeComponent o1, GrapeComponent o2) {
		return Double.compare(o1.getPercentage(), o2.getPercentage());
	}

}
