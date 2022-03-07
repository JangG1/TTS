import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from '../views/Main.vue'
Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        // name: 'Main',
        component: Main,
        children: [
            {
                path: '',
                component: () => import ('@/components/mainPage/productTable.vue')
            }, 
        ]
    }, {
        path: '/blank',
        component: () => import ('../views/blank.vue')
    }, {
        path: '/trans',
        component: () => import ('../views/trans.vue')
    }, {
        path: '/trans2',
        component: () => import ('../views/trans2.vue')
    }, {
        path: '*',
        component: () => import ('../views/blank.vue')
    }
]

const router = new VueRouter(
    {mode: 'history', base: process.env.BASE_URL, routes}
)

export default router
