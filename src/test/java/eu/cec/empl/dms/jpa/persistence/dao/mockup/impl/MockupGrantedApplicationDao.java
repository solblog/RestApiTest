package eu.cec.empl.dms.jpa.persistence.dao.mockup.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import eu.cec.empl.dms.domain.publications.GrantedApplication;

@Component
public class MockupGrantedApplicationDao {
	
public List<GrantedApplication> getGrantedApplications() {
		
		List<GrantedApplication> grantedApplicationList = null;
		
		try {
			
			File file = new File("GrantedApplications.dat");
			
			/* File located C:\pgm\neon */
			
			boolean fileExist = !file.exists();
			  
			if (fileExist) {
				
				GrantedApplication grantedApplication1 = new GrantedApplication();
				grantedApplication1.setId(1);
				
				grantedApplication1.setStartDate("31/12/2013");
				grantedApplication1.setEndDate("30/12/2014");
				
				grantedApplication1.setCountryName("EIRE IRELANDE");
				grantedApplication1.setNumberOrganisations(10);
				
				grantedApplication1.setActionTitle("WORKAGE: ACTIVE AGEING THROUGH WORK ABILITY");
				grantedApplication1.setCallProposal("VP/2012/007");
				grantedApplication1.setProgramme("PROGRESS");
				
				grantedApplication1.setTotalInitialCost(new Double(1000.10));
				grantedApplication1.setTotalFinalCost(new Double(1000.10));
				
				grantedApplication1.setTotalEUInitialCost(new Double(1000.10));
				grantedApplication1.setTotalEUFinalCost(new Double(1000.10));
				
				List<String> listCountries = new ArrayList<String>();
				listCountries.add("Spain");
				listCountries.add("Italy");
				listCountries.add("France");
				grantedApplication1.setListCountries(listCountries);
				
				List<String> listDirectTargetGroups = new ArrayList<String>();
				listDirectTargetGroups.add("Employees");
				listDirectTargetGroups.add("Low skilled");
				listDirectTargetGroups.add("Women");
				listDirectTargetGroups.add("Children");
				listDirectTargetGroups.add("Youth");
				grantedApplication1.setListDirectTargetGroups(listDirectTargetGroups);
				
				List<String> listUltimateTargetGroups = new ArrayList<String>();
				listUltimateTargetGroups.add("Social services");
				listUltimateTargetGroups.add("Business enterprises");
				listUltimateTargetGroups.add("Social and economic partners");
				listUltimateTargetGroups.add("Associations, non-governmental organisations and similar");
				grantedApplication1.setListUltimateTargetGroups(listUltimateTargetGroups);
				
				List<String> listPolicyAreas = new ArrayList<String>();
				listPolicyAreas.add("Commerce");
				listPolicyAreas.add("Construction");
				listPolicyAreas.add("Contract catering");
				listPolicyAreas.add("Education");
				listPolicyAreas.add("Footwear");
				grantedApplication1.setPoliciyAreas(listPolicyAreas);
								
				/*
				GrantedApplication grantedApplication2 = new GrantedApplication();
				grantedApplication2.setId(2);
				grantedApplication2.setActionTitle("PARTNERSHIP FOR DEVELOPMENT CHANGED");
				grantedApplication2.setCallProposal("VP/2012/008");
				grantedApplication2.setProgramme("EaSI");
				grantedApplication2.setReference("VS/2013/0252 ");
				
				grantedApplicationList = new ArrayList<GrantedApplication>();
				grantedApplicationList.add(grantedApplication1);
				grantedApplicationList.add(grantedApplication2);
				*/
				
				grantedApplication1.setSummary("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><translations xmlns=\"http://mydata\"><translation language=\"en\"><title>Establishing a partnership to set up a Youth Guarantee scheme in Ballymun, Dublin, Ireland</title><summary><p xmlns:data=\"http://mydata\" xmlns:fo=\"http://www.w3.org/1999/XSL/Format\" xmlns=\"http://www.w3.org/1999/xhtml\"/><p xmlns:data=\"http://mydata\" xmlns:fo=\"http://www.w3.org/1999/XSL/Format\" xmlns=\"http://www.w3.org/1999/xhtml\">  <strong>Short description of the action</strong></p></summary></translation></translations>"); 
				
				grantedApplicationList = new ArrayList<GrantedApplication>();
				grantedApplicationList.add(grantedApplication1);
				
				saveGrantedApplicationList(grantedApplicationList);
				
			} else {
				System.out.println("File exist");
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				grantedApplicationList = (List<GrantedApplication>) ois.readObject();
				ois.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return grantedApplicationList;
	}
	
	public GrantedApplication getGrantedApplication(int id){
		List<GrantedApplication> grantedApplications = getGrantedApplications();
		
		for(GrantedApplication grantedApplication : grantedApplications){
		
			if(grantedApplication.getId() == id){
				return grantedApplication;
			}
		}
		return null;
	}
	
	public int addGrantedApplication(GrantedApplication pGrantedApplication){
		
		List<GrantedApplication> grantedApplicationList = getGrantedApplications();

		boolean grantedApplicationExists = false;

		for (GrantedApplication grantedApplication : grantedApplicationList) {
			
			if (grantedApplication.getId() == pGrantedApplication.getId()) {
				grantedApplicationExists = true;
				break;
			}
		}
	
		if (!grantedApplicationExists) {
			grantedApplicationList.add(pGrantedApplication);
			saveGrantedApplicationList(grantedApplicationList);
			return 1;
		}
		
		return 0;
	
	}
	
	public int updateGrantedApplication(GrantedApplication pGrantedApplication) {
		
		List<GrantedApplication> grantedApplicationList = getGrantedApplications();
		
		for (GrantedApplication grantedApplication : grantedApplicationList) {
			
			int index = grantedApplicationList.indexOf(grantedApplication);
			
			if (grantedApplication.getId() == pGrantedApplication.getId()) {
				
				grantedApplicationList.set(index, pGrantedApplication);
				saveGrantedApplicationList(grantedApplicationList);
				return 1;
			}
		}
		
		return 0;
	
	}
	
	public int deleteGrantedApplication(int id) {
		
		List<GrantedApplication> grantedApplicationList = getGrantedApplications();
		
		for (GrantedApplication grantedApplication : grantedApplicationList) {
			
			if (grantedApplication.getId() == id) {
				int index = grantedApplicationList.indexOf(grantedApplication);
				
				grantedApplicationList.remove(index);
				
				saveGrantedApplicationList(grantedApplicationList);
				
				return 1;
			}
		}
		return 0;
	}

	

	private void saveGrantedApplicationList(List<GrantedApplication> grantedApplicationList) {
		
		try {
			File file = new File("GrantedApplications.dat");
			FileOutputStream fos;
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(grantedApplicationList);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

}
