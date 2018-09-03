package com.nader.gestionCommandes.presentation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.validation.constraints.NotNull;
import com.nader.gestionCommandes.cdc.ClientCdC;
import com.nader.gestionCommandes.cdc.ClientCdCImp;
import com.nader.gestionCommandes.cdc.CommandeCdC;
import com.nader.gestionCommandes.cdc.CommandeCdCImp;
import com.nader.gestionCommandes.cdc.ProduitCdC;
import com.nader.gestionCommandes.cdc.ProduitCdCImp;
import com.nader.gestionCommandes.dao.entites.Client;
import com.nader.gestionCommandes.dao.entites.Commande;
import com.nader.gestionCommandes.dao.entites.Produit;

@ManagedBean(name="commandeBean")
@RequestScoped
public class CommandeBean {

	private String msgSucces;
	private Date today;

	@NotNull
	private Date date_comm;
	@NotNull
	private Long qte_comm;
	@NotNull
	private Long refprod;
	@NotNull
	private Long id_client;
	@NotNull
	private String nomC;
	@NotNull
	private String prenomC;

	List<SelectItem> listeRefProd = new ArrayList<>();
	List<Commande> listeComm = new ArrayList<>();
	private CommandeCdC cdcComm = new CommandeCdCImp();
	private ClientCdC cdcClt = new ClientCdCImp();
	private ProduitCdC cdcProd = new ProduitCdCImp();


	@PostConstruct
	public void avantCommande() {
		
		// ***** Aujourd'hui ******
		today = new Date();
		// ***** Liste Commandes: ******
		listeComm=cdcComm.findAll();



		// ***** Liste Produits: ******
		List<Produit> listeProd = cdcProd.findAll();
		for(Produit p : listeProd) {
			listeRefProd.add(new SelectItem(p.getRefprod(),p.getLibelle()));
		}


	}


	public void ajouterCommande(ActionEvent e) throws ParseException {

		msgSucces="";

		if(cdcProd.updateQT(refprod, qte_comm)) {

			Client c = new Client();
			c.setNumcin(Long.valueOf(id_client));
			c.setNom(nomC);
			c.setPrenom(prenomC);
			cdcClt.add(c);

			Commande cm = new Commande();
			cm.setDate_comm(date_comm);
			cm.setId_client(Long.valueOf(id_client));
			cm.setQte_comm(Long.valueOf(qte_comm));
			cm.setRefprod(refprod);
			cdcComm.add(cm);

			msgSucces="Commande bien ajouté";

			date_comm=null;
			qte_comm=null;
			refprod=null;
			id_client=null;
			nomC="";prenomC="";
		} else {
			msgSucces="La quantité demandée n'est pas disponible!";
		}

	}
	
	public void supprimer(ActionEvent ev) {
		FacesContext fc = FacesContext.getCurrentInstance();
	    Map<String, String> parametres = fc.getExternalContext().getRequestParameterMap();
		cdcComm.delete(Long.valueOf(parametres.get("idCom")));
		listeComm = cdcComm.findAll();
	}
	
	public Date getToday() {
        return new Date();
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
	public List<SelectItem> getListeRefProd() {
		return listeRefProd;
	}
	public void setListeRefProd(List<SelectItem> listeRefProd) {
		this.listeRefProd = listeRefProd;
	}
	public String getNomC() {
		return nomC;
	}
	public void setNomC(String nomC) {
		this.nomC = nomC;
	}
	public String getPrenomC() {
		return prenomC;
	}
	public void setPrenomC(String prenomC) {
		this.prenomC = prenomC;
	}

	public CommandeCdC getCdcComm() {
		return cdcComm;
	}

	public void setCdcComm(CommandeCdC cdcComm) {
		this.cdcComm = cdcComm;
	}

	public ClientCdC getCdcClt() {
		return cdcClt;
	}

	public void setCdcClt(ClientCdC cdcClt) {
		this.cdcClt = cdcClt;
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

	public List<Commande> getListeComm() {
		return listeComm;
	}

	public void setListeComm(List<Commande> listeComm) {
		this.listeComm = listeComm;
	}



}
