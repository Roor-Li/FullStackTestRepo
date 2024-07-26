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
  if (todoList.value.includes(newTodo.value)) {
    alert(newTodo.value + " already exists")
    return
  }
  todoList.value.push(newTodo.value)
  await updateTodoList(selectedDate.value, todoList.value)
}

const deleteTodo = async (todo) => {
  const index = todoList.value.indexOf(todo)
  todoList.value.splice(index, 1)
  await updateTodoList(selectedDate.value, todoList.value)
}

// 监听日期，根据日期渲染数据
watch(selectedDate, async () => {
  try {
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
<div class="container">
  <div class="calendar-container">
    <CalendarCom v-model="selectedDate"></CalendarCom>
  </div>
  <div class="todo-container">
    <q-card>
      <q-card-section>
        <TodoHeaderCom @add-todo="addTodo"></TodoHeaderCom>
      </q-card-section>
      <q-separator />
      <div>
        <q-card-section>
          <TodoListCom :todo-list="todoList" @delete-todo="deleteTodo"></TodoListCom>
        </q-card-section>
      </div>
    </q-card>
  </div>
</div>

</template>
<style scoped>
.container {
  display: flex;
  /* flex: auto; */
  width: 100%;
  height: 100%;
  /* flex-direction: column; */
  justify-content: center;
  align-items: center;
  /* padding: 10%; */

}
.calendar-container {
  /* flex: 0 1 50%; */
  display: inline;
}
.todo-container {
  /* flex: 0 1 50%; */
  display: inline;
  margin-left: 1rem;
  /* width: 50%; */
}
</style>
