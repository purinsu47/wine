package com.flexisource.winery.comparator;

import java.util.Comparator;

import com.flexisource.winery.model.GrapeComponent;


public class RegionComparator implements Comparator<GrapeComponent>{

	@Override
	public int compare(GrapeComponent o1, GrapeComponent o2) {
		// TODO Auto-generated method stub
		return o1.getRegion().compareTo(o2.getRegion());
	}

}
