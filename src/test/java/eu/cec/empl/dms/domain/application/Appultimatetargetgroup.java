package eu.cec.empl.dms.domain.application;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
@Table(schema = "DEFIS_EVAL", name = "TBL_APPULTIMATETARGETGROUP")
public class Appultimatetargetgroup {
	
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_APPULTIMATETARGETGROUP")
    @SequenceGenerator(name = "SEQ_APPULTIMATETARGETGROUP", sequenceName = "SEQ_APPULTIMATETARGETGROUP", allocationSize = 1)
    private Long id;

    @Column(name = "APPLICATION_ID")
    private Long application_id;
    
    @Column(name = "ULTIMATETARGETGROUP_ID")
    private Long ultimatetargetgroup_id;

}
