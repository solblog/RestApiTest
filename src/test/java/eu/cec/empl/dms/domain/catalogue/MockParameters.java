package eu.cec.empl.dms.domain.catalogue;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class MockParameters {
	
	@Id
    private Long id;

    // @NotEmpty(message = "Please provide a name")
    private String name;

    // @NotEmpty(message = "Please provide a author")
    private String author;

    /*
    @NotNull(message = "Please provide a price")
    @DecimalMin("1.00")
    private BigDecimal price;
    */
	

}
