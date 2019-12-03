package eu.cec.empl.dms.domain.procedures;

import static javax.persistence.GenerationType.SEQUENCE;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(schema = "DEFIS_EVAL", name = "TBL_CALL")
public class Call {
	
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CALL")
    @SequenceGenerator(name = "SEQ_CALL", sequenceName = "SEQ_CALL", allocationSize = 1)
    private Long id;
    
    @Column(name = "REFERENCE")
    private String reference;
    
    @Column(name = "TITLE")
    private String title;

    @Column(name = "PROGRAMME_ID")
    private Long programmeId;
    
    
    
}
