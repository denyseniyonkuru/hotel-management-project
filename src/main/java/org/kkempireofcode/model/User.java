package org.kkempireofcode.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Table(name =  "user")
@Transactional
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
   @Column
    private String userName;
   @Column
    private String password;
    @Column
    private String names;
    @Column
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
