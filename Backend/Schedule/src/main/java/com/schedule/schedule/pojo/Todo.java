package com.schedule.schedule.pojo;


import java.util.List;


public class Todo {
    private String date;
//    private List<String> todoList;
    private String todoList;

    public Todo() {}
//    public Todo(String date, List<String> todoList) {
//        this.date = date;
//        this.todoList = todoList;
//    }
    public Todo(String date, String todoList) {
        this.date = date;
        this.todoList = todoList;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
//    public List<String> getTodoList() {
//        return todoList;
//    }
//    public void setTodoList(List<String> todoList) {
//        this.todoList = todoList;
//    }
    public String getTodoList() {
        return todoList;
    }
    public void setTodoList(String todoList) {
        this.todoList = todoList;
    }

    @Override
    public String toString() {
        return "{date=" + date + ", todoList=" + todoList + "}";
    }
}
