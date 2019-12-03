package eu.cec.empl.dms.domain.security;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/*
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import eu.cec.empl.defis.eval.service.user.DefisUserUtils;
*/

/*
 *  This class depend on Spring security and Storing the users in the 
 * Database (Phase 2). 
*/


/**
 * COMREF User against view, not table
 * 
 * @author 
 */
// @Entity
// @Table(name = "V_USERS")

public class UserDefis implements Serializable {
	
	/*

    private static final String EMPL_ORGANISATION_PREFIX = "EMPL";
    private static final String EXTRAMUROS = "EXTRAMUROS";

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String username;
    private String surname;
    private String firstName;
    private String email;
    private String telephone;
    private String organisationEntityCode;
    private boolean authorisedAsAos;

    @OneToMany(cascade = ALL, mappedBy = "user", fetch = FetchType.EAGER)
    @MapKey(name = "roleId")
    Map<Long, InformationSystemAssignation> informationSystemUserAssignations;

    @Transient
    Map<Long, Boolean> basicRolesWrapper = null;

    public String getUsername() {
    	
    	int a = 4;
    	
    	Integer number = a;
    	
    	
    	
        return username != null ? username : "Not available";
    }

    public String getSurname() {
        return surname != null ? surname : "Not available";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getOrganisationEntityCode() {
        return organisationEntityCode;
    }

    public boolean isAuthorisedAsAos() {
        return authorisedAsAos;
    }
    
    */

    /**
     * Returns the role list as a hashmap.
     * 
     * @return the role hasmap.
     */
    
	/*
	public Map<Long, Boolean> getRoleWrapper() {
        if (basicRolesWrapper == null) {
            basicRolesWrapper = new java.util.HashMap<Long, Boolean>();
        }
        try {
            for (InformationSystemAssignation urb : this.getBasicRolesAssignation()) {
                if (urb != null && urb.getRole() != null)
                    basicRolesWrapper.put(urb.getRole().getId(), true);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return basicRolesWrapper;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Long, InformationSystemAssignation> getInformationSystemUserAssignations() {
        return informationSystemUserAssignations;
    }

    public void setInformationSystemUserAssignations(Map<Long, InformationSystemAssignation> informationSystemUserAssignations) {
        this.informationSystemUserAssignations = informationSystemUserAssignations;
    }
    
    */

    /**
     * @return list with the basic roles assignations.
     */
	/*
    public List<InformationSystemAssignation> getBasicRolesAssignation() {
        return Collections.unmodifiableList(new ArrayList<InformationSystemAssignation>(informationSystemUserAssignations.values()));
    }
    */

    /**
     * @return the FullName of this user.
     */
	/*
    public String getFullName() {
        return getSurname() + ", " + getFirstName();
    }
    */

    /**
     * @return A comma separated String with the basic roles descriptions.
     */
	/*
    public String getBasicRolesAsString() {
        StringBuffer sb = new StringBuffer();
        for (InformationSystemAssignation assignation : getBasicRolesAssignation()) {
            if (assignation.getRole() != null) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(assignation.getRole().getDescription());
            }
        }
        return sb.toString();
    }
    */

    /**
     * Get the basic authorities of the user
     * A basic authority is global to the application.
     * 
     * @return An array with the basic authorities.
     */
	
	/*
    public Collection<GrantedAuthority> getBasicAuthorities() {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();

        for (InformationSystemAssignation isa : getBasicRolesAssignation()) {
            Role role = isa.getRole();
            if (role != null) {
                grantedAuthorities.add(new GrantedAuthorityImpl("ROLE_" + isa.getRole().getCode()));
                grantedAuthorities.add(new GrantedAuthorityImpl(isa.getRole().getCode()));
            }
        }

        if (this.isInDGEmployment() || this.isUserInRole(Role.RoleEnum.EXTERNAL_USER)) {
            grantedAuthorities.add(new GrantedAuthorityImpl("ROLE_USER"));
            grantedAuthorities.add(new GrantedAuthorityImpl("USER"));
        }

        return grantedAuthorities;
    }

    public boolean isInDGEmployment() {
        return isSystem() || (organisationEntityCode != null && organisationEntityCode.startsWith(EMPL_ORGANISATION_PREFIX));
    }

    public boolean isSystem() {
        return DefisUserUtils.SYSTEM_USERNAME.equals(username);
    }

    public boolean isUserInRole(Role.RoleEnum role) {

        for (InformationSystemAssignation assignation : getBasicRolesAssignation()) {
            if (assignation.getRole() != null) {
                if (assignation.getRole().getCode().equals(role.name()))
                    return true;
            }
        }

        return false;
    }

    public boolean isUserInAtLeastOneRole() {
        if (!isInDGEmployment()) {
            return informationSystemUserAssignations.size() > 0;
        }
        return true;
    }

    public boolean isExtramuros() {
        return EXTRAMUROS.equals(organisationEntityCode);
    }
    */

}