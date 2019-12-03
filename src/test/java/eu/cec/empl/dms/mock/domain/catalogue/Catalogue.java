package eu.cec.empl.dms.mock.domain.catalogue;

import lombok.Data;

@Data
public abstract class Catalogue {
	
    private Long id;
    
    private String descriptionEn;
    private String descriptionFr;
    private String descriptionDe;
    private Integer orderNumber;

}
