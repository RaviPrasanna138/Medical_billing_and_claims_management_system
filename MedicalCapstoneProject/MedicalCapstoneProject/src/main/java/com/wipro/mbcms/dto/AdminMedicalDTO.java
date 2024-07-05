package com.wipro.mbcms.dto;

public class AdminMedicalDTO {
	
	private int adminId;
	private String adminName;
	private String adminPassword;
	private final static String role = "ADMIN";

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public static String getRole() {
		return role;
	}

	public AdminMedicalDTO(int adminId, String adminName, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	public AdminMedicalDTO() {
		super();
	}

	@Override
	public String toString() {
		return "AdminMedicalDTO [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword
				+ "]";
	}

}
