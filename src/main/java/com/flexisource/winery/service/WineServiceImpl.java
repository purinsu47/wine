package com.flexisource.winery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexisource.winery.model.Wine;
import com.flexisource.winery.persistence.WineRepository;

@Service("wineService")
public class WineServiceImpl implements WineService {

	@Autowired
	private WineRepository wineRepo;

	@Override
	public void saveWine(Wine wine) {
		wine.getComponents().forEach(e -> e.setWine(wine));
		wineRepo.save(wine);
	}

	@Override
	public List<Wine> getAllWines() {
		return wineRepo.findAll();
	}

	@Override
	public void deletWine(Long id) {
		wineRepo.deleteById(id);

	}

	@Override
	public Wine findById(Long id) {
		return wineRepo.getOne(id);
	}

	@Override
	public void updateWine(Wine wine) {
		Wine entity = wineRepo.getOne(wine.getId());
		entity.setLotCode(wine.getLotCode());
		entity.setOwnerName(wine.getOwnerName());
		entity.setProductState(wine.getProductState());
		entity.setTankCode(wine.getTankCode());
		entity.setVolume(wine.getVolume());
		wineRepo.save(entity);
	}

}
