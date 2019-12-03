package eu.cec.empl.dms.mock.dao;

import java.util.ArrayList;
import java.util.List;
import eu.cec.empl.dms.mock.domain.catalogue.Language;

public class PublicationDaoImpl {
	
    public Language findById(Long id) {
		return new Language();
	}
	
    public List<Language> list() {
		List<Language> list = new ArrayList();
		return list;
	}

}
