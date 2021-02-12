package com.course.account;

import java.sql.PreparedStatement;

public abstract class Account {

    String firstName;
    String lastName;
    String username;
    String password;
    String id;
    PreparedStatement pstmt;

    abstract boolean isInDatabase();

}
