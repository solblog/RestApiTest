package eu.cec.empl.dms.mock.services;

import java.util.ArrayList;
import java.util.List;


import eu.cec.empl.dms.mock.dao.LanguageDaoImpl;
import eu.cec.empl.dms.mock.domain.catalogue.Language;

public class LanguageService{
	
    private LanguageDaoImpl languageDao;
    // private Language currentLanguage; 
	
    public List<Language> findAll() {
        List<Language> language = new ArrayList<Language>();
        language = languageDao.list();
        return language;
    }
    
    public Language findById(Long id) {
    	Language language = new Language();
    	language = languageDao.findById(id);
    	language.setDescriptionEn("Description Assigned in Service");
    	return language;
    }
	
	public void setDescriptonFr(String descriptionFr) {
		/* do not do anything */
	}
	
	
	public boolean update(Language language) {
		
		assert null != language;
        
		int updateResults = languageDao.update(language);
		language.setDescriptionFr("Description Assigned in Service");
        
        switch (updateResults){
            case 1:
                return true;
            default:
                return false;
        }
    	
        
    }

}
