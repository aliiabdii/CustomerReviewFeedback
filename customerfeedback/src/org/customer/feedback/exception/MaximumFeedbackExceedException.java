package org.customer.feedback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MaximumFeedbackExceedException extends RuntimeException
{
	public MaximumFeedbackExceedException(String message) {
		super(message);
	}
}
