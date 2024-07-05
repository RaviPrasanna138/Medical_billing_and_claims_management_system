package com.wipro.mbcms.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class PatientIllegalArgumentsException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;

	public PatientIllegalArgumentsException(HttpStatusCode status, String reason) {
		super(status,reason);
	}

}
