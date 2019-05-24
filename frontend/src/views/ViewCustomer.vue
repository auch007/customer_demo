<template>
  <div class="viewCustomer">
    <Intro/>
    <CustomerEdit/>
  </div>
</template>

<script>
// @ is an alias to /src
import Intro from '@/components/Intro.vue'
import CustomerEdit from '@/components/CustomerEdit.vue'

export default {
  name: 'viewCustomer',
  components: {
    Intro,
    CustomerEdit
  }
}
</script>
