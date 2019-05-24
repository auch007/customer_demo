<template>
  <div class="customerEdit">
    <h2>View/Edit Customer</h2>
    <b-table 
      responsive 
      striped hover
      :items="getSelectedCust" 
      :fields="custFields">        
    </b-table>
    <b-container class="bv-example-row">
    <b-row>
      <b-col>Change Customer Status</b-col>
      <b-col><b-form-select v-model="newStusCod" :options="getStusList"></b-form-select></b-col>
      <b-col>
          <b-button variant="success" @click="handleChangeStus">Change Status</b-button>&nbsp;
          <b-button variant="success" @click="handleRouteHome">Back to List</b-button>
      </b-col>
    </b-row>
     <b-row>
        <b-col><h2>&nbsp;</h2></b-col>
    </b-row>   
    <b-row>
        <b-col><h2>Customer Note(s)</h2></b-col>
    </b-row>
    <template v-for="note in getCustNoteList">
      <b-row v-bind:key="note.custNoteUid">
        <b-col>
          <b-card v-bind:header="note.lstUpdTs" style="max-width: 100rem;" class="mb-2" border-variant="success" align="center">
            <b-card-text>{{ note.note }}</b-card-text>
            <b-button variant="success" @click="setWkNoteUid(note.custNoteUid);setEditNote(note.note)" v-b-modal.modal-editNote>Edit</b-button>&nbsp;
            <b-button variant="success" @click="setWkNoteUid(note.custNoteUid)" v-b-modal.modal-cfmDelNote>Delete</b-button>
          </b-card>         
        </b-col>
      </b-row>
    </template>        
    <b-modal id="modal-cfmDelNote" title="Message" @ok="handleDeleteNote()">
      <p class="my-4">Delete customer note?</p>
    </b-modal>
     <b-modal id="modal-editNote" title="Edit Note" @ok="handleEditNote()">
        <b-form-textarea
            id="txtAreaEditNote"
            v-model="editNote"
            placeholder="Enter note here...(max 500 words)"
            rows="5"
            maxlength="500"></b-form-textarea>
    </b-modal>   
    <b-row>
        <b-col>&nbsp;</b-col>
    </b-row>   
    <b-row>
      <b-col>
          <b-form-textarea
            id="txtAreaNewNote"
            v-model="newNote"
            placeholder="Enter new note here...(max 500 words)"
            rows="5"
            maxlength="500"></b-form-textarea>
      </b-col>        
    </b-row>
    <b-row>
        <b-col>&nbsp;</b-col>
    </b-row>    
    <b-row>
      <b-col><b-button variant="success" @click="handleAddNote">Add Note</b-button></b-col>
    </b-row>    
    </b-container>  
  </div>
</template>

<script>
import axios from 'axios'
import {mapState, mapGetters, mapActions} from 'vuex'

export default {
  name: 'customerEdit',
  async mounted() {
    let resp = await axios.get(this.$baseURL + '/customerNote/' + this.selectedUid)
    this.initCustNoteState(resp.data)  
  },  
  data() {
    return {
      custFields: {
        custUid : {label: "Customer Identifier"},
        name    : {label: "Name"},
        email   : {label: "Email"},
        phone   : {label: "Phone"},
        dob     : {label: "Date of Birth"},
        crtTs   : {label: "Created At"},
        stus    : {label: "Status"}
      },
      newStusCod : this.$store.getters.getSelectedCust[0].stusCod,
      newNote: "",
      editNote: "",
      wkNoteUid: null,
    }
  },
  computed: {
    ...mapState([
      'selectedUid'
    ]),

    ...mapGetters([
      'getSelectedCust',
      'getStusList',
      'getCustNoteList'
    ])
  },
  methods: {
     ...mapActions([
      'initCustNoteState',
      'setCustStus',
      'addCustNote',
      'deleteCustNote',
      'updateCustNote'
    ]),

    handleChangeStus() {
       axios.patch(this.$baseURL + '/customer/' + this.selectedUid, {"stusCod" : this.newStusCod})
      .then(resp => {
        this.setCustStus(this.newStusCod)
        this.$bvToast.toast('Customer status is changed', {
          title: 'Notification',
          autoHideDelay: 8000,
          appendToast: true
        })
      })
    },

    handleRouteHome() {
      this.$router.push('/')
    },

    handleAddNote() {
      let req = {"custUid" : this.selectedUid, "note" : this.newNote}
      axios.post(this.$baseURL + '/customerNote', req)
      .then(resp => {
        this.addCustNote(resp.data)
        this.newNote = ""
        this.$bvToast.toast('New note is added', {
          title: 'Notification',
          autoHideDelay: 8000,
          appendToast: true
        })
      })
    },

    setWkNoteUid(custNoteUid) {
      this.wkNoteUid = custNoteUid
    },

    handleDeleteNote() {
       axios.delete(this.$baseURL + '/customerNote/' + this.wkNoteUid)
      .then(resp => {
        this.deleteCustNote(this.wkNoteUid)
        this.$bvToast.toast('Customer note is deleted', {
          title: 'Notification',
          autoHideDelay: 8000,
          appendToast: true
        })
      })
    },

    setEditNote(note) {
      this.editNote = note
    },

    handleEditNote() {
      axios.patch(this.$baseURL + '/customerNote/' + this.wkNoteUid, {"note" : this.editNote})
      .then(resp => {
        this.updateCustNote(resp.data)
        this.$bvToast.toast('Customer note is updated', {
          title: 'Notification',
          autoHideDelay: 8000,
          appendToast: true
        })
      })    
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
