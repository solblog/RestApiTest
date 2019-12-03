package eu.cec.empl.dms.test.tools;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

    
	
	public enum EnumOrganisationType {
        // COORDINATOR("COORDINATOR"), COAPPLICANT("COAPPLICANT"), AFFILIATED("AFFILIATED"), ASSOCIATE("ASSOCIATE"), THIRDPARTY("THIRDPARTY"), PARTNER("PARTNER");
		COAPPLICANT("COAPPLICANT"), PARTNER("PARTNER");
		
        private final String text;

        EnumOrganisationType(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }
        
        private static final List<EnumOrganisationType> VALUES =   	    Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();

        public static EnumOrganisationType randomType()  {
        	    return VALUES.get(RANDOM.nextInt(SIZE));
        }
        
        public static String getCoordinator()  {
    	    return "COORDINATOR";
        }

}


