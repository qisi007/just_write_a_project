
<template>
    <router-view></router-view>
</template>


<script setup>
import { reactive } from "vue";
import { useRouter } from "vue-router";

const state = reactive({
    isCollapse: false,
    menuList: [
        {
            title: "导航1",
            index: "first",
            icon: "el-icon-pie-chart",
            path: "/index",
        },
        {
            title: "导航2",
            index: "first2",
            icon: "el-icon-film",
            path: "/test",
            childern: [
                {
                    title: "导航1",
                    index: "first",
                    icon: "el-icon-pie-chart",
                    path: "/index",
                },
                {
                    title: "导航2",
                    index: "first2",
                    icon: "el-icon-film",
                    path: "/test",
                },
                {
                    title: "导航3",
                    index: "first3",
                    icon: "el-icon-office-building",
                    path: "/login",
                },
            ]
        },
        {
            title: "导航3",
            index: "first3",
            icon: "el-icon-office-building",
            path: "/login",
        },
    ],
});

const router = useRouter();

const handleRouterGo = (item) => {
    router.push(item.path);
};
</script>
<style lang="less">
#app,
body,
html {
    height: 100%;
    padding: 0;
    margin: 0;
}


</style>
