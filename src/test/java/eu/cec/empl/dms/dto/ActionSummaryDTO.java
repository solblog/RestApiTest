package eu.cec.empl.dms.dto;

import java.util.Date;

public class ActionSummaryDTO {
	
	String grantAgreementReference;
	
	ActionDTO actionDTO;

	public String getGrantAgreementReference() {
		return grantAgreementReference;
	}

	public void setGrantAgreementReference(String grantAgreementReference) {
		this.grantAgreementReference = grantAgreementReference;
	}

	public ActionDTO getActionDTO() {
		if (actionDTO == null) 
			actionDTO = new ActionDTO();
		return actionDTO;
	}

	public void setActionDTO(ActionDTO actionDTO) {
		this.actionDTO = actionDTO;
	}
	

}
