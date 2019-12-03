package eu.cec.empl.dms.test.tools;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import com.github.javafaker.Faker;

import eu.cec.empl.dms.domain.business.client.catalogue.DirectTargetGroup;
import eu.cec.empl.dms.dto.ActionDTO;
import eu.cec.empl.dms.dto.ActionSummaryDTO;
import eu.cec.empl.dms.dto.CallDTO;
import eu.cec.empl.dms.dto.GeneralInfoDTO;
import eu.cec.empl.dms.dto.GrantAgreementDTO;
import eu.cec.empl.dms.dto.OrganisationDTO;
import eu.cec.empl.dms.dto.PublicationDTO;
import eu.cec.empl.dms.mock.domain.catalogue.Organisation;


public class FakeObjectsFactory {
	
	// DirectTargetGroup
	// https://www.programcreek.com/java-api-examples/index.php?api=com.github.javafaker.Faker
	
	private static Faker faker = new Faker();
	private static Random rand = new Random();
	
	
	/**
	 * Data transfer object
	 * @param directTargetGroup
	 * @return
	 */
	
	public static PublicationDTO getPublicationDTO(){
		
		PublicationDTO publicationDTO = new PublicationDTO();
		// grantAgreementDTO.setProgrammeId(new Long(faker.number().numberBetween(1, 4)));
		// grantAgreementDTO.setPublicationTypeId(new Long(1));
		

		/* Generating publication Data */
		publicationDTO.setVisibleOnEuropa(false);
		publicationDTO.setType("Grant"); /* Should be an Enum */
		
		/* Generating call Data */
		publicationDTO.setCallDTO(getCallDTO());
		
		/* Generating Grant agreement data */
		publicationDTO.setGrantAgreementDTO(getGrantAgreementDTO());
		
		/* load organisation */
		loadOrganisations(publicationDTO);
		
		/* Generating classifications */
		
		publicationDTO.setListDirectTargetGroupIds(getDirectTargetGroupList());
		publicationDTO.setListUltimateTargetGroupIds(getUltimateTargetGroupList());
		publicationDTO.setListPolicyAreaIds(getPoliciyAreasList());
		
		/* Generating action data */
		
		ActionDTO actionDTO = getActionDTO();
		publicationDTO.setActionDTO(actionDTO);
		
		return publicationDTO;
		
	}


