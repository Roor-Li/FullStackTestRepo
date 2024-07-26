package com.schedule.schedule.controller;

import com.schedule.schedule.pojo.Result;
import com.schedule.schedule.pojo.Todo;
import com.schedule.schedule.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/todo")
@CrossOrigin
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping("/test")
    public Result schedule() {
        System.out.println("schedule");
        return Result.success();
    }
    /*
    根据日期获取TodoList
     */
    @GetMapping("/todo/{date}")
    public Result getTodo(@PathVariable String date){
        Todo todo = todoService.getTodo(date);
        return Result.success(todo);
    }
    /*
    根据日期更新todolist
     */
    @PostMapping("/update")
    public Result updateTodo(@RequestBody Todo todo){
        System.out.println("updateTodo");
        if(todoService.getTodo(todo.getDate()) != null) {
            todoService.updateTodo(todo);
        } else {
            todoService.insertTodo(todo);
        }
        return Result.success();
    }

}
