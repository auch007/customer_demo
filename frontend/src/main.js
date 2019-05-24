import Vue from 'vue'
import BootstrapVue from 'bootstrap-vue'
import App from './App.vue'
import router from './router'
import store from './store'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.prototype.$baseURL = "";
Vue.config.productionTip = false
Vue.use(BootstrapVue)

var vm = new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

global.vm = vm;