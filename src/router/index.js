import {createRouter, createWebHistory} from 'vue-router'

const routes = [
    {
        path: '/',
        name: 'Layout',
        redirect: "/user",
        component: () => import("@/layout/Layout"),
        children: [{
            path: 'user',
            name: 'User',
            component: () => import("@/views/User")
        },
            {
                path: 'book',
                name: 'Book',
                component: () => import("@/views/Book")
            },
            {
                path: 'person',
                name: 'Person',
                component: () => import("@/views/Person")
            }
        ]
    },
    {
        path: '/login',
        name: 'Login',
        component: () => import("@/views/Login")
    },
    {
        path: '/register',
        name: 'Register',
        component: () => import("@/views/Register")
    },

]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
