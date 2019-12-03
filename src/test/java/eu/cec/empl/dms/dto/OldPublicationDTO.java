package eu.cec.empl.dms.dto;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import eu.cec.empl.defis.dynForms.DynForm;
import eu.cec.empl.defis.dynForms.util.DynFormsNamespaceContext;
import eu.cec.empl.defis.dynForms.util.XMLUtils;
import eu.cec.empl.defis.publigrant.domain.Auditable;
import eu.cec.empl.defis.publigrant.domain.classification.Programme;
import eu.cec.empl.defis.publigrant.domain.utils.DummyDataListener;
import eu.cec.empl.defis.publigrant.util.validation.Validator;

@Entity
public class OldPublicationDTO {
    @Id
    @GeneratedValue(generator = "SEQ_PUBLICATION", strategy = SEQUENCE)
    @SequenceGenerator(name = "SEQ_PUBLICATION", sequenceName = "SEQ_PUBLICATION", allocationSize = 1)
    private Long id;

    private String reference;
    private String selectionProcedureRef;
    private String website;

    private BigDecimal initialEuContribution;
    private BigDecimal finalEuContribution;
    private BigDecimal initialTotalCost;
    private BigDecimal finalTotalCost;

    private Boolean visibleOnEuropa = false;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "PUBLICATIONTYPE_ID")
    private PublicationType publicationType;

    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
    @OrderBy("id")
    private List<OrganisationDTO> organisations = new ArrayList<OrganisationDTO>();

    @OneToMany(mappedBy = "publication", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PublicationDirectTargetGroup> publicationDirectTargetGroups;

    @OneToMany(mappedBy = "publication", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PublicationUltimateTargetGroup> publicationUltimateTargetGroups;

    @OneToMany(mappedBy = "publication", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PublicationPolicyArea> publicationPolicyAreas;

    @ManyToOne
    @JoinColumn(name = "PROGRAMME_ID")
    private Programme programme;

    /**
     * This property will be only available after fetching it manually (JPA is
     * not XMLTYPE friend) It contains the plain xml string with the different
     * translations of the publication
     */
    @Transient
    private String translationsXml;

    /**
     * This property will be only available after fetching it manually (JPA is
     * not XMLTYPE friend) It contains a hashmap of translations, where: Key ->
     * language Value -> Translation object (inner class defined here)
     */
    @Transient
    private HashMap<String, Translation> translations = null;

    @Transient
    private List<String> languages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        Validator.assertLengthInRange(reference, 0, 50);
        this.reference = reference;
    }

    public String getSelectionProcedureRef() {
        return selectionProcedureRef;
    }

    public void setSelectionProcedureRef(String selectionProcedureRef) {
        Validator.assertLengthInRange(selectionProcedureRef, 0, 50);
        this.selectionProcedureRef = selectionProcedureRef;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        Validator.assertLengthInRange(website, 0, 255);
        this.website = website;
    }

    public BigDecimal getInitialEuContribution() {
        return initialEuContribution;
    }

    public void setInitialEuContribution(BigDecimal initialEuContribution) {
        this.initialEuContribution = initialEuContribution;
    }

    public BigDecimal getFinalEuContribution() {
        return finalEuContribution;
    }

    public void setFinalEuContribution(BigDecimal finalEuContribution) {
        this.finalEuContribution = finalEuContribution;
    }

    public BigDecimal getInitialTotalCost() {
        return initialTotalCost;
    }

    public void setInitialTotalCost(BigDecimal initialTotalCost) {
        this.initialTotalCost = initialTotalCost;
    }

    public BigDecimal getFinalTotalCost() {
        return finalTotalCost;
    }

    public void setFinalTotalCost(BigDecimal finalTotalCost) {
        this.finalTotalCost = finalTotalCost;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getVisibleOnEuropa() {
        return visibleOnEuropa;
    }

    public void setVisibleOnEuropa(Boolean visibleOnEuropa) {
        this.visibleOnEuropa = visibleOnEuropa;
    }

    public PublicationType getPublicationType() {
        return publicationType;
    }

    public void setPublicationType(PublicationType publicationType) {
        this.publicationType = publicationType;
    }

    public List<PublicationDirectTargetGroup> getPublicationDirectTargetGroups() {
        return publicationDirectTargetGroups;
    }

    public void setPublicationDirectTargetGroups(List<PublicationDirectTargetGroup> publicationDirectTargetGroups) {
        this.publicationDirectTargetGroups = publicationDirectTargetGroups;
    }

    public List<PublicationUltimateTargetGroup> getPublicationUltimateTargetGroups() {
        return publicationUltimateTargetGroups;
    }

    public void setPublicationUltimateTargetGroups(List<PublicationUltimateTargetGroup> publicationUltimateTargetGroups) {
        this.publicationUltimateTargetGroups = publicationUltimateTargetGroups;
    }

    public List<PublicationPolicyArea> getPublicationPolicyAreas() {
        return publicationPolicyAreas;
    }

    public void setPublicationPolicyAreas(List<PublicationPolicyArea> publicationPolicyAreas) {
        this.publicationPolicyAreas = publicationPolicyAreas;
    }

    public String getTranslationsXml() {
        return translationsXml;
    }

    public void setTranslationsXml(String translationsXml) {
        this.translations = null;
        this.translationsXml = translationsXml;
    }

    public Map<String, Translation> getTranslations() {

        if (this.translations == null) {
            this.setTranslations(new HashMap<String, Translation>());
            this.setLanguages(new ArrayList<String>());

            if (this.getTranslationsXml() == null) {
                return this.translations;
            }

            try {
                // Parse the xml string in order to get languages and
                // translations
                XPath xPath = XPathFactory.newInstance().newXPath();
                xPath.setNamespaceContext(new DynFormsNamespaceContext("data", "http://mydata"));

                // For each element, get: language, title, translation
                NodeList nl =
                              (NodeList) xPath.evaluate("/data:translations/data:translation/@language", XMLUtils.stringToDocument(this.getTranslationsXml()),
                              XPathConstants.NODESET);
                int length = nl.getLength();
                for (int i = 0; i < length; i++) {
                    Attr attr = (Attr) nl.item(i);
                    String currentLanguage = attr.getValue();

                    XPathExpression xPathExpression = xPath.compile("/data:translations/data:translation[@language='" + currentLanguage + "']/data:title");
                    String currentTitle = (String) xPathExpression.evaluate(XMLUtils.stringToDocument(this.getTranslationsXml()), XPathConstants.STRING);

                    // Treat summary as a node (to include html tags)
                    xPathExpression = xPath.compile("/data:translations/data:translation[@language='" + currentLanguage + "']/data:summary");
                    Node node = (Node) xPathExpression.evaluate(XMLUtils.stringToDocument(this.getTranslationsXml()), XPathConstants.NODE);

                    translations.put(currentLanguage, new Translation(currentLanguage, currentTitle, XMLUtils.documentToString(node, "UTF-8")));
                    getLanguages().add(currentLanguage);
                }
            } catch (XPathExpressionException e) {
                throw new RuntimeException(e);
            }
        }

        return translations;
    }

    public void setTranslations(HashMap<String, Translation> translations) {
        this.translations = translations;
    }

    /**
     * Method to control if the publication has all pre-requisites to be
     * published in Europa.eu portal
     * 
     * @return
     */
    public Boolean getPublishable() {

        if (this.getReference() == null)
            return false;

        if (this.getSelectionProcedureRef() == null)
            return false;

        // if (this.getWebsite() == null)
        // return false;

        if (this.getStartDate() == null)
            return false;

        if (this.getEndDate() == null)
            return false;

        if (this.getPublicationType() == null)
            return false;

        if (this.getProgramme() == null)
            return false;

        if (this.getOrganisations() == null)
            return false;

        if (this.getPublicationDirectTargetGroups().isEmpty())
            return false;

        if (this.getPublicationPolicyAreas().isEmpty())
            return false;

        if (this.getPublicationUltimateTargetGroups().isEmpty())
            return false;

        if (this.getInitialEuContribution() == null || BigDecimal.ZERO.compareTo(this.getInitialEuContribution()) >= 0)
            return false;

        if (this.getInitialTotalCost() == null || BigDecimal.ZERO.compareTo(this.getInitialTotalCost()) >= 0)
            return false;

        if (this.getFinalEuContribution() == null || BigDecimal.ZERO.compareTo(this.getFinalEuContribution()) >= 0)
            return false;

        if (this.getFinalTotalCost() == null || BigDecimal.ZERO.compareTo(this.getFinalTotalCost()) >= 0)
            return false;

        if (this.translationsXml == null) {
            return false;
        } else {
            // Check for translations errors
            try {
                InputStream is = getClass().getClassLoader().getResourceAsStream("publication.xml");
                Document publicationForm = XMLUtils.stringToDocument(IOUtils.toString(is, "UTF-8"));
                Document existingData = XMLUtils.stringToDocument(this.getTranslationsXml());

                // Now we have to put transformated data + publication form and
                // return it
                DynForm dynForm = new DynForm(publicationForm);
                dynForm.addValues(existingData);
                dynForm.evaluate();

                if (dynForm.hasErrors() == true) {
                    return false;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (XPathExpressionException e) {
                throw new RuntimeException(e);
            }
        }

        return true;
    }

    @Embedded
    protected AuditInfo auditInfo = new AuditInfo();

    @Override
    public AuditInfo getAuditInfo() {
        return this.auditInfo;
    }

    @Override
    public void setAuditInfo(AuditInfo auditInfo) {
        this.auditInfo = auditInfo;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<OrganisationDTO> getOrganisations() {
        Collections.sort(organisations, new Comparator<OrganisationDTO>() {
            @Override
            public int compare(OrganisationDTO org1, OrganisationDTO org2) {
                if (org1.getType().equals("COORDINATOR"))
                    return -1;
                else if (org2.getType().equals("COORDINATOR"))
                    return 1;
                else
                    return org1.getName().compareTo(org2.getName());
            }

        });
        return organisations;
    }

    public void setOrganisations(List<OrganisationDTO> organisations) {
        this.organisations = organisations;
    }

    public OrganisationDTO getCoordinator() {
        return (!organisations.isEmpty()) && getOrganisations().get(0).getType().equals("COORDINATOR") ? getOrganisations().get(0) : null;
    }

    public List<OrganisationDTO> getCoapplicantsOrPartners() {
        List<OrganisationDTO> coapplicantsOrPartners = new ArrayList();
        if (!organisations.isEmpty()) {
            coapplicantsOrPartners = getOrganisations();
            coapplicantsOrPartners.remove(getCoordinator());
        }
        return coapplicantsOrPartners;

    }

}