package eu.cec.empl.dms.domain.business.client.catalogue;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class UltimateTargetGroup{
    
    private Long id;
    private String descriptionEn;
    private String descriptionFr;
    private String descriptionDe;
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

    

    
}