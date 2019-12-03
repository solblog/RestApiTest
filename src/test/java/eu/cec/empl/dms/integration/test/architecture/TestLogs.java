package eu.cec.empl.dms.integration.test.architecture;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TestLogs extends TestCase{
	
	/*
	 * The purpose of this test is to verify that all the exceptions
	 * triggers by the system are collected in the class CustomRestExceptionHandler
	 * and logged properly.
	 */
	private final String restServiceName = "ExceptioMockup";
	private final String version = "v1";
	private final String method = "";
	
	
	
	
}
