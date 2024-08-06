<script setup>
import { getTodoList } from '@/api/todoList';
import { date } from 'quasar';

import { ref } from 'vue';

const nowDate = defineModel()
nowDate.value = date.formatDate(Date.now(), 'YYYY-MM-DD')

const formatDate = (date) => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()

  const formattedMonth = month < 10 ? `0${month}` : month
  const formattedDay = day < 10 ? `0${day}` : day

  return `${year}-${formattedMonth}-${formattedDay}`
}

const events = ref([])
const eventsColor = ref({})

const getEvents = async (view) => {
  events.value = []
  eventsColor.value = {}
  const { year, month } = view
  let date = new Date(year, month - 1, 1)
  while (date.getMonth() === month - 1) {
    const dateStr = formatDate(date)
    const dateTodo = await getTodoList(dateStr)
    if (dateTodo.length) {
      events.value.push(dateStr.replaceAll('-', '/'))
      eventsColor.value[dateStr.replaceAll('-', '/')] = dateTodo.length
    }
    date.setDate(date.getDate() + 1)
  }
}
const getEventsColor = (date) => {
  if(eventsColor.value[date] > 0 && eventsColor.value[date] <= 2) {
    return 'teal'
  } else if(eventsColor.value[date] <= 4) {
    return 'orange'
  } else {
    return 'red'
  }
}

const addEvents = (date) => {
  const dateStr = date.replaceAll('-', '/')
  if(events.value.includes(dateStr)) {
    eventsColor.value[dateStr] += 1
  } else {
    events.value.push(dateStr)
    eventsColor.value[dateStr] = 1
  }
}
const deleteEvents = (date) => {
  const dateStr = date.replaceAll('-', '/')
  eventsColor.value[dateStr] -= 1
  if(!eventsColor.value[dateStr]) {
    const index = events.value.findIndex(i => i === dateStr)
    if(index !== -1) events.value.splice(index, 1)
    delete eventsColor.value.dateStr
  }
}

getEvents({year: nowDate.value.getFullYear(), month: nowDate.value.getMonth() + 1})

console.log(events.value);

defineExpose({
  events,
  eventsColor,
  addEvents,
  deleteEvents,
  getEvents
})

</script>

<template>
    <q-date
      v-model="nowDate"
      @navigation="getEvents"
      :events
      :event-color="getEventsColor"
      today-btn
      mask="YYYY-MM-DD"
      color="purple"
    />
</template>