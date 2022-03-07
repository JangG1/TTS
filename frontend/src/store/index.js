import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

import createPersistedState from 'vuex-persistedstate';
import loginStore from "@/store/modules/loginStore.js";
import basketList from "@/store/modules/basketList.js";
import orderList from "@/store/modules/orderList.js";

const store = new Vuex.Store({
    modules: {
        loginStore: loginStore,
        basketList: basketList,
        orderList: orderList
    },
    plugins: [createPersistedState({
            storage: window.sessionStorage,
            paths: ["loginStore"]
        })]

})

export default store;