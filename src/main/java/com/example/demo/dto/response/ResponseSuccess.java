package com.example.demo.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ResponseSuccess extends ResponseEntity<ResponseSuccess.Payload>{
	
	//PUT, PATCH, DELETE
	public ResponseSuccess(HttpStatusCode status, String message) {
		//HttpStatus.OK => accept response data in body
		super(new Payload(status.value(),message), HttpStatus.OK);
		// TODO Auto-generated constructor stub
	}
	
	//GET, POST
	public ResponseSuccess(HttpStatusCode status, String message, Object data) {
		// TODO Auto-generated constructor stub
		super(new Payload(status.value(), message, data), HttpStatus.OK);
	}

	public static class Payload {
		private final int status;
		private final String message;
		private Object data;
		
		public Payload(int status, String message) {
			super();
			this.status = status;
			this.message = message;
		}

		public Payload(int status, String message, Object data) {
			super();
			this.status = status;
			this.message = message;
			this.data = data;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public int getStatus() {
			return status;
		}

		public String getMessage() {
			return message;
		}
		
		
	}
}
