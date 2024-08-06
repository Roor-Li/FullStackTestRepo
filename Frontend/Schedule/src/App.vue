<script setup>
import { ref, watch, onMounted } from 'vue';
import { getTodoList, updateTodoList } from '@/api/todoList';

import CalendarCom from './components/CalendarCom.vue';
import TodoHeaderCom from './components/TodoHeaderCom.vue';
import TodoListCom from './components/TodoListCom.vue'

// 选中的日期
const selectedDate = ref(new Date())
const calendarRef = ref(null)

// 数据
const todoList = ref([])

// 是否有代办重名
const alert = ref(false)

const addTodo = async (newTodo) => {
  if (todoList.value.includes(newTodo.value)) {
    alert.value = true
    return
  }
  todoList.value.push(newTodo.value)
  await updateTodoList(selectedDate.value, todoList.value)
  // console.log(selectedDate.value, typeof(selectedDate.value));
  calendarRef.value.addEvents(selectedDate.value)
}

const deleteTodo = async (todo) => {
  const index = todoList.value.indexOf(todo)
  todoList.value.splice(index, 1)
  await updateTodoList(selectedDate.value, todoList.value)
  calendarRef.value.deleteEvents(selectedDate.value)
  // const parts = selectedDate.value.split('-')
  // await calendarRef.value.getEvents({
  //   year: parts[0],
  //   month: parts[1]
  // })
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
    <CalendarCom v-model="selectedDate" ref="calendarRef"></CalendarCom>
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
  <q-dialog v-model="alert">
      <q-card>
        <q-card-section>
          <div class="text-h6">Alert</div>
        </q-card-section>

        <q-card-section class="q-pt-none" style="width: 500px;">
          To DO already exists
        </q-card-section>

        <q-card-actions align="right">
          <q-btn flat label="OK" color="primary" v-close-popup />
        </q-card-actions>
      </q-card>
    </q-dialog>
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
