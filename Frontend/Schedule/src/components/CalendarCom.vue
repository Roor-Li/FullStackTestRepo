<script setup>
import { date } from 'quasar';

const nowDate = defineModel()
nowDate.value = date.formatDate(Date.now(), 'YYYY-MM-DD')

</script>

<template>
  <div>
    <q-date
      v-model="nowDate"
      landscape
      mask="YYYY-MM-DD"
    />
  </div>
</template>