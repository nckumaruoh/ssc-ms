package com.klh.ds.stack;

import java.util.EmptyStackException;

public class MyStack<T> {
    private Object[] a;
    private int top;

    public MyStack() {
        this(16);
    }

    public MyStack(int cap) {
        if (cap < 1) cap = 1;
        this.a = new Object[cap];
        this.top = 0;
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void push(T v) {
        if (top == a.length) grow();
        a[top++] = v;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (top == 0) throw new EmptyStackException();
        return (T) a[top - 1];
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (top == 0) throw new EmptyStackException();
        T v = (T) a[--top];
        a[top] = null;
        return v;
    }

    private void grow() {
        Object[] b = new Object[a.length << 1];
        System.arraycopy(a, 0, b, 0, a.length);
        a = b;
    }
}

