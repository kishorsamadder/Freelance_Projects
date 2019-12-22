package com.freelance.common;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response {

	private String status;
	private List<Message> messages;
	private Object data;

	public Response(String status, List<Message> messages, Object data) {
		super();
		this.status = status;
		this.messages = messages;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}