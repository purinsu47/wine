package com.flexisource.winery.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "WINE")
@Proxy(lazy = false)
public class Wine implements Serializable {

	private static final long serialVersionUID = -6892434771833441384L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WINE_ID")
	private Long id;

	@Column(name = "LOT_CODE")
	private String lotCode;

	@Column(name = "VOLUME")
	private double volume;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "TANK_CODE")
	private String tankCode;

	@Column(name = "PRODUCT_STATE")
	private String productState;

	@Column(name = "OWNER_NAME")
	private String ownerName;

	@OneToMany(mappedBy = "wine", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<GrapeComponent> components = new HashSet<GrapeComponent>();

	public Wine() {
		super();
	}

	public Wine(String lotCode, double volume) {
		this.lotCode = lotCode;
		this.volume = volume;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<GrapeComponent> getComponents() {
		return components;
	}

	public void setComponents(Set<GrapeComponent> components) {
		this.components = components;
	}

	public String getLotCode() {
		return lotCode;
	}

	public void setLotCode(String lotCode) {
		this.lotCode = lotCode;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTankCode() {
		return tankCode;
	}

	public void setTankCode(String tankCode) {
		this.tankCode = tankCode;
	}

	public String getProductState() {
		return productState;
	}

	public void setProductState(String productState) {
		this.productState = productState;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Override
	public String toString() {
		return "Wine [id=" + id + ", lotCode=" + lotCode + ", volume=" + volume + ", description=" + description
				+ ", tankCode=" + tankCode + ", productState=" + productState + ", ownerName=" + ownerName + "]";
	}

}
