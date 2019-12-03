package eu.cec.empl.dms.domain.security;

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
@Table(schema = "PUBLIGRANT", name = "TBL_PUBLIGRANTTOKEN")
public class Token{

   	@Id
    @GeneratedValue(strategy = SEQUENCE, generator = "PUBLIGRANT.SEQ_PUBLIGRANTTOKEN")
    @SequenceGenerator(name = "PUBLIGRANT.SEQ_PUBLIGRANTTOKEN", sequenceName = "PUBLIGRANT.SEQ_PUBLIGRANTTOKEN", allocationSize = 1)
    private Long id;
   	
   	@Column(name = "TOKEN")
    private String token;

    @Column(name = "URL")
    private String url;
    
    @Column(name = "IP")
    private String ip;
    
    @Column(name = "USER_ID")
    private String user;
    
    @Column(name = "ACTIVE")
    private boolean active;
	    
}