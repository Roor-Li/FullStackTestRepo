package com.schedule.schedule.mapper;

import com.schedule.schedule.pojo.Todo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TodoMapper {
    @Select("SELECT * FROM tododb.tb_todo WHERE date = #{date}")
    Todo getTodoByDate(String date);

    @Update("UPDATE tododb.tb_todo SET todolist = #{todoList} WHERE date = #{date}")
    void update(Todo todo);

    @Insert("INSERT INTO tododb.tb_todo (date, todolist) VALUES (#{date}, #{todoList})")
    void insert(Todo todo);
}
