package com.schedule.schedule;

import com.schedule.schedule.mapper.TodoMapper;
import com.schedule.schedule.pojo.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScheduleApplicationTests {

    @Autowired
    private TodoMapper todoMapper;

    @Test
    public void testTodoMapper() {
//        Todo todo = todoMapper.getTodoByDate("2024-07-17");
//        System.out.println(todo);
        Todo todo = new Todo("2024-07-23", "[\"睡觉\", \"做实验'\"]");
        todoMapper.update(todo);
    }

}
