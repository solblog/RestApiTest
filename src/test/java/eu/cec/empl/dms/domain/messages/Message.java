package eu.cec.empl.dms.domain.messages;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	int id;
	String name;
	String text;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;                                                 
	}                                                                                     

	public Message(String name, String text) {
		this.name = name;
		this.text = text;
	}

	public String getName() {
		return name;
	}

	public String getText() {
		return text;
	}

}
