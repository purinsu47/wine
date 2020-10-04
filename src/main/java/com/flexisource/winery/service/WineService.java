package com.flexisource.winery.service;

import java.util.List;

import com.flexisource.winery.model.Wine;


public interface WineService {

	void saveWine(Wine wine);
	
	List<Wine> getAllWines();
	
	void deletWine(Long id);
	
	Wine findById(Long id);
	
	void updateWine(Wine wine);

}
