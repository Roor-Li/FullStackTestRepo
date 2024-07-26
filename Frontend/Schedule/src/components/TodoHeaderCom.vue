<script setup>

const newTodo = defineModel()

const emit = defineEmits(['addTodo'])

const addTodo = () => {
  if (!newTodo.value) return
  emit('addTodo', newTodo)
  newTodo.value = ""
}

</script>

<template>
  <header>
      <h1>Here is Schedual</h1>
    <input type="text" @keyup.enter="addTodo" class="todo-input" v-model="newTodo">
    <input type="submit" @click="addTodo">
  </header>
</template>