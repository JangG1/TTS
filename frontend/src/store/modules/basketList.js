import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const basketList = {
    namespaced: true,
    state: {
        basketList : [],
    },
    mutations: {
        addList(state, item){
            state.basketList.push(item);
        },
        delList(state, idx){
            state.basketList.splice(idx, 1);
        }

    },
    actions: {
    },
    getters: {
        getBasketList(state){
            return state.basketList;
        }
    }
}

export default basketList;
