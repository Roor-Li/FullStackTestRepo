package com.schedule.schedule.service;

import com.schedule.schedule.pojo.Todo;

public interface TodoService {
    /*
    根据日期获取todo
     */
    Todo getTodo(String date);

    void updateTodo(Todo todo);

    void insertTodo(Todo todo);
}
