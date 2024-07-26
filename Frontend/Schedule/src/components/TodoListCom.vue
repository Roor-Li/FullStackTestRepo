<script setup>
const props = defineProps(['todoList'])
const emit = defineEmits(['deleteTodo'])

const deleteTodo = async (index) => {
  emit('deleteTodo', index)
}
</script>

<template>
  <div class="todo-list">
    <ul>
      <li v-for="(todo, index) in props.todoList" :key="index">
        <!-- <input type="checkbox" class="todo-item">{{ todo }} -->
        <span>{{ todo }}</span>
        <button @click="deleteTodo(index)">删除</button>
      </li>
    </ul>
  </div>
</template>