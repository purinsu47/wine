package com.flexisource.winery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "GRAPECOMPONENT")
@Proxy(lazy=false)
public class GrapeComponent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMPONENT_ID") @JsonIgnore
	private Long id;

	@Column(name = "PERCENTAGE")
	private double percentage;
	
	@Column(name = "YEAR")
	private int year;
	
	@Column(name = "VARIETY")
	private String variety;
	
	@Column(name = "REGION")
	private String region;

	@ManyToOne(optional = false)
	@JoinColumn(name = "wine_id")
	private Wine wine;

	public GrapeComponent() {
		super();
	}

	public GrapeComponent(double percentage, int year, String variety, String region) {
		this.percentage = percentage;
		this.year = year;
		this.variety = variety;
		this.region = region;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Wine getWine() {
		return wine;
	}

	public void setWine(Wine wine) {
		this.wine = wine;
	}

	@Override
	public String toString() {
		return "GrapeComponent [id=" + id + ", percentage=" + percentage + ", year=" + year + ", variety=" + variety
				+ ", region=" + region + "]";
	}

}
