package eu.cec.empl.dms.domain.procedures;

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
@Table(schema = "DEFIS_EVAL", name = "TBL_PHASE")
public class Phase {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PHASE")
    @SequenceGenerator(name = "SEQ_PHASE", sequenceName = "SEQ_PHASE", allocationSize = 1)
    private Long id;

    @Column(name = "CALL_ID")
    private Long callId;
    
    @Column(name = "PHASENUMBER")
    private Integer phaseNumber;
	
}
