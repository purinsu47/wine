package com.flexisource.winery.service;

import java.util.Set;

import com.flexisource.winery.model.GrapeComponent;

public interface GrapeComponentService {
	
	Set<GrapeComponent> findAllByWineId(Long id);

}
