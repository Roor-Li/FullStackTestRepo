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
  <div>
    <h3 style="color: purple; font-family:'Quicksand', sans-serif;">
      To Do List
    </h3>
    <div style="display: flex; align-items: flex-start;">
      <q-input rounded standout bottom-slots v-model="newTodo" label="NEW" counter
        @keyup.enter="addTodo"
        color="white"
        bg-color="purple"
      >
        <template v-slot:prepend>
          <q-icon name="event" />
        </template>
        <template v-slot:append>
          <q-icon name="close" @click="newTodo = ''" class="cursor-pointer" />
        </template>
        <template v-slot:hint>
          Length
        </template>
      </q-input>
      <q-btn
        round
        color="purple"
        icon="add"
        size="18.7px"
        @click="addTodo"
        style="margin-left: 1rem;"
      />
    </div>
  </div>
</template>

<style>

</style>