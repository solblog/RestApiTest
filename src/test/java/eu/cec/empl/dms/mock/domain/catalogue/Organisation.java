package eu.cec.empl.dms.mock.domain.catalogue;

import lombok.Data;

@Data
public class Organisation {
	
    private Long id;
    private String name;
    private String reference;
    private String address1;
    private String address2;
    private String postalCode;
    private String town;
    private String telephone1;
    private String telephone2;
    private String fax;
    private String mobilePhone;
    private String email;
    private String webSite;
    private String vatNumber;
    private String registrationNumber;
    private String comments;
    private String type;
	private Long countryId;

}
