package com.nader.gestionCommandes.dao.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="commande")
public class Commande implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comm_seq")
	@SequenceGenerator(name = "comm_seq", sequenceName = "DEMO_ORD_SEQ", allocationSize = 1)
	@Column(name="id_com")
	private Long id_comm;
	
	@Column(name="date_comm")
	@Temporal(TemporalType.DATE)
	private Date date_comm;

	@Column(name="qte_comm")
	private Long qte_comm;

	@Column(name="refprod")
	private Long refprod;
	
	@ManyToOne
	@JoinColumn(name="refprod",referencedColumnName="refprod",insertable=false,updatable=false)
	private Produit produit;

	@Column(name="id_client")
	private Long id_client;

	@ManyToOne
	@JoinColumn(name="id_client",referencedColumnName="numcin",insertable=false,updatable=false)
	private Client client;

	public Commande() {
		super();
	}

	public Long getId_comm() {
		return id_comm;
	}

	public void setId_comm(Long id_comm) {
		this.id_comm = id_comm;
	}

	public Date getDate_comm() {
		return date_comm;
	}

	public void setDate_comm(Date date_comm) {
		this.date_comm = date_comm;
	}

	public Long getQte_comm() {
		return qte_comm;
	}

	public void setQte_comm(Long qte_comm) {
		this.qte_comm = qte_comm;
	}

	public Long getRefprod() {
		return refprod;
	}

	public void setRefprod(Long refprod) {
		this.refprod = refprod;
	}

	public Long getId_client() {
		return id_client;
	}

	public void setId_client(Long id_client) {
		this.id_client = id_client;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
}
