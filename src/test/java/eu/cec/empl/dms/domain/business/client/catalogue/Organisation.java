package eu.cec.empl.dms.domain.business.client.catalogue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import eu.cec.empl.dms.domain.procedures.Publication;

@Entity
@Table(schema = "PUBLIGRANT", name = "TBL_ORGANISATION")
public class Organisation implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator = "PUBLIGRANT.SEQ_ORGANISATION", strategy = SEQUENCE)
    @SequenceGenerator(name = "PUBLIGRANT.SEQ_ORGANISATION", sequenceName = "PUBLIGRANT.SEQ_ORGANISATION", allocationSize = 1)
	private Long id;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "REFERENCE")
    private String reference;
    
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
    
    @ManyToOne
    @JoinColumn(name = "PUBLICATION_ID")
    @JsonIgnore
    private Publication publication;
    
    @Column(name = "TYPE")
    private String type;
    
    @Column(name = "ORGANISATIONCATEGORY_ID")
    private Long organisationCategoryId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public String getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getOrganisationCategoryId() {
		return organisationCategoryId;
	}

	public void setOrganisationCategoryId(Long organisationCategoryId) {
		this.organisationCategoryId = organisationCategoryId;
	}

    
	

    
}