<script setup>
import { ref, watch, onMounted } from 'vue';
import { getTodoList } from '@/utils/testBackend'

const selectedDate = ref(new Date())

// 获取数据
const todoList = ref([])
// todoList.value.push(...["11", "22", "33"])

const newTodo = defineModel()

const addTodo = () => {
  if (!newTodo.value) return
  todoList.value.push(newTodo.value)
  newTodo.value = ""
}
const deleteTodo = (index) => {
  // console.log(index);
  todoList.value.splice(index, 1)
}

watch(selectedDate, () => {
  // console.log(getTodoList(selectedDate.value));
  todoList.value = getTodoList(selectedDate.value)
})

onMounted(() => {
  // console.log(selectedDate.value);
  todoList.value = getTodoList(selectedDate.value)
  
})

</script>

<template>
  <el-calendar v-model="selectedDate">

  </el-calendar>
  <div class="todo-list">
    <header>
      Here is Schedual
    </header>
    <input type="text" class="todo-input" v-model="newTodo">
    <input type="submit" @click="addTodo">
    <ul>
      <li v-for="(todo, index) in todoList" :key="index">
        <input type="checkbox" class="todo-item">{{ todo }}
        <button @click="deleteTodo(index)">删除</button>
      </li>
    </ul>
  </div>
</template>

<style scoped>
.todo-list {
  flex: 0 1 100%;
}
.todo-input {
  display: inline-block;
}
.todo-item {
  display: inline-block;
}
</style>
