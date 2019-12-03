package eu.cec.empl.dms.domain.business.client.catalogue;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(schema = "DMSPUB_APP", name = "V_GRANTAGREEMENTS")
public class GrantAgreement {
		
		
		@Column(name = "APPLICATION_ID")
		@Id
	    private Long id;

	    @Column(name = "COLIREFERENCE")
	    private String coliReference;
	    
	    @Column(name = "ACTIONSTARTINGDATE")
	    private Date actionStartingDate;
	    
	    @Column(name = "ACTIONCLOSINGDATE")
	    private Date actionClosingDate;
	    
	    
}


