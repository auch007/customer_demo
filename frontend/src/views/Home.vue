<template>
  <div class="home">
    <Intro/>
    <CustomerList/>
  </div>
</template>

<script>
// @ is an alias to /src
import Intro from '@/components/Intro.vue'
import CustomerList from '@/components/CustomerList.vue'

export default {
  name: 'home',
  components: {
    Intro,
    CustomerList
  }
}
</script>
