package com.cdac.course_management.dto;

public class RegisterRequest {
    private String name;
    private String userName;
    private String password;
    private String roleType; // e.g., "ADMIN" or "USER"

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRoleType() { return roleType; }
    public void setRoleType(String roleType) { this.roleType = roleType; }
}
