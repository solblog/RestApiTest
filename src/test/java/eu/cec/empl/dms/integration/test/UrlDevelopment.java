package eu.cec.empl.dms.integration.test;



public class UrlDevelopment extends RestUrl{

	private final static String protocol =  "http://";
	private final static String host = "localhost";
	private final static String port = "6001";
	
	
	public UrlDevelopment() {
		super(protocol, host, port);
	}
	
}
