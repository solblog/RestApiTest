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
@Table(schema = "DEFIS_EVAL", name = "TBL_APPLICATION")
public class Application {
	
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_APPLICATION")
    @SequenceGenerator(name = "SEQ_APPLICATION", sequenceName = "SEQ_APPLICATION", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE")
    private String title;
    
    @Column(name = "REFERENCE")
    private String reference;
    
    @Column(name = "PHASE_ID")
    private Long phaseId;
    
}
