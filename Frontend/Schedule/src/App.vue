<script setup>
import { ref, watch, onMounted } from 'vue';
import { getTodoList, updateTodoList } from '@/api/todoList';

import CalendarCom from './components/CalendarCom.vue';
import TodoHeaderCom from './components/TodoHeaderCom.vue';
import TodoListCom from './components/TodoListCom.vue'

// 选中的日期
const selectedDate = ref(new Date())

// 数据
const todoList = ref([])

const addTodo = async (newTodo) => {
  todoList.value.push(newTodo.value)
  await updateTodoList(selectedDate.value, todoList.value)
}

const deleteTodo = async (index) => {
  todoList.value.splice(index, 1)
  await updateTodoList(selectedDate.value, todoList.value)
}

// 监听日期，根据日期渲染数据
watch(selectedDate, async () => {
  try {
    // console.log(new Date());
    todoList.value = await getTodoList(selectedDate.value)
  } catch(err) {
    console.log(err);
  }
})

onMounted(async () => {
  todoList.value = await getTodoList(selectedDate.value)
})

</script>

<template>
<div id="app">
  <CalendarCom v-model="selectedDate"></CalendarCom>
  <TodoHeaderCom @add-todo="addTodo"></TodoHeaderCom>
  <TodoListCom :todo-list="todoList" @delete-todo="deleteTodo"></TodoListCom>
</div>

</template>

