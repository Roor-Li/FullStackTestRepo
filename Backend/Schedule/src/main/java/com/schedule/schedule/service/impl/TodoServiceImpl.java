package com.schedule.schedule.service.impl;

import com.schedule.schedule.mapper.TodoMapper;
import com.schedule.schedule.pojo.Todo;
import com.schedule.schedule.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoMapper todoMapper;
    @Override
    public Todo getTodo(String date) {
        return todoMapper.getTodoByDate(date);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoMapper.update(todo);
    }

    @Override
    public void insertTodo(Todo todo) {
        todoMapper.insert(todo);
    }
}
