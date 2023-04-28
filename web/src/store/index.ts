import { createStore } from 'vuex'

const store = createStore({
  state: {
    user: {}
  },
  mutations: {
    setUser (state, user) {
      // console.log("store user：", user);
      state.user = user;
      // SessionStorage.set(USER, user);
    }
  },
  actions: {
  },
  modules: {
  }
})

export default store;
