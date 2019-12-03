package eu.cec.empl.dms.integration.test;



public class UrlTest extends RestUrl{

	private final static String protocol =  "https://";
	private final static String host = "www.test.cc.cec";
	private final static String port = null;

	// https://www.test.cc.cec/dms/publigrant/DirectTargetGroups/v1
	
	public UrlTest() {
		super(protocol, host, port);
	}
	
}
