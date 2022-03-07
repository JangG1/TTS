import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const loginStore = {
    namespaced: true,
    state: {
        username: '',
        toPath:'sdsds'
    },
    mutations: {
        Login(state, payload) {
            state.username = payload;
        },
        Logout(state) {
            state.username = '';
        },
        setPath(state, payload){
            state.toPath = payload;
        }
    
    },
    actions: {
    },
    getters: {
        getLogin: function (state) {
            return state.username;
        },
        getPath(state){
            return state.toPath;
        }
    }
}

export default loginStore;
