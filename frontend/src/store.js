import Vue from 'vue'
import Vuex from 'vuex'
import moment from 'moment'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    selectedUid: null,
    custStus : [],
    custList : [],
    custNoteList: []
  },
  getters: {
    getStusList: state => {
      let result = []
      state.custStus.forEach(stus => result.push({
        "value" : stus.stusCod,
        "text"  : stus.stus
      }))
      return result
    },

    getCustList: state => {
      let result = []
      state.custList.forEach(cust => {
        let stus = state.custStus.find(stus => stus.stusCod === cust.stusCod)
        result.push({
          "custUid" : cust.custUid,
          "name"    : cust.name,
          "email"   : cust.email,
          "phone"   : cust.phone,
          "dob"     : moment(String(cust.dob)).format('YYYY-MM-DD'),
          "crtTs"   : moment(String(cust.crtTs)).format('YYYY-MM-DD hh:mm:ss'),
          "stus"    : stus.stus
          })
        }
      )
      return result
    },

    getSelectedCust: state =>  {
      let cust = state.custList.find(cust => cust.custUid === state.selectedUid)
      if (cust !== null) {
        let stus = state.custStus.find(stus => stus.stusCod === cust.stusCod)
        return [{
          "custUid" : cust.custUid,
          "name"    : cust.name,
          "email"   : cust.email,
          "phone"   : cust.phone,
          "dob"     : moment(String(cust.dob)).format('YYYY-MM-DD'),
          "crtTs"   : moment(String(cust.crtTs)).format('YYYY-MM-DD hh:mm:ss'),
          "stusCod" : cust.stusCod,
          "stus"    : stus.stus        
        }]
      }
      return null
    },

    getCustNoteList: state => {
      let result = []
      state.custNoteList.forEach(note => {
        result.push({
          "custNoteUid" : note.custNoteUid,
          "custUid"     : note.custUid,
          "note"        : note.note,
          "lstUpdTs"       : moment(String(note.lstUpdTs)).format('YYYY-MM-DD hh:mm:ss'),
          })
        }
      )
      return result   
    }
  },
  mutations: {
    INIT_CUST_STUS_STATE: (state, custStus) => {
      state.custStus = custStus
    },

    INIT_CUSTLIST_STATE: (state, custList) => {
      state.custList = custList  
    },

    INIT_CUSTNOTE_STATE: (state, custNoteList) => {
      state.custNoteList = custNoteList
    },

    SET_SELECTED_UID_STATE: (state, custUid) => {
      state.selectedUid = custUid
    },

    SET_CUST_STUS: (state, newStusCod) => {
      let cust = state.custList.find(cust => cust.custUid === state.selectedUid)
      if (cust !== null) {
        cust.stusCod = newStusCod
      }
    },

    ADD_CUST_NOTE: (state, note) => {
      state.custNoteList.push(note)
    },

    DELETE_CUST_NOTE: (state, custNoteUid) => {
      state.custNoteList = state.custNoteList.filter(note => note.custNoteUid !== custNoteUid)
    },

    UPDATE_CUST_NOTE: (state, newNote) => {
      let i = state.custNoteList.findIndex(note => note.custNoteUid === newNote.custNoteUid)
      state.custNoteList.splice(i, 1, newNote);
    }
  },
  actions: {
    initCustStusState: (context, custStus) => {
      context.commit("INIT_CUST_STUS_STATE", custStus)
    },

    initCustListState: (context, custList) => {
      context.commit("INIT_CUSTLIST_STATE", custList)
    },

    initCustNoteState: (context, custNoteList) => {
      context.commit("INIT_CUSTNOTE_STATE", custNoteList)
    },

    setSelectedUid: (context, custUid) => {
      context.commit("SET_SELECTED_UID_STATE", custUid)
    },

    setCustStus: (context, newStusCod) => {
      context.commit("SET_CUST_STUS", newStusCod)
    },

    addCustNote: (context, note) => {
      context.commit("ADD_CUST_NOTE", note)
    },

    deleteCustNote: (context, custNoteUid) => {
      context.commit("DELETE_CUST_NOTE", custNoteUid)
    },

    updateCustNote: (context, note) => {
      context.commit("UPDATE_CUST_NOTE", note)
    }
  }
})
