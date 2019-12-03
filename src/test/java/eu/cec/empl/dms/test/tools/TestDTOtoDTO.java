package eu.cec.empl.dms.test.tools;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;

import org.junit.Test;
import org.modelmapper.ModelMapper;

import eu.cec.empl.dms.domain.procedures.Publication;
import eu.cec.empl.dms.dto.GeneralInfoDTO;
import eu.cec.empl.dms.dto.PublicationDTO;

public class TestDTOtoDTO {
	
	private ModelMapper modelMapper = new ModelMapper();
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
    
	@Test
    public void whenConvertPublicationDtoToPublicationEntity_thenCorrect() {
    	
    	PublicationDTO publicationDTO = FakeObjectsFactory.getPublicationDTO();
    	
    	GeneralInfoDTO generalInfoDTO = modelMapper.map(publicationDTO, GeneralInfoDTO.class);
    	
    	assertEquals(publicationDTO.getGrantAgreementDTO().getReference(), generalInfoDTO.getGrantAgreementDTO().getReference());
    	
    	assertEquals(publicationDTO.getGrantAgreementDTO().getInitialEuContribution(), generalInfoDTO.getGrantAgreementDTO().getInitialEuContribution());
    	assertEquals(publicationDTO.getGrantAgreementDTO().getFinalEuContribution(), generalInfoDTO.getGrantAgreementDTO().getFinalEuContribution());
    	
    	assertEquals(publicationDTO.getGrantAgreementDTO().getInitialTotalCost(), generalInfoDTO.getGrantAgreementDTO().getInitialTotalCost());
    	assertEquals(publicationDTO.getGrantAgreementDTO().getFinalTotalCost(), generalInfoDTO.getGrantAgreementDTO().getFinalTotalCost());
    	
        
    }


}
