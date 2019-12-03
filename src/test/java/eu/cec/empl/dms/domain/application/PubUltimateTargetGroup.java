package eu.cec.empl.dms.domain.application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
@Table(schema = "PUBLIGRANT", name = "TBL_PUBULTIMATETARGETGROUP")
public class PubUltimateTargetGroup {

    @Id    
    private Long id;

    @Column(name = "PUBLICATION_ID")
    private Long publicationId;
    
    @Column(name = "ULTIMATETARGETGROUP_ID")
    private Long ultimateTargetGroupId;
	
}
