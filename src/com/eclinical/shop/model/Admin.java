package com.eclinical.shop.model;

public class Admin extends User {

    private String officeContactNumber;
    private String officeLocation;
    private String adminRole;

    public Admin(String name, String contactNumber, String address, String username, String password, String officeContactNumber, String officeLocation) {
        super(name, contactNumber, address, username, password);
        this.officeContactNumber = officeContactNumber;
        this.officeLocation = officeLocation;
        this.adminRole = "ADMIN";
    }

    @Override
    public String toString() {
        return "Admin{" +
                super.toString() +
                "officeContactNumber='" + officeContactNumber + '\'' +
                ", officeLocation='" + officeLocation + '\'' +
                ", adminRole='" + adminRole + '\'' +
                '}';
    }

    public String getOfficeContactNumber() {
        return officeContactNumber;
    }

    public void setOfficeContactNumber(String officeContactNumber) {
        this.officeContactNumber = officeContactNumber;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }
}
