package com.flexisource.winery.configuration;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.flexisource.winery.model.GrapeComponent;
import com.flexisource.winery.model.Wine;
import com.flexisource.winery.persistence.WineRepository;

@Component
public class WineCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	private WineRepository wineRepo;

	@Override
	public void run(String... args) throws Exception {

		for(Wine wine : wineRepo.findAll()) {
			System.out.println(wine.toString());
			Set<GrapeComponent> components = wine.getComponents();
			for(GrapeComponent comp : components) {
				System.out.println(comp.toString());
			}
		}
		
	}

}
