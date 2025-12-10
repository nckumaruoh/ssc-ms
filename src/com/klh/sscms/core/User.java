package com.klh.sscms.core;

/**
* Base abstract class representing a user in the SSC-MS system
* All users (Student, Faculty, Admin) will inherit common fields
* and behaviors from this class.
*/

public abstract class User {
    // -------------------------
// Fields
// -------------------------
protected String id;
protected String name;
protected String email;
/** * Parameterized constructor to initialize a User object.
* @param id Unique user ID
* @param name Full name of the user
* @param email Email address of the user
*/
public User(String id, String name, String email) {
this.id = id;
this.name = name;
this.email = email;

}
 public abstract String getRole();
}
