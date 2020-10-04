package com.flexisource.winery.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexisource.winery.model.GrapeComponent;
import com.flexisource.winery.persistence.GrapeComponentRepository;

@Service("grapeComponentService")
public class GrapeComponentServiceImpl implements GrapeComponentService {

	@Autowired
	private GrapeComponentRepository grapeRepo;

	@Override
	public Set<GrapeComponent> findAllByWineId(Long id) {
		return grapeRepo.findAllByWineId(id);
	}

}
