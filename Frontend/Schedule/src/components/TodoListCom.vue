<script setup>
const props = defineProps(['todoList'])
const emit = defineEmits(['deleteTodo'])

const deleteTodo = async (todo) => {
  emit('deleteTodo', todo)
}
</script>

<template>
  <TransitionGroup name="list" tag="q-list" class="list-container">
    <q-item 
      active
      v-for="todo in props.todoList"
      :key="todo"
      class="example-item"
    >
      <q-item-section avatar>
        <q-avatar color="primary" text-color="white">
          {{ todo[0] }}
        </q-avatar>
      </q-item-section>
      <q-item-section>
        <q-item-label>{{ todo }}</q-item-label>
      </q-item-section>
      <q-item-section side>
        <q-btn 
          round
          push
          size="10px"
          icon="close"
          color="primary"
          @click="deleteTodo(todo)"
        />
      </q-item-section>
    </q-item>
  </TransitionGroup>
</template>

<style scoped>
.list-container {
  position: relative;
  padding: 0;
  list-style-type: none;
}
/* 对移动中的元素应用的过渡 */
.list-move {
  transition: all .5s;
}
.list-enter-active,
.list-leave-active {
  transition: all .5s ease;
}

.list-enter-from,
.list-leave-to {
  opacity: 0;
  transform: translateX(30px);
}

/* 确保将离开的元素从布局流中删除
  以便能够正确地计算移动的动画。 */
.list-leave-active {
  position: absolute;
}
</style>