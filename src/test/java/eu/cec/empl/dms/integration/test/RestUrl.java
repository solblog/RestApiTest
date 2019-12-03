package eu.cec.empl.dms.integration.test;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;

public abstract class RestUrl {
	
	private String protocol;
	private String host; 
	private String port; 
	private String domain = "/dms/publigrant"; 
	private String hostDevelopment; 
	private String service;
	private String version;
	
	private String method;
	
	private String keyParam;
	
	private String params;
	
	
	public RestUrl(String pprotocol,String phost,String pport) {
		super();
		this.port =  pport!=null?":"+pport:"";
		hostDevelopment = pprotocol+phost+this.port+this.domain;
	}

	
	public String getService() {
		return service;
	}

	public void setService(String pService) {
			this.service = pService;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String pVersion) {
			this.version = pVersion;
	}

	public String getParam() {
		return keyParam;
	}

	public void setParam(String param) {
		this.keyParam = param;
	}

	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}


	public String getHostDevelopment() {
		return hostDevelopment;
	}
	
	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}


	public String get() {
		
		StringBuilder url = new StringBuilder(hostDevelopment+service+version);
		url.append(method!=null?method:"");
		url.append(keyParam!=null?keyParam:"");
		url.append(params!=null?params:"");
		return url.toString();
		
	}


}
