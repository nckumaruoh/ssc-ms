package com.klh.sscms.ds.undo;

public interface Action {

    // Description shown to user
    String description();

    // Logic to reverse the action
    void undo();
}
