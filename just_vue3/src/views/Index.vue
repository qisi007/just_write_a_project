
<template>
    <div class="app-body">
        <div class="app-body-left">
            <div class="app-body-left-top">
                <img src="../assets/images/logo.png" 
                    :style="{
                        width: state.isCollapse ? '45px' : '70px',
                        height: state.isCollapse ? '45px' : '70px',
                        marginTop: state.isCollapse ? '10px' : '0px',
                    }"  alt="">
                <p>{{globalConfig.website.title}}</p>
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
                    popper-append-to-body
                    @click="handleRouterGo(item)"
                >
                    <i :class="item.icon"></i>
                    <template #title>{{ item.title }}</template>
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
                    :title="state.isCollapse ? '展开菜单' : '收起菜单'"
                    @click="() => state.isCollapse = !state.isCollapse"></i>
                <div class="app-body-right-header-right">
                    <el-input :placeholder="state.inputWidth=='100px' ? '传送门' : '搜索导航/内容/按钮/表头'" 
                            v-model="state.searchContent" 
                            style="transition: all .5s ease;"
                            :style="{
                                width: state.inputWidth
                            }"
                            @focus="state.inputWidth='300px'"
                            @blur="state.inputWidth='100px'">
                        <template #suffix>
                            <i class="el-input__icon  el-icon-search"></i>
                        </template>
                    </el-input>
                    <div class="cut-vertical"></div>
                    <el-dropdown trigger="click">
                        <p class="el-dropdown-link" style="line-height: 100%; cursor: pointer"> 
                            <i style="margin-right: 5px" class="el-icon-guide"/>我的足迹</p>
                        <template #dropdown>
                            <el-dropdown-menu>
                            <el-dropdown-item><i class="el-icon-pie-chart"></i> 导航1</el-dropdown-item>
                            <el-dropdown-item><i class="el-icon-film"></i>导航2</el-dropdown-item>
                            </el-dropdown-menu>
                        </template>
                    </el-dropdown>
                    <div class="cut-vertical"></div>
                    <el-dropdown trigger="click">
                        <p class="el-dropdown-link" style="line-height: 100%; cursor: pointer"> 
                            <i style="margin-right: 5px" class="el-icon-user"/>管理员</p>
                        <template #dropdown>
                            <el-dropdown-menu>
                            <el-dropdown-item><i class="el-icon-setting"></i>设置</el-dropdown-item>
                            <el-dropdown-item><i class="el-icon-document"></i>个人信息</el-dropdown-item>
                            <el-dropdown-item><i class="el-icon-turn-off"></i>修改密码</el-dropdown-item>
                            <el-dropdown-item><i class="el-icon-switch-button"></i>退出登录</el-dropdown-item>
                            </el-dropdown-menu>
                        </template>
                    </el-dropdown>
                </div>
            </div>
            <router-view style="flex: 1; margin-top: 10px"  v-slot="{ Component }">
                <el-collapse-transition>
                    <component :is="Component" />
                </el-collapse-transition>
            </router-view>
        </div>
    </div>
</template>


<script setup>
import { reactive } from "vue";
import { useRouter } from "vue-router";
import globalConfig from "../config/global"


const state = reactive({
    isCollapse: false,
    searchContent: '',
    inputWidth: '100px',
    menuList: [
        {
            title: "导航1",
            index: "first",
            icon: "el-icon-pie-chart",
            path: "/index/default",
        },
        {
            title: "导航2",
            index: "first2",
            icon: "el-icon-film",
            path: "/index/test",
        },
        {
            title: "导航3",
            index: "first3",
            icon: "el-icon-office-building",
            path: "/index/login",
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
            align-items: center;
            img {
                width: 70px;
                height: 70px;
                margin: 0 10px;
                transition: all .5s ease;
            }

            p {
                font-size: 16px;
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
            display: flex;
            align-items: center;
            justify-content: space-between;
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
            
            .app-body-right-header-right {
                display: flex;
                align-items: center;
                margin-right: 20px;
            }
        }
    }
}


</style>
