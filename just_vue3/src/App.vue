
<template>
    <div class="app-body">
        <div class="app-body-left">
            <div class="app-body-left-top">
                <img src="./assets/images/logo.png" 
                    :style="{
                        width: state.isCollapse ? '45px' : '70px',
                        height: state.isCollapse ? '45px' : '70px',
                        marginTop: state.isCollapse ? '20px' : '0px',
                    }"  alt="">
                <p>后台管理</p>
            </div>
            <el-menu
                default-active="first"
                class="el-menu-vertical-demo"
                :collapse="state.isCollapse"
                :uniqueOpened="true"
                background-color="#3c3c3c"
                text-color="#fff"
                active-text-color="#ffd04b"
            >
                <el-menu-item
                    v-for="(item, index) in state.menuList"
                    :key="index"
                    :index="item.index"
                    @click="handleRouterGo(item)"
                >
                    <i :class="item.icon"></i>
                    <span>{{ item.title }}</span>
                </el-menu-item>
            </el-menu>
        </div>
        <div class="app-body-right"
            :style="{
                left: !state.isCollapse ? '200px': '65px'
            }">
            <div class="app-body-right-header">
                <i class="el-icon-s-fold app-body-right-fold" 
                    :style="{
                        transform: state.isCollapse ? 'rotate(-180deg)' : ''
                    }"
                    @click="() => state.isCollapse = !state.isCollapse"></i>
            </div>
            <el-collapse-transition>
                <router-view style="flex: 1; margin-top: 10px"></router-view>
            </el-collapse-transition>
        </div>
    </div>
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

.app-body {
    display: flex;
    height: 100%;
    width: 100%;
    position: relative;

    .app-body-left {
        display: flex;
        flex-direction: column;
        background-color: #3c3c3c;
        color: #fff;

        .app-body-left-top {
            display: flex;

            img {
                width: 70px;
                height: 70px;
                margin: 0 10px;
                transition: all .5s ease;
            }

            p {
                font-size: 24px;
            }
        }

        .el-menu {
            border: none;
        }

        .el-menu--collapse {
            flex: 1;
        }
        .el-menu-vertical-demo:not(.el-menu--collapse) {
            width: 200px;
            height: 100%;
        }
    }

    .app-body-right {
        position: absolute;
        top: 0;
        right: 0;
        bottom: 0;
        overflow: hidden;
        background-color: #fff;
        transition: all .5s ease;

        .app-body-right-header {
            height: 50px;
            // border-bottom: 1px solid rgb(247, 244, 244);
            display: flex;
            align-items: center;
            box-shadow: 0 2px 12px 0 rgba(0,0,0,0.1);

            .app-body-right-fold {
                cursor: pointer;
                font-size: 24px;
                margin-left: 10px;
                color: #7e7b7b;
                transition: all .5s ease;

                &:hover {
                    color: #4c4c4c;
                    transition: all .5s ease;
                }
            }
        }
    }
}


</style>
