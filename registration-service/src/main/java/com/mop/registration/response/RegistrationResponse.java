package com.mop.registration.response;

import com.mop.registration.entity.Registration;

public class RegistrationResponse {

	private Long customerNumber;
    private String statusMessage;
    
    public RegistrationResponse(Registration registration) {
        this.customerNumber = registration.getRId();
        this.statusMessage = "Customer Created Successfully";
    }

	public Long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	@Override
	public String toString() {
		return "RegistrationResponse [customerNumber=" + customerNumber + ", statusMessage=" + statusMessage + "]";
	}

	
	
}