	private static void loadOrganisations(PublicationDTO publicationDTO) {
		
		
		List<OrganisationDTO> organisationList = new ArrayList<OrganisationDTO>();
		
		OrganisationDTO organisation1 = getOrganisationDTO(); 
		organisation1.setType(EnumOrganisationType.getCoordinator());
		// ?????
		publicationDTO.setWebsite(organisation1.getWebSite());
		
		OrganisationDTO organisation2 = getOrganisationDTO();
		OrganisationDTO organisation3 = getOrganisationDTO();
		
		organisationList.add(organisation1);
		organisationList.add(organisation2);
		organisationList.add(organisation3);
		
		publicationDTO.setOrganisations(organisationList);  
		
	}
	
	
	public static GrantAgreementDTO getGrantAgreementDTO(){
		
		GrantAgreementDTO grantAgreementDTO = new GrantAgreementDTO();
		
		grantAgreementDTO.setReference("VS/2019/"+rand.nextInt(1000));
		grantAgreementDTO.setSelectionProcedureRef("VP/2019/"+rand.nextInt(1000));
		
		grantAgreementDTO.setInitialEuContribution(new BigDecimal(rand.nextInt(1000000)));
		grantAgreementDTO.setFinalEuContribution(new BigDecimal(rand.nextInt(1000000)));
		grantAgreementDTO.setInitialTotalCost(new BigDecimal(rand.nextInt(1000000)));
		grantAgreementDTO.setFinalTotalCost(new BigDecimal(rand.nextInt(1000000)));
		
		grantAgreementDTO.setWebsite(faker.company().url());
		
		// grantAgreementDTO.setProgrammeId(new Long(faker.number().numberBetween(1, 4)));
		// grantAgreementDTO.setPublicationTypeId(new Long(1));
		
		return 	grantAgreementDTO;
		
	}
	
	
	public static GeneralInfoDTO getGeneralInfoDTO(){
		
		GeneralInfoDTO generalInfoDTO = new GeneralInfoDTO();
		
		generalInfoDTO.setGrantAgreementDTO(getGrantAgreementDTO());
		
		generalInfoDTO.setCallDTO(getCallDTO());
		
		generalInfoDTO.setWebSite("www.test.com");
		
		return generalInfoDTO;
		
	}
	
	
	
	
	public static OrganisationDTO getOrganisationDTO(){
		
		
		OrganisationDTO organisation = new OrganisationDTO();
		
		organisation.setName(faker.company().name());
	    
	    organisation.setReference(faker.company().suffix());
	    	    
	    /* Check if there is constraint with the Categories */
	    
	    /* 
	     * select * from DEFIS_EVAL.TBL_ORGANISATIONCATEGORY order by id
	     */
	    
	    organisation.setOrganisationCategoryId(new Long(faker.number().numberBetween(1, 20)));
	    
	    organisation.setAddress1(faker.address().streetAddress());
	    
	    organisation.setAddress2(faker.address().streetAddress());

	    
	    organisation.setCountryId(new Long(faker.number().numberBetween(1, 100)));

	    organisation.setPostalCode(faker.address().zipCode());

	    organisation.setTown(faker.address().city());
	    
	    organisation.setTelephone1(faker.phoneNumber().phoneNumber());
	    
	    organisation.setTelephone2(faker.phoneNumber().cellPhone());

	    organisation.setFax(faker.numerify("FAX-####"));
	    
	    organisation.setMobilePhone(faker.phoneNumber().cellPhone());

	    organisation.setEmail(faker.internet().emailAddress());

	    organisation.setWebSite(faker.company().url());

	    organisation.setVatNumber(faker.numerify("VAT-########"));
	    
	    organisation.setRegistrationNumber(faker.numerify("REG-########"));
	    
	    // private String comments;
	    
	    // private Long publicationId;
	    
	    
	    organisation.setRegistrationNumber(faker.numerify("REG-########"));
	    
	    organisation.setType(EnumOrganisationType.randomType().toString());
		
		
		return 	organisation;
		
	}
	
	public static Organisation getOrganisationEntitity(){
		
		
		Organisation organisation = new Organisation();
		
		organisation.setName(faker.company().name());
	    
	    organisation.setReference(faker.company().suffix());
	    	    
	    /* Check if there is constraint with the Categories */
	    
	    /* 
	     * select * from DEFIS_EVAL.TBL_ORGANISATIONCATEGORY order by id
	     */
	    
	    // organisation.setOrganisationCategoryId(new Long(faker.number().numberBetween(1, 20)));
	    
	    organisation.setAddress1(faker.address().streetAddress());
	    
	    organisation.setAddress2(faker.address().streetAddress());
	    
	    organisation.setCountryId(new Long(faker.number().numberBetween(1, 100)));

	    organisation.setPostalCode(faker.address().zipCode());

	    organisation.setTown(faker.address().city());
	    
	    organisation.setTelephone1(faker.phoneNumber().phoneNumber());
	    
	    organisation.setTelephone2(faker.phoneNumber().cellPhone());

	    organisation.setFax(faker.numerify("FAX-####"));
	    
	    organisation.setMobilePhone(faker.phoneNumber().cellPhone());

	    organisation.setEmail(faker.internet().emailAddress());

	    organisation.setWebSite(faker.company().url());

	    organisation.setVatNumber(faker.numerify("VAT-########"));
	    
	    organisation.setRegistrationNumber(faker.numerify("REG-########"));
	    
	    // private String comments;
	    
	    // private Long publicationId;
	    
	    
	    organisation.setRegistrationNumber(faker.numerify("REG-########"));
	    
	    organisation.setType(EnumOrganisationType.randomType().toString());
		
		
		return 	organisation;
		
	}

	
	
