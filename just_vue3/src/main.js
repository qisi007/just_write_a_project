import { createApp } from 'vue'
import App from './App.vue'
import router from './router/index'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import locale from 'element-plus/lib/locale/lang/zh-cn'
const app = createApp(App)

import * as ElIcon from '@element-plus/icons-vue'
for (let iconName in ElIcon){
    app.component(iconName, ElIcon[iconName])
}
import "./assets/fonts/icon.css"

app.config.warnHandler = () => null;

app.use(ElementPlus,  { size: 'medium', locale }).use(router).mount('#app')
