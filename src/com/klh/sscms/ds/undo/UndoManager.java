package com.klh.sscms.ds.undo;

import java.util.Stack;

public class UndoManager {

    private Stack<Action> stack = new Stack<>();

    public void push(Action action) {
        stack.push(action);
    }

    public Action undo() {
        if (stack.isEmpty()) {
            return null;
        }
        Action action = stack.pop();
        action.undo();
        return action;
    }
}