	public static ActionDTO getActionDTO(){
		
		ActionDTO actionDTO = new ActionDTO();
		
		actionDTO.setStartDate(faker.date().birthday());
		actionDTO.setEndDate(faker.date().birthday());
		
		/* Read from an XML file for testing purpose*/
		
		StringBuffer actionSummaryBuffer = new StringBuffer();
		
		actionSummaryBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
		
		actionSummaryBuffer.append("<translation language=\"en\">");
		
		actionSummaryBuffer.append("<title>Changing traditional mindset through collective agreements in the Western Balkans – the role of social partners in enabling work-family reconciliation and gender equality</title>");
		
		actionSummaryBuffer.append("<summary>");
		
		actionSummaryBuffer.append("<p xmlns=\"http://www.w3.org/1999/xhtml\">Testing update action summary</p> \n<p xmlns=\"http://www.w3.org/1999/xhtml\">ttttt</p> \n<p xmlns=\"http://www.w3.org/1999/xhtml\">tttttt</p> \n<p xmlns=\"http://www.w3.org/1999/xhtml\"/> \n<p xmlns=\"http://www.w3.org/1999/xhtml\">Testing the update of publigrant</p>\n");
		
		actionSummaryBuffer.append("</summary>");
		
		actionSummaryBuffer.append("</translation>");
		
		actionDTO.setSummary(actionSummaryBuffer.toString());
		
		actionDTO.setTitle("Changing traditional mindset through collective agreements in the Western Balkans – the role of social partners in enabling work-family reconciliation and gender equality");

		actionDTO.setDescription("Testing the update of publigrant");
		
		return actionDTO;
		
	}
	
	
	
	public static ActionSummaryDTO getActionSummaryDTO(){
		
		ActionSummaryDTO actionSummaryDTO = new ActionSummaryDTO();
		
		actionSummaryDTO.setGrantAgreementReference("VS/2015/0329");
		
		actionSummaryDTO.setActionDTO(getActionDTO());
		
		
		return actionSummaryDTO;
		
		
		
	}
	
	
	
	
	/* Read xml file from a folder to create it */
	
	public static CallDTO getCallDTO(){
		
		CallDTO callDTO = new CallDTO();
		callDTO.setReference("VP/2019/"+rand.nextInt(1000));
		callDTO.setProgrammeId(new Long(faker.number().numberBetween(1, 4)));
		return callDTO;
		
	}
	
	public static List<Long> getUltimateTargetGroupList(){
		// https://medium.com/@CDehning/when-to-use-fakes-instead-of-mocks-c80188b9a3f1
		// select * from DEFIS_EVAL.TBL_ULTIMATETARGETGROUP order by id
		
		return getLongList(5,1,15);  
	}
	
	public static List<Long> getDirectTargetGroupList(){
		// https://medium.com/@CDehning/when-to-use-fakes-instead-of-mocks-c80188b9a3f1
		// select * from DEFIS_EVAL.TBL_DIRECTTARGETGROUP order by id
		
		return getLongList(3,1,18);  
	}

	
	public static List<Long> getPoliciyAreasList(){
		// https://medium.com/@CDehning/when-to-use-fakes-instead-of-mocks-c80188b9a3f1
		// select * from DEFIS_EVAL.TBL_POLICYAREA order by id
		
		return getLongList(2,1,10);  
	}

	
	public static List<Long> getLongList(int listSize, int lowerLimit, int upperLimit){
		
		List<Long> list = new ArrayList<Long>();
		
		for(int i=0; i<listSize; i++) {
			list.add(new Long(faker.number().numberBetween(lowerLimit, upperLimit)));
		}
		
		list = (List<Long>)(Object)list.stream().distinct().collect(Collectors.toList());
		return list;
		
	}
	
	
	/**
	 *  Domain objects Entity
	 * @param directTargetGroup
	 * @return
	 */
	
	public static DirectTargetGroup getDirectTargetGroupEntity(DirectTargetGroup directTargetGroup){
		
		Random rand = new Random();
		
		directTargetGroup.setDescriptionDe(faker.gameOfThrones().character());
		directTargetGroup.setDescriptionEn(faker.beer().name());
		directTargetGroup.setDescriptionFr(faker.artist().name());
		
		directTargetGroup.setOrderNumber(rand.nextInt(1000));
		
		return directTargetGroup;
		
	}
	
	
	
	
	

}
