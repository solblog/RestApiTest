package eu.cec.empl.dms.domain.business.client.catalogue;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(schema = "DEFIS_EVAL", name = "TBL_DIRECTTARGETGROUP")
public class DirectTargetGroup{
    /**
	 * 
	 */
	@JsonIgnore
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = SEQUENCE, generator = "DEFIS_EVAL.SEQ_DIRECTTARGETGROUP")
    @SequenceGenerator(name = "DEFIS_EVAL.SEQ_DIRECTTARGETGROUP", sequenceName = "DEFIS_EVAL.SEQ_DIRECTTARGETGROUP", allocationSize = 1)
    private Long id;

    @Column(name = "DESCRIPTION_EN")
    private String descriptionEn;
    @Column(name = "DESCRIPTION_FR")
    private String descriptionFr;
    @Column(name = "DESCRIPTION_DE")
    private String descriptionDe;
    @Column(name = "ORDERNUMBER")
    private Integer orderNumber;

    public Long getId() {
        return id;
    }  

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }


    public String getDescriptionFr() {
        return descriptionFr;
    }
    

    public String getDescriptionDe() {
        return descriptionDe;
    }

    
    @JsonIgnore
    public HashMap<String, String> getDescriptions() {
        HashMap<String, String> descriptions = new HashMap<String, String>();

        descriptions.put("en", getDescriptionEn());
        descriptions.put("de", getDescriptionDe());
        descriptions.put("fr", getDescriptionFr());

        return descriptions;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

	public void setDescriptionFr(String descriptionFr) {
		this.descriptionFr = descriptionFr;
	}

	public void setDescriptionDe(String descriptionDe) {
		this.descriptionDe = descriptionDe;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
    
    

    

    
}