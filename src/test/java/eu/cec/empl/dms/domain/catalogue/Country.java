package eu.cec.empl.dms.domain.catalogue;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter 
@Setter
@Table(schema = "DEFIS_EVAL", name = "TBL_COUNTRY")
public class Country{
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_COUNTRY")
    @SequenceGenerator(name = "SEQ_COUNTRY", sequenceName = "SEQ_COUNTRY", allocationSize = 1)
    private Long id;

    @Column(name = "DESCRIPTION_EN")
    private String descriptionEn;
    @Column(name = "DESCRIPTION_FR")
    private String descriptionFr;
    @Column(name = "DESCRIPTION_DE")
    private String descriptionDe;
    @Column(name = "ORDERNUMBER")
    private Integer orderNumber;
    
    @Column(name = "CODE")
    private String code;

    @Column(name = "ACTIVE")
    private Integer active;

    @JsonIgnore
    public HashMap<String, String> getDescriptions() {
        HashMap<String, String> descriptions = new HashMap<String, String>();

        descriptions.put("en", getDescriptionEn());
        descriptions.put("de", getDescriptionDe());
        descriptions.put("fr", getDescriptionFr());

        return descriptions;
    }
    
}