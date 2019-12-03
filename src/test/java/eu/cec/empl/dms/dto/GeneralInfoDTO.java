package eu.cec.empl.dms.dto;

import java.io.Serializable;

public class GeneralInfoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private CallDTO callDTO;

	private GrantAgreementDTO grantAgreementDTO;
	
	private ActionDTO actionDTO;
	
	private String webSite;
	
	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
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

	public ActionDTO getActionDTO() {
		return actionDTO;
	}

	public void setActionDTO(ActionDTO actionDTO) {
		this.actionDTO = actionDTO;
	}
	

}
