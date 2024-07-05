package com.wipro.mbcms.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class PatientNotFoundException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;

	public PatientNotFoundException(HttpStatusCode status, String reason) {
		super(status, reason);
	}

}
