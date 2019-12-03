package eu.cec.empl.dms.mock.domain.catalogue;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Language extends Catalogue {

    private Integer active;
    private Integer official;
    

}
