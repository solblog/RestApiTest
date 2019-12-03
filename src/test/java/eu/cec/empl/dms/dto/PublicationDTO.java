package eu.cec.empl.dms.dto;

import java.io.Serializable;
import java.util.List;

public class PublicationDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private boolean visibleOnEuropa = false;
	private String type;
	private String website;
	
	/* This property is not going to be mapped to the domain object as the domain object needs the 
	  id for this type.
	*/
	
	private CallDTO callDTO;
	
	// Grant agreement
	private GrantAgreementDTO grantAgreementDTO;
	
	// Organisations
	private List<OrganisationDTO> organisations;
	
	// Classifications
	private List<Long> listUltimateTargetGroupIds;
	private List<Long> listDirectTargetGroupIds;
	private List<Long> listPolicyAreaIds;
	
	private ActionDTO actionDTO;
	
	private String translations;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean getVisibleOnEuropa() {
		return visibleOnEuropa;
	}

	public void setVisibleOnEuropa(boolean visibleOnEuropa) {
		this.visibleOnEuropa = visibleOnEuropa;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
		
		
	/* DTO */
	
	public ActionDTO getActionDTO() {
		return actionDTO;
	}

	public void setActionDTO(ActionDTO actionDTO) {
		this.actionDTO = actionDTO;
	}

	public CallDTO getCallDTO() {
		return callDTO;
	}

	public void setCallDTO(CallDTO callDTO) {
		this.callDTO = callDTO;
	}

	
	public GrantAgreementDTO getGrantAgreementDTO() {
		return grantAgreementDTO;
	}

	public void setGrantAgreementDTO(GrantAgreementDTO grantAgreementDTO) {
		this.grantAgreementDTO = grantAgreementDTO;
	}

	
	public List<Long> getListUltimateTargetGroupIds() {
		return listUltimateTargetGroupIds;
	}

	public void setListUltimateTargetGroupIds(List<Long> listUltimateTargetGroupIds) {
		this.listUltimateTargetGroupIds = listUltimateTargetGroupIds;
	}

	public List<Long> getListDirectTargetGroupIds() {
		return listDirectTargetGroupIds;
	}

	public void setListDirectTargetGroupIds(List<Long> listDirectTargetGroupIds) {
		this.listDirectTargetGroupIds = listDirectTargetGroupIds;
	}

	public List<Long> getListPolicyAreaIds() {
		return listPolicyAreaIds;
	}

	public void setListPolicyAreaIds(List<Long> listPolicyAreaIds) {
		this.listPolicyAreaIds = listPolicyAreaIds;
	}

	public List<OrganisationDTO> getOrganisations() {
		return organisations;
	}

	public void setOrganisations(List<OrganisationDTO> organisations) {
		this.organisations = organisations;
	}

	public String getTranslations() {
		return translations;
	}

	public void setTranslations(String translations) {
		this.translations = translations;
	}
	

}
