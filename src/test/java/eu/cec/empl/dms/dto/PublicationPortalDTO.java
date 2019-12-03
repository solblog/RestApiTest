package eu.cec.empl.dms.dto;

import lombok.Data;

@Data
public class PublicationPortalDTO {
	
	private Long id; 
	private String reference;
	private String selectionProcedureRef;
	private String translations;
	private String startDate;
	private String endDate;
	private String webSite;
	private String programmeId;
	private String initialEuContribution;
	private String finalEuContribution;
	private String initialTotalCost;
	private String finalTotalCost;
	private String visibleOnEuropa;
	private String publicationTypeId;
	
	
	

}
