import { createRouter, createWebHashHistory } from 'vue-router'


const routes = [
    {
        path: "/",
        redirect: '/login'
    },
    {
        path: "/index",
        component: () => import("../views/Index.vue")
    },
    {
        path: "/login",
        component: () => import("../views/Login.vue")
    },
    {
        path: "/test",
        component: () => import("../views/Test.vue")
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
    
})

export default router