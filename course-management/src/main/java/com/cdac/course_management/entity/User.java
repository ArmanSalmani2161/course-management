package com.cdac.course_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users", schema = "public")
public class User {

	 @Id
	    @SequenceGenerator(name = "users_user_id_seq_gen", sequenceName = "users_user_id_seq_gen", allocationSize = 1)
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_user_id_seq_gen")
	    @Column(name = "user_id")
	    private Integer userId;


    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "user_name", length = 255, unique = true)
    private String userName;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "role_type", length = 50)
    private String roleType;

    // Getters and Setters
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRoleType() { return roleType; }
    public void setRoleType(String roleType) { this.roleType = roleType; }
}
