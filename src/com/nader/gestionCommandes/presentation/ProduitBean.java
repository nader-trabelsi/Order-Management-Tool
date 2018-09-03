package com.nader.gestionCommandes.presentation;

import java.text.ParseException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.validation.constraints.NotNull;
import com.nader.gestionCommandes.cdc.ProduitCdC;
import com.nader.gestionCommandes.cdc.ProduitCdCImp;
import com.nader.gestionCommandes.dao.entites.Produit;

@ManagedBean(name="produitBean")
@RequestScoped
public class ProduitBean {

	private String msgSucces;

	@NotNull
	private Long refprod;
	@NotNull
	private String libelle;
	@NotNull
	private Long qte;
	

	private ProduitCdC cdcProd = new ProduitCdCImp();


	@PostConstruct
	public void avantAjoutProduit() {

	}


	public void ajouterProduit(ActionEvent e) throws ParseException {

		msgSucces="";

			Produit p = new Produit();
			p.setRefprod(refprod);
			p.setQt_dispo(qte);
			p.setLibelle(libelle);
			cdcProd.add(p);

			msgSucces="Produit bien ajouté";

			refprod=null;
			libelle="";
			qte=null;

	}

	public Long getRefprod() {
		return refprod;
	}
	public void setRefprod(Long refprod) {
		this.refprod = refprod;
	}


	public ProduitCdC getCdcProd() {
		return cdcProd;
	}

	public void setCdcProd(ProduitCdC cdcProd) {
		this.cdcProd = cdcProd;
	}

	public String getMsgSucces() {
		return msgSucces;
	}

	public void setMsgSucces(String msgSucces) {
		this.msgSucces = msgSucces;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public Long getQte() {
		return qte;
	}


	public void setQte(Long qte) {
		this.qte = qte;
	}


}