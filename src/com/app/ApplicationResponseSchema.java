package com.app;


public class ApplicationResponseSchema<T> {

	private String status;
	private int code;
	private String message;
	private T data;
	
	public ApplicationResponseSchema() {
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public T getData() {
		return data;
	}



	public void setData(T data) {
		this.data = data;
	}



	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "NotesApiResponse [status=" + status + ", code=" + code + ", message=" + message + ", data=" + data
				+ "]";
	}


	

}
