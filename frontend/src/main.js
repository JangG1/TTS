import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store/index.js'

// css
import "@/css/common.css";


Vue.config.productionTip = false
Vue.config.ignoredElements = ['item']

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
