<template>
  <JustCrud
    :config="state.config"
    :data="state.data"
    ref="justCurd"
    @cell-click="selectClick"
    @clear-selected="clearSelected"
  />
</template>
<script setup>
import { ref, reactive } from "vue";
import JustCrud from "../components/just-crud/index";

const justCurd = ref(null);

const state = reactive({
  data: [
    {
      name: "张三",
    },
    {
      name: "lisi",
    },
  ],
  config: {
    border: true,
    size: "small",
    searchItemWidth: 120,
    toolButtonEffect: "dark",
    toolButtonPlacement: "top",
    // tableHeaderBackground: 'red',
    total: 2,
    pageInfo: {
      page: 1,
      size: 10,
    },
    columns: [
      {
        type: "selection",
      },
      {
        type: "index",
        label: "序号",
        width: 60,
      },
      {
        prop: "name",
        label: "姓名",
        sortable: true,
        search: true,
      },
      {
        prop: "age",
        label: "年龄",
      },
      {
        prop: "sex",
        label: "性别",
        search: true,
        type: 'select',
        optionProps: {
            label: 'name',
            value: 'code'
        },
        options: [
            {
                code: '1',
                name: '男'
            },
            {
                code: '2',
                name: '女'
            }
        ]
      },

      {
        prop: "age",
        label: "地址",
      },
      {
        prop: 'date',
        label: '出生年月',
        search: true,
        type: 'date'
      }
    ],
  },
});


const selectClick = (value, value2, value3, value4) => {
  // console.log( value, value2, value3, value4)
};

const handleClick = () => {
  // console.log(justCurd.value.toggleAllSelection())
};

const clearSelected = () => {
  // console.log(123123)
};
</script>



