package com.flexisource.winery.controller;


import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.flexisource.winery.model.Wine;
import com.flexisource.winery.service.WineService;


@Scope(value = "session")
@Component(value = "viewController")
@ELBeanName(value = "viewController")
@Join(path = "/wine/view", to = "/wine/wine-layout.jsf")
public class ViewController {

	@Autowired
	private WineService wineService;
	
	private Wine wine;

	public String save() {
		wineService.saveWine(wine);
		wine = new Wine();
		return "/wine/wine-list.xhtml?faces-redirect=true";
	}
	public Wine getWine() {
		return wine;
	}

}
