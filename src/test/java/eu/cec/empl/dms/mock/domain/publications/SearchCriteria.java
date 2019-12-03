package eu.cec.empl.dms.mock.domain.publications;

import lombok.Data;

@Data
public class SearchCriteria {
	
	 private String key;
	 private String operation;
	 private Object value;

}
