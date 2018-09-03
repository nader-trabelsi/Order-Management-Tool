package com.nader.gestionCommandes.dao.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="produit")
public class Produit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="refprod")
	private Long refprod;
	
	@Column(name="libelle")
	private String libelle;
	
	@Column(name="qt_dispo")
	private Long qt_dispo;

	public Produit() {
		super();
	}

	public Long getRefprod() {
		return refprod;
	}

	public void setRefprod(Long refprod) {
		this.refprod = refprod;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Long getQt_dispo() {
		return qt_dispo;
	}

	public void setQt_dispo(Long qt_dispo) {
		this.qt_dispo = qt_dispo;
	}
	
	
	
}
