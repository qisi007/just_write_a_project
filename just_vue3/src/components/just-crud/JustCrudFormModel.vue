<template>
    <el-dialog
        title="提示"
        v-model="state.dialogVisible"
        width="30%"
        >
        <span>这是一段信息</span>
        <template #footer>
            <span class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
            </span>
        </template>
    </el-dialog>
</template>
<script setup>
import { reactive } from "vue"

const state = reactive({
    dialogVisible: false
})

const close = () => {
    state.dialogVisible = false
}

const open = () => {
    state.dialogVisible = true
}


defineExpose({
    open
})






</script>