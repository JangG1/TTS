import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const orderList = {
    namespaced: true,
    state: {
        orderList : [],
    },
    mutations: {
        addOrderList(state, item){
            state.orderList.push(item);
        },
        delOrderList(state, idx){
            state.orderList.splice(idx, 1);
        },
        clearOrderList(state){
            state.orderList = [];
        }
    },
    actions: {
    },
    getters: {
        getOrderList(state){
            return state.orderList;
        }
    }
}

export default orderList;
