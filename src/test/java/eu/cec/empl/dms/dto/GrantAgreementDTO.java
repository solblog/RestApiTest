package eu.cec.empl.dms.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class GrantAgreementDTO {
	
private static final long serialVersionUID = 1L;
	
	
	private Long id;


	private String reference; // GrantAgreementReference
	private String selectionProcedureRef; //referencecallProposal
	private String translations;
	private String webSite;
	
    private BigDecimal initialEuContribution;
    private BigDecimal finalEuContribution;
    private BigDecimal initialTotalCost;
    private BigDecimal finalTotalCost;
    
	private Boolean visibleOnEuropa = false;
	
	private Long programmeId;
	private Long publicationTypeId;
	
	private String Website;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSelectionProcedureRef() {
		return selectionProcedureRef;
	}

	public void setSelectionProcedureRef(String selectionProcedureRef) {
		this.selectionProcedureRef = selectionProcedureRef;
	}

	public String getTranslations() {
		return translations;
	}

	public void setTranslations(String translations) {
		this.translations = translations;
	}
	
	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	
	
	public BigDecimal getInitialEuContribution() {
		return initialEuContribution;
	}

	public void setInitialEuContribution(BigDecimal initialEuContribution) {
		this.initialEuContribution = initialEuContribution;
	}

	public BigDecimal getFinalEuContribution() {
		return finalEuContribution;
	}

	public void setFinalEuContribution(BigDecimal finalEuContribution) {
		this.finalEuContribution = finalEuContribution;
	}

	public BigDecimal getInitialTotalCost() {
		return initialTotalCost;
	}

	public void setInitialTotalCost(BigDecimal initialTotalCost) {
		this.initialTotalCost = initialTotalCost;
	}

	public BigDecimal getFinalTotalCost() {
		return finalTotalCost;
	}

	public void setFinalTotalCost(BigDecimal finalTotalCost) {
		this.finalTotalCost = finalTotalCost;
	}

	public Long getProgrammeId() {
		return programmeId;
	}

	public void setProgrammeId(Long programmeId) {
		this.programmeId = programmeId;
	}

	public Long getPublicationTypeId() {
		return publicationTypeId;
	}

	public void setPublicationTypeId(Long publicationTypeId) {
		this.publicationTypeId = publicationTypeId;
	}

	public String getWebsite() {
		return Website;
	}

	public void setWebsite(String website) {
		Website = website;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Boolean getVisibleOnEuropa() {
		return visibleOnEuropa;
	}

	public void setVisibleOnEuropa(Boolean visibleOnEuropa) {
		this.visibleOnEuropa = visibleOnEuropa;
	}
	
		
	


}
