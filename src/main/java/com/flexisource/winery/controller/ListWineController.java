package com.flexisource.winery.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.flexisource.winery.comparator.GrapeComponentComparator;
import com.flexisource.winery.comparator.PercentageComparator;
import com.flexisource.winery.comparator.RegionComparator;
import com.flexisource.winery.comparator.VarietyComparator;
import com.flexisource.winery.comparator.YearComparator;
import com.flexisource.winery.model.GrapeComponent;
import com.flexisource.winery.model.Wine;
import com.flexisource.winery.service.GrapeComponentService;
import com.flexisource.winery.service.WineService;

@Scope(value = "session")
@Component(value = "listWines")
@ELBeanName(value = "listWines")
@Join(path = "/", to = "/wine/wine-list.jsf")
public class ListWineController {

	@Autowired
	private WineService wineService;

	@Autowired
	private GrapeComponentService grapeComService;

	private List<Wine> wines;

	private List<GrapeComponent> components;

	private List<GrapeComponent> componentsYear;

	private List<GrapeComponent> componentsVariety;

	private List<GrapeComponent> componentsRegion;

	private List<GrapeComponent> componentsYearVariety;

	private Wine wine;

	@Deferred
	@RequestAction
	@IgnorePostback
	public void findAll() {
		wines = wineService.getAllWines();
	}

	public String delete(Long id) {
		wineService.deletWine(id);
		findAll();
		return null;
	}

	public String update() {
		wineService.updateWine(wine);
		return null;
	}

	public String view(Long id) {
		wine = wineService.findById(id);
		Set<GrapeComponent> components = grapeComService.findAllByWineId(id);
		this.components = grapeComponents(components);
		componentsYear = grapeComponentsPerYear(components);
		componentsVariety = grapeComponentsPerVariety(components);
		componentsRegion = grapeComponentsPerRegion(components);
		componentsYearVariety = grapeComponentsPerYearVariety(components);
		return "/wine/wine-layout.jsf";
	}

	public List<Wine> getWines() {
		return wines;
	}

	public List<GrapeComponent> getComponents() {
		return components;
	}

	public List<GrapeComponent> getComponentsYear() {
		return componentsYear;
	}

	public List<GrapeComponent> getComponentsVariety() {
		return componentsVariety;
	}

	public List<GrapeComponent> getComponentsRegion() {
		return componentsRegion;
	}

	public List<GrapeComponent> getComponentsYearVariety() {
		return componentsYearVariety;
	}

	public Wine getWine() {
		return wine;
	}

	private List<GrapeComponent> grapeComponents(Set<GrapeComponent> components) {
		List<GrapeComponent> list = new ArrayList<GrapeComponent>(components);
		Collections.sort(list, new GrapeComponentComparator(new PercentageComparator().reversed(), new YearComparator(),
				new VarietyComparator(), new RegionComparator()));
		return list;
	}

	private List<GrapeComponent> grapeComponentsPerYear(Set<GrapeComponent> components) {
		List<GrapeComponent> list = sumPerProperties(new ArrayList<GrapeComponent>(components), "year");
		Collections.sort(list,
				new GrapeComponentComparator(new PercentageComparator().reversed(), new YearComparator().reversed()));
		return list;
	}

	private List<GrapeComponent> grapeComponentsPerVariety(Set<GrapeComponent> components) {
		List<GrapeComponent> list = sumPerProperties(new ArrayList<GrapeComponent>(components), "variety");
		Collections.sort(list, new GrapeComponentComparator(new PercentageComparator().reversed(),
				new VarietyComparator().reversed()));
		return list;
	}

	private List<GrapeComponent> grapeComponentsPerRegion(Set<GrapeComponent> components) {
		List<GrapeComponent> list = sumPerProperties(new ArrayList<GrapeComponent>(components), "region");
		Collections.sort(list,
				new GrapeComponentComparator(new PercentageComparator().reversed(), new RegionComparator().reversed()));
		return list;
	}

	private List<GrapeComponent> grapeComponentsPerYearVariety(Set<GrapeComponent> components) {
		List<GrapeComponent> list = new ArrayList<GrapeComponent>(components);

		Map<Integer, Map<String, Double>> groupBy = list.stream().collect(
				Collectors.groupingBy(GrapeComponent::getYear, Collectors.groupingBy(GrapeComponent::getVariety,
						Collectors.summingDouble(GrapeComponent::getPercentage))));

		List<GrapeComponent> listToSort = new ArrayList<GrapeComponent>();
		for (Entry<Integer, Map<String, Double>> entry : groupBy.entrySet()) {
			Map<String, Double> insideMap = entry.getValue();
			for (Entry<String, Double> insideEntry : insideMap.entrySet()) {
				listToSort.add(new GrapeComponent(insideEntry.getValue(), entry.getKey(), insideEntry.getKey(), ""));
			}
		}
		Collections.sort(listToSort, new GrapeComponentComparator(new PercentageComparator().reversed(),
				new YearComparator().reversed(), new VarietyComparator().reversed()));
		return listToSort;
	}

	private static List<GrapeComponent> sumPerProperties(List<GrapeComponent> grapeComps, String... properties) {
		Map<String, GrapeComponent> map = new HashMap<String, GrapeComponent>();
		for (GrapeComponent p : grapeComps) {
			GrapeComponent grape = null;

			if (properties[0].equalsIgnoreCase("variety")) {
				grape = map.computeIfAbsent(p.getVariety(), n -> new GrapeComponent(0d, 00, p.getVariety(), ""));
			} else if (properties[0].equalsIgnoreCase("year")) {
				String year = Integer.toString(p.getYear());
				grape = map.computeIfAbsent(year, n -> new GrapeComponent(0d, p.getYear(), "", ""));
			} else if (properties[0].equalsIgnoreCase("region")) {
				grape = map.computeIfAbsent(p.getRegion(), n -> new GrapeComponent(0d, 00, "", p.getRegion()));
			}

			grape.setPercentage(grape.getPercentage() + p.getPercentage());
		}
		return new ArrayList<>(map.values());
	}

}
