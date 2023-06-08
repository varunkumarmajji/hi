
package com.cglia.user.model;
public class CustomerRestCall {

	private Integer customerId;
	private String customername;
	private String customerEmail ;
	private Integer status;
	private String createdBy;
	private String modifiedBy;
	private String modifiedTime;
	
	public CustomerRestCall(Integer customerId, String customername, String customerEmail, Integer status,
			String createdBy, String modifiedBy, String modifiedTime) {
		this.customerId = customerId;
		this.customername = customername;
		this.customerEmail = customerEmail;
		this.status = status;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.modifiedTime = modifiedTime;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	@Override
	public String toString() {
		return "CustomerRestCall [customerId=" + customerId + ", customername=" + customername + ", customerEmail="
				+ customerEmail + ", status=" + status + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + "]";
	}
	

}
