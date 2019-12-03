package eu.cec.empl.dms.dto;

public class CallDTO {
	
	private String reference;
	
	/* Programme should be a code */
	private Long programmeId;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Long getProgrammeId() {
		return programmeId;
	}

	public void setProgrammeId(Long programmeId) {
		this.programmeId = programmeId;
	}
		

}
