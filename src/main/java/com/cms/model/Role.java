package com.cms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "role "/*,
    uniqueConstraints = @UniqueConstraint(
		columnNames = { "role", "user_id" })*/)
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id",unique = true, nullable = false)
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private String role;


    public Role() {
    }

    public Role(final User user, final String role) {
        this.user = user;
        this.role = role;
    }

    public Role(final String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setUserRoleId(final Integer id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }


    public String getRole() {
        return role;
    }

    public void setRole(final String roles) {
        role = roles;
    }

}
