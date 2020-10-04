package com.flexisource.winery.comparator;

import java.util.Comparator;

import com.flexisource.winery.model.GrapeComponent;

public class YearComparator implements Comparator<GrapeComponent> {

	@Override
	public int compare(GrapeComponent o1, GrapeComponent o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1.getYear(), o2.getYear());
	}

}
