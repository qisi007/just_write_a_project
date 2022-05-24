import { createApp } from 'vue'
import App from './App.vue'
import router from './router/index'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
const app = createApp(App)

import * as ElIcon from '@element-plus/icons-vue'
for (let iconName in ElIcon){
    app.component(iconName, ElIcon[iconName])
}

app.use(ElementPlus).use(router).mount('#app')
