import { createApp } from 'vue'
import App from './App.vue'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import { Quasar } from 'quasar'
import '@quasar/extras/material-icons/material-icons.css'
import 'quasar/src/css/index.sass'

import './assets/index.css'

const app = createApp(App)

app.use(ElementPlus)
app.use(Quasar, {
  plugins: {}
})
app.mount('#app')
