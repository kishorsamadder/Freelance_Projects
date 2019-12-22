package com.freelance.common;

public class Message {

	private String type;
	private String message;
	private String field;

	public Message(String type, String message, String field) {
		this.type = type;
		this.message = message;
		this.field = field;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "Message [type=" + type + ", message=" + message + ", field=" + field + "]";
	}

}
