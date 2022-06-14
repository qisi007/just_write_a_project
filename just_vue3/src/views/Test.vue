<template>
    <JustCrud :options="state.option" 
                ref="justCurd" 
                @cell-click="selectClick"
                @clear-selected="clearSelected"/>
</template>
<script setup>
import { ref, reactive } from "vue"
import JustCrud from "../components/just-crud/index"

const justCurd = ref(null)

const state = reactive({
    option: {
        data: [],
        border: true,
        size: '',
        searchItemWidth: 120,
        toolButtonEffect: 'dark',
        toolButtonPlacement: 'top',
        columns: [
            {
                type: 'selection'
            },
            {
                type: 'index',
                label:'序号',
                width: 60
            },
            {
                prop: 'name',
                label: '姓名',
                sortable: true
            },
            {
                prop: 'age',
                label: '年龄',
            },
            {
                prop: 'age',
                label: '地址',
            }
        ]
    }
})

const selectClick = ( value, value2, value3, value4 ) => {
    console.log( value, value2, value3, value4)
}

const handleClick = () => {
    console.log(justCurd.value.toggleAllSelection())
}

const clearSelected = () => {
    console.log(123123)
}

</script>



