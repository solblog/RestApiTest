package eu.cec.empl.dms.domain.publications;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GrantedApplication")
public class GrantedApplication implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	
	private int numberOrganisations;
	
	private String startDate;
	private String endDate;
	
	private String countryName;
	private String countryLabel;
	
	private String referenceAgreement;
	private String actionTitle;
	private String programme;
	private String callProposal;
	
	private String summary;
	
	private Double totalInitialCost;
	private Double totalFinalCost;
	
	private Double totalEUFinalCost;
	private Double totalEUInitialCost;
	
	private List<String> listCountries;
	
	private List<String> listDirectTargetGroups;
	private List<String> listUltimateTargetGroups;
	
	private List<String> policiyAreas;
	

	public GrantedApplication() {
	}

	public GrantedApplication(int id, String referenceAgr, String actionTitle, String programme, String callProposal) {
		
		this.id = id;
		this.referenceAgreement = referenceAgr;
		this.actionTitle = actionTitle;
		this.programme = programme;
		this.callProposal = callProposal;
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStartDate() {
		return startDate;
	}

	@XmlElement
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	@XmlElement
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCountryName() {
		return countryName;
	}

	@XmlElement
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryLabel() {
		return countryLabel;
	}

	@XmlElement
	public void setCountryLabel(String countryLabel) {
		this.countryLabel = countryLabel;
	}

	public String getReferenceAgreement() {
		return referenceAgreement;
	}

	@XmlElement
	public void setReferenceAgreement(String referenceAgreement) {
		this.referenceAgreement = referenceAgreement;
	}

	public String getActionTitle() {
		return actionTitle;
	}

	@XmlElement
	public void setActionTitle(String actionTitle) {
		this.actionTitle = actionTitle;
	}

	public String getProgramme() {
		return programme;
	}

	@XmlElement
	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public String getCallProposal() {
		return callProposal;
	}

	@XmlElement
	public void setCallProposal(String callProposal) {
		this.callProposal = callProposal;
	}

	public Double getTotalInitialCost() {
		return totalInitialCost;
	}

	@XmlElement
	public void setTotalInitialCost(Double totalInitialCost) {
		this.totalInitialCost = totalInitialCost;
	}

	public Double getTotalFinalCost() {
		return totalFinalCost;
	}

	@XmlElement
	public void setTotalFinalCost(Double totalFinalCost) {
		this.totalFinalCost = totalFinalCost;
	}

	public Double getTotalEUFinalCost() {
		return totalEUFinalCost;
	}

	@XmlElement
	public void setTotalEUFinalCost(Double totalEUFinalCost) {
		this.totalEUFinalCost = totalEUFinalCost;
	}

	public Double getTotalEUInitialCost() {
		return totalEUInitialCost;
	}

	@XmlElement
	public void setTotalEUInitialCost(Double totalEUInitialCost) {
		this.totalEUInitialCost = totalEUInitialCost;
	}

	public List<String> getListCountries() {
		return listCountries;
	}

	@XmlElement
	public void setListCountries(List<String> listCountries) {
		this.listCountries = listCountries;
	}

	public List<String> getListDirectTargetGroups() {
		return listDirectTargetGroups;
	}

	@XmlElement
	public void setListDirectTargetGroups(List<String> listDirectTargetGroups) {
		this.listDirectTargetGroups = listDirectTargetGroups;
	}

	public List<String> getListUltimateTargetGroups() {
		return listUltimateTargetGroups;
	}

	@XmlElement
	public void setListUltimateTargetGroups(List<String> listUltimateTargetGroups) {
		this.listUltimateTargetGroups = listUltimateTargetGroups;
	}

	public List<String> getPoliciyAreas() {
		return policiyAreas;
	}

	public void setPoliciyAreas(List<String> policiyAreas) {
		this.policiyAreas = policiyAreas;
	}
	
	public int getNumberOrganisations() {
		return numberOrganisations;
	}

	@XmlElement
	public void setNumberOrganisations(int numberOrganisations) {
		this.numberOrganisations = numberOrganisations;
	}
	
	public String getSummary() {
		return summary;
	}

	@XmlElement
	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public boolean equals(Object object) {

		if (object == null) {
			return false;
		} else if (!(object instanceof GrantedApplication)) {
			return false;
		} else {

			GrantedApplication grantedApplication = (GrantedApplication) object;

			/*
			if (id == grantedApplication.getId() && referenceAgreement.equals(grantedApplication.getReference())
					&& actionTitle.equals(grantedApplication.getActionTitle())
					&& programme.equals(grantedApplication.getProgramme())
					&& callProposal.equals(grantedApplication.getCallProposal())) {
				return true;

			} else {
				return false;
			}
			*/
			return false;
		}
	}
	

}
