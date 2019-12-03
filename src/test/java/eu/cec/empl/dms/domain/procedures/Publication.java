package eu.cec.empl.dms.domain.procedures;

import static javax.persistence.GenerationType.SEQUENCE;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


public class Publication {

    
    private Long id;

    private String reference;
    private String selectionProcedureRef;
    private String translations;
    private Date startDate;
    private Date endDate;
    private String webSite;    
    private Long programmeId;
    private Double initialEuContribution;
    private Double finalEuContribution;
    private Double initialTotalCost;
    private Double finalTotalCost;
    private Integer visibleOnEuropa;
    private Long publicationTypeId;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getReference() {
		return reference;
	}
	
	public void setReference(String reference) {
		this.reference = reference;
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
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getWebSite() {
		return webSite;
	}
	
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	
	public Long getProgrammeId() {
		return programmeId;
	}
	
	public void setProgrammeId(Long programmeId) {
		this.programmeId = programmeId;
	}
	
	public Double getInitialEuContribution() {
		return initialEuContribution;
	}
	
	public void setInitialEuContribution(Double initialEuContribution) {
		this.initialEuContribution = initialEuContribution;
	}
	
	public Double getFinalEuContribution() {
		return finalEuContribution;
	}
	
	public void setFinalEuContribution(Double finalEuContribution) {
		this.finalEuContribution = finalEuContribution;
	}
	
	public Double getInitialTotalCost() {
		return initialTotalCost;
	}
	
	public void setInitialTotalCost(Double initialTotalCost) {
		this.initialTotalCost = initialTotalCost;
	}
	
	public Double getFinalTotalCost() {
		return finalTotalCost;
	}
	
	public void setFinalTotalCost(Double finalTotalCost) {
		this.finalTotalCost = finalTotalCost;
	}
	
	public Integer getVisibleOnEuropa() {
		return visibleOnEuropa;
	}
	
	public void setVisibleOnEuropa(Integer visibleOnEuropa) {
		this.visibleOnEuropa = visibleOnEuropa;
	}
	
	public Long getPublicationTypeId() {
		return publicationTypeId;
	}
	
	public void setPublicationTypeId(Long publicationTypeId) {
		this.publicationTypeId = publicationTypeId;
	}
    
    
    
}
