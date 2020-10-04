package com.flexisource.winery.comparator;

import java.util.Comparator;

import com.flexisource.winery.model.GrapeComponent;


public class VarietyComparator implements Comparator<GrapeComponent>{

	@Override
	public int compare(GrapeComponent o1, GrapeComponent o2) {
		// TODO Auto-generated method stub
		return o1.getVariety().compareTo(o2.getVariety());
	}

}
