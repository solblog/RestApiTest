package eu.cec.empl.dms.mock.domain.publications;

import java.util.List;

import lombok.Data;

/*
 * https://webgate.ec.europa.eu/CITnet/confluence/display/EMPLIT/02.+Search+form
 */

@Data
public class SearchCriteriaDTO {
	
	 private String year;
	 private Long applicationId;
	 private Long callId;
	 private Long programmeId;
	 private List<Long> countries;
	 private List<Long> directTargetGroups;
	 private List<Long> ultimateTargetGroups;
	 private List<Long> policyAreas;
	 private List<Long> languages;

}
