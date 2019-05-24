<template>
  <div class="customerList">
    <h2>List of Customer</h2>
    <b-container class="bv-example-row">
    <b-row>
        
    </b-row>
    </b-container>
    <p>CLICK on the row to view and edit details.</p>
    <b-container class="bv-example-row">
    <b-row>
      <b-col>
        <b-form-group class="mb-0">
          <b-input-group>
            <b-form-input v-model="custFilter" placeholder="Enter Keyword to Filter..."></b-form-input>
            <b-input-group-append>
              <b-button variant="success" :disabled="!custFilter" @click="custFilter = ''">Clear</b-button>
            </b-input-group-append>
          </b-input-group>
        </b-form-group>
      </b-col>
    </b-row>
    <br/>   
    <b-table
      show-empty 
      stacked="md"
      responsive 
      striped hover
      selectable
      select-mode="single"
      selectedVariant="success" 
      :items="getCustList" 
      :fields="custListFields"
      :filter="custFilter"
      :per-page="perPage"
      :current-page="currentPage"
      @row-selected="rowSelected"
      @filtered="onFiltered">
    </b-table>
    <b-row>
      <b-col md="6" class="my-1">
        <b-pagination
          v-model="currentPage"
          :total-rows="totalRows"
          :per-page="perPage"
          class="my-0"
        ></b-pagination>
      </b-col>
    </b-row>
    </b-container>
    <b-modal id="modal-cfmEditCust" title="Message" @ok="handleOK">
      <p class="my-4">Edit this customer?</p>
    </b-modal>
  </div>
</template>

<script>
import axios from 'axios'
import {mapGetters, mapActions} from 'vuex'

export default {
  name: 'customerList',
  async mounted() {
    let resp = await axios.get(this.$baseURL + '/custStusList')
    this.initCustStusState(resp.data)  
    resp = await axios.get(this.$baseURL + '/customerList')
    this.initCustListState(resp.data)
    this.totalRows = this.getCustList.length
  },
  data() {
    return {
      custListFields: {
        custUid : {label: "Customer Identifier", sortable: true},
        name    : {label: "Name", sortable: true},
        email   : {label: "Email", sortable: true},
        phone   : {label: "Phone", sortable: true},
        dob     : {label: "Date of Birth", sortable: true},
        crtTs   : {label: "Created At", sortable: true},
        stus    : {label: "Status", sortable: true}
      },
      custFilter:"",
      totalRows: 0,
      currentPage: 1,
      perPage: 10
    }
  },
  computed: {
    ...mapGetters([
      'getCustList'
    ])
  },
  methods: {
    ...mapActions([
      'initCustStusState',
      'initCustListState',
      'setSelectedUid'
    ]),

    rowSelected(row) {
      this.setSelectedUid(row[0].custUid)
      this.$bvModal.show("modal-cfmEditCust")
    },

    handleOK() {      
      this.$router.push('viewCustomer')
    },

    onFiltered(filteredItems) {
        this.totalRows = filteredItems.length
        this.currentPage = 1
    }
  } 
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
