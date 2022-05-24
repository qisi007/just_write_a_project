
<template>
    <div class="app-body">
        <div class="app-body-left">
          <!-- <el-icon @click="() => state.isCollapse = !state.isCollapse">
            <fold />
          </el-icon> -->
      
        <el-menu
            default-active="first"
            class="el-menu-vertical-demo"
            :collapse="state.isCollapse"
            :uniqueOpened="true"
             background-color="#3c3c3c"
            text-color="#fff"
            active-text-color="#ffd04b"
        >
     
            <el-menu-item v-for="( item, index) in state.menuList" 
                          :key="index"
                          :index="item.index"
                          @click="handleRouterGo(item)">
                <template #title>{{item.title}}</template>
            </el-menu-item>
        </el-menu>
        </div>
        <router-view style="flex: 1"></router-view>
    </div>
</template>


<script setup>
import { reactive } from "vue";
import { useRouter } from 'vue-router'

const state = reactive({
    isCollapse: false,
    menuList: [
      {
        title: '导航1',
        index: 'first',
        icon: 'search',
        path: '/index'
      },
      {
        title: '导航2',
        index: 'first2',
        icon: 'search',
        path: '/test'
      },
      {
        title: '导航3',
        index: 'first3',
        icon: 'search',
        path: '/login'
      }
    ]
});

const router = useRouter();

const handleRouterGo = ( item ) => {
  router.push(item.path)
}




</script>
<style>
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
}

.app-body-left .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    height: 100%;
}
</style>
