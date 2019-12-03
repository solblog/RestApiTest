package eu.cec.empl.dms.domain.business.client.catalogue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(schema = "PUBLIGRANT", name = "TBL_ORGANISATION")
public class OrganisationDTODelete{


    @Id
    private Long id;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "REFERENCE")
    private String reference;
    
    @Column(name = "ORGANISATIONCATEGORY_ID")
    private Long organisationCategoryId;
    
    @Column(name = "ADDRESS1")
    private String address1;
    
    @Column(name = "ADDRESS2")
    private String address2;

    @Column(name = "COUNTRY_ID")
    private Long countryId;
    
    @Column(name = "POSTALCODE")
    private String postalCode;
    
    @Column(name = "TOWN")
    private String town;
    
    @Column(name = "TELEPHONE1")
    private String telephone1;
    
    @Column(name = "TELEPHONE2")
    private String telephone2;
    
    @Column(name = "FAX")
    private String fax;
    
    @Column(name = "MOBILEPHONE")
    private String mobilePhone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "WEBSITE")
    private String webSite;
    @Column(name = "VATNUMBER")
    private String vatNumber;
    @Column(name = "REGISTRATIONNUMBER")
    private String registrationNumber;
    @Column(name = "COMMENTS")
    private String comments;
    
    @Column(name = "PUBLICATION_ID")
    private Long publicationId;
    
    @Column(name = "TYPE")
    private String type;


    
}