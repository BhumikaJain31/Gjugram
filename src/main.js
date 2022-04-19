import Vue from 'vue'
import Vuex from 'vuex'
import App from './App.vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import VueRouter from 'vue-router'

import userProfile from './components/userProfile'
import userFeed from './components/userFeed'
import userSignIn from './components/userSignIn'
import userSignUp from './components/userSignUp'
import addPosts from './components/addPosts'
import updateProfile from './components/updateProfile'
import searchBar from './components/searchBar'
import userDetails from './components/userDetails'
import userNotification from './components/userNotification'
import updateInterests from './components/updateInterests'
import footerBar from './components/footerBar'
import savedPosts from './components/savedPosts'

import { library } from '@fortawesome/fontawesome-svg-core'
import { faHeart, faUserCircle, faArrowAltCircleRight } from '@fortawesome/free-regular-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import Toasted from 'vue-toasted';

library.add(faHeart, faUserCircle, faArrowAltCircleRight)

Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.use(Vuex);
Vue.use(VueAxios, axios)
Vue.use(VueRouter)

Vue.config.productionTip = false
Vue.use(Toasted, {
  duration: 2500,
  position: 'bottom-right', 
  theme: 'toasted-primary',
  iconPack: 'mdi' 
})

const store = {
  state: {
    user: [],
    auth: ''
  },
  /* created() {
    if (sessionStorage.getItem("Authorization")) {
      this.auth = sessionStorage.getItem("Authorization")
    }
  }, */
  getters: {

    getUser(state) {
      return state.user
    }
  },
  mutations: {

    setUser(state, val) {
      state.user = val
    }
  },
  actions: {

    handleUser({ commit }) {
      Vue.axios.get('http://localhost:8083/user-post/get-all-users', {
        headers: {
          'Authorization': 'Bearer ' + sessionStorage.getItem("Authorization"),
          'Content-Type': 'application/x-www-form-urlencoded'

        }
      }).then(resp => {
        console.log(resp)
        commit('setUser', resp.data)
        console.log(resp.data)
      })
    },

  }

}

const routes = [
  {
    path: '/userProfile',
    name: 'userProfile',
    component: userProfile,
   
    
  },
  {
    path: '/userFeed',
    name: 'userFeed',
    component: userFeed
  },
  {
    path: '/',
    name: 'userSignIn',
    component: userSignIn
  },
  {
    path: '/userSignUp',
    name: 'userSignUp',
    component: userSignUp
  },
  {
    path: '/addPosts',
    name: 'addPosts',
    component: addPosts
  },
  {
    path: '/updateProfile',
    name: 'updateProfile',
    component: updateProfile
  },
  {
    path: '/searchBar',
    name: 'searchBar',
    component: searchBar,
    props: true
  },
  {
    path: '/userDetails/:userId',
    name: 'userDetails',
    component: userDetails
  },
  {
    path: '/userNotification',
    name: 'userNotification',
    component: userNotification
  },
  {
    path: '/footerBar',
    name: 'footerBar',
    component: footerBar
  },
  {
    path: '/updateInterests',
    name: 'updateInterests',
    component: updateInterests,
    props: true
  },
  {
    path: '/savedPosts',
    name: 'savedPosts',
    component: savedPosts,
    props: true
  }

]

new Vue({
  store: new Vuex.Store(store),
  router: new VueRouter({
    routes,
    mode: 'history'
  }),

  render: h => h(App),
}).$mount('#app')