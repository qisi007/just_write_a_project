import { createRouter, createWebHashHistory } from 'vue-router'


const routes = [
    {
        path: "/",
        redirect: '/login'
    },
    {
        path: "/login",
        component: () => import("../views/Login.vue")
    },
    {
        path: "/index",
        component: () => import("../views/Index.vue"),
        children: [
            {
                path: "/index/default",
                component: () => import("../views/List.vue")
            },
            {
                path: "/index/test",
                component: () => import("../views/Test.vue")
            },
            {
                path: "/index/login",
                component: () => import("../views/Login.vue")
            },
        ]
    },
    
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
    
})

export default router