import http from "../utils/http";

export default {
    getTableList: ( params ) => {
        return http.get("/table/list", { params })
    },

    addData: ( params ) => {
        return http.post("/table/add", params )
    },

    deleteData: ( id ) => {
        return http.post("/table/delete?id=" + id )
    },

    editData: (params) => {
        return http.post("/table/edit", params )
    },

    getDictionaryByType: ( type ) => {
        return http.get("/dictionary/list", {
            params: {
                type
            }
        })
    }

}