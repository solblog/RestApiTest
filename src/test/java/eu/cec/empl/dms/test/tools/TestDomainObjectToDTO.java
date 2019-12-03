package eu.cec.empl.dms.test.tools;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Random;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.github.javafaker.Faker;


import eu.cec.empl.dms.domain.procedures.Publication;

import eu.cec.empl.dms.dto.GrantAgreementDTO;
import eu.cec.empl.dms.dto.OrganisationDTO;
import eu.cec.empl.dms.dto.PublicationDTO;
import eu.cec.empl.dms.mock.domain.catalogue.Organisation;
import mockit.integration.springframework.FakeBeanFactory;

public class TestDomainObjectToDTO {
	
	private ModelMapper modelMapper = new ModelMapper();
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	 
    @Test
    public void whenConvertPostEntityToPostDto_thenCorrect() {
       
    	/*
    	Post post = new Post();
        post.setId(Long.valueOf(1));
        post.setTitle(randomAlphabetic(6));
        post.setUrl("www.test.com");
 
        PostDto postDto = modelMapper.map(post, PostDto.class);
        assertEquals(post.getId(), postDto.getId());
        assertEquals(post.getTitle(), postDto.getTitle());
        assertEquals(post.getUrl(), postDto.getUrl());
        */
        
    }
 
    @Test
    public void whenConvertGrantAgreementDtoToPublicationEntity_thenCorrect() {
    	
    	GrantAgreementDTO grantAgreementDTO = FakeObjectsFactory.getGrantAgreementDTO(); 
    			

    	Publication publication = modelMapper.map(grantAgreementDTO, Publication.class);

    	assertEquals(grantAgreementDTO.getId(), publication.getId());
    	assertEquals(grantAgreementDTO.getReference(), publication.getReference());
    	assertEquals(grantAgreementDTO.getSelectionProcedureRef(), publication.getSelectionProcedureRef());
    	
    	assertEquals(grantAgreementDTO.getInitialEuContribution(), publication.getInitialEuContribution());
    	assertEquals(grantAgreementDTO.getFinalEuContribution(), publication.getFinalEuContribution());
    	assertEquals(grantAgreementDTO.getInitialTotalCost(), publication.getInitialTotalCost());
    	assertEquals(grantAgreementDTO.getFinalTotalCost(), publication.getFinalTotalCost());
    	
    	
    	assertEquals(grantAgreementDTO.getProgrammeId(), publication.getProgrammeId());
    	assertEquals(grantAgreementDTO.getPublicationTypeId() , publication.getPublicationTypeId());
    	
    	// assertEquals(grantAgreementDTO.getTranslations(), publication.getTranslations());
    	
    	assertEquals(grantAgreementDTO.getWebSite(), publication.getWebSite());
    	
        
    }    
    
    @Test
    public void whenConvertPublicationDtoToPublicationEntity_thenCorrect() {
    	
    	PublicationDTO publicationDTO = FakeObjectsFactory.getPublicationDTO();
    	
    	
    	Publication publication = modelMapper.map(publicationDTO, Publication.class);

    	assertEquals(publicationDTO.getId(), publication.getId());
    	assertEquals(publicationDTO.getReference(), publication.getReference());
    	assertEquals(publicationDTO.getSelectionProcedureRef(), publication.getSelectionProcedureRef());
    	
    	assertEquals(publicationDTO.getStartDate(), publication.getStartDate());
    	assertEquals(publicationDTO.getEndDate(), publication.getEndDate());
    	
    	assertEquals(publicationDTO.getInitialEuContribution(), publication.getInitialEuContribution());
    	assertEquals(publicationDTO.getFinalEuContribution(), publication.getFinalEuContribution());
    	assertEquals(publicationDTO.getInitialTotalCost(), publication.getInitialTotalCost());
    	assertEquals(publicationDTO.getFinalTotalCost(), publication.getFinalTotalCost());
    	
    	assertEquals(publicationDTO.getProgrammeId(), publication.getProgrammeId());
    	
    	// assertEquals(grantAgreementDTO.getTranslations(), publication.getTranslations());
    	
    	assertEquals(publicationDTO.getWebsite(), publication.getWebSite());
    	
        
    }
    
    @Test
    public void whenMapEntitiesToDto_thenCorrect() {
    	
    	PublicationDTO publicationDTO = new PublicationDTO();
    	
    	
    			

    	Publication publication = modelMapper.map(publicationDTO, Publication.class);

    	assertEquals(publicationDTO.getId(), publication.getId());
    	assertEquals(publicationDTO.getReference(), publication.getReference());
    	assertEquals(publicationDTO.getSelectionProcedureRef(), publication.getSelectionProcedureRef());
    	
    	assertEquals(publicationDTO.getStartDate(), publication.getStartDate());
    	assertEquals(publicationDTO.getEndDate(), publication.getEndDate());
    	
    	assertEquals(publicationDTO.getInitialEuContribution(), publication.getInitialEuContribution());
    	assertEquals(publicationDTO.getFinalEuContribution(), publication.getFinalEuContribution());
    	assertEquals(publicationDTO.getInitialTotalCost(), publication.getInitialTotalCost());
    	assertEquals(publicationDTO.getFinalTotalCost(), publication.getFinalTotalCost());
    	
    	assertEquals(publicationDTO.getProgrammeId(), publication.getProgrammeId());
    	
    	// assertEquals(grantAgreementDTO.getTranslations(), publication.getTranslations());
    	
    	assertEquals(publicationDTO.getWebsite(), publication.getWebSite());
    	
        
    }
    
    @Test
    public void whenMapOrganisartionEntitiesToDto_thenCorrect() {
    	
    	PublicationDTO publicationDTO = new PublicationDTO();

    	Publication publication = modelMapper.map(publicationDTO, Publication.class);
    	
    	PropertyMap<Organisation, OrganisationDTO> skipModifiedFieldsMap = new PropertyMap<Organisation, OrganisationDTO>() {
  	      protected void configure() {
  	         skip().setId(null);
  	      }
    	};
  	
  		modelMapper.addMappings(skipModifiedFieldsMap);

    	assertEquals(publicationDTO.getReference(), publication.getReference());
    	
    	// assertEquals(grantAgreementDTO.getTranslations(), publication.getTranslations());
    	
        
    }

    
    



    

}
