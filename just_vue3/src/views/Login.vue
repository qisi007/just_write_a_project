<template>
    <div class="login" id="login">
        <div class="login-form">
            <div class="title">用户登录</div>
              <el-form
                    :model="state.formModel"
                    status-icon
                    :rules="state.rules"
                    ref="ruleForm"
                    label-width="100px"
                    >
                    <el-form-item label="账号" prop="user">
                        <el-input v-model="state.formModel.user" ></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="pass">
                        <el-input type="password"  v-model="state.formModel.pass" ></el-input>
                    </el-form-item>
                    <el-form-item style="margin-top: 30px">
                        <el-button type="primary" @click="submitForm('ruleForm')" style="width: 300px">登录</el-button>
                    </el-form-item>
                    </el-form>
        </div>


    </div>
</template>
<script setup>
import { ref, reactive, onMounted } from "vue";
import { useRouter } from 'vue-router'


import dayjs from "dayjs"
import { toPng, toJpeg, toBlob, toPixelData, toSvg } from 'html-to-image';

onMounted(() => {





})



let a = dayjs().format()
console.log(123123,a)

let runDate = '20240229'
let b = dayjs(runDate).add(3,"year").format()

console.log(b)


const state = reactive({
    formModel: {
        user: 'admin',
        pass:'123456'
    },
    rules: {}
})

const router = useRouter()

const submitForm = () => {
    router.push("/index/default")
}

const resetForm = () => {

}


</script>
<style>
.login {
    height: 100%;
    background: url(../assets/images/login.png) no-repeat center fixed;
    background-size: cover;
    display: flex;
    align-items: center;
    justify-content: center;
}

.login-form {
    width: 350px;
    padding: 50px 50px 30px 10px;
    background: #fff;
    border-radius: 10px;
    margin-top: -10%;
}

.login-form .title {
    font-size: 24px;
    text-align: center;
    margin-bottom: 50px;
    margin-left: 50px;
    letter-spacing: 5px;
}


</style>