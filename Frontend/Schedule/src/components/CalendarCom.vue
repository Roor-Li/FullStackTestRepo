<script setup>
import { date } from 'quasar';

const nowDate = defineModel()
nowDate.value = date.formatDate(Date.now(), 'YYYY-MM-DD')

</script>

<template>
    <q-date
      v-model="nowDate"
      today-btn
      mask="YYYY-MM-DD"
    />
</template>