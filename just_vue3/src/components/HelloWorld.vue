
<template>
    <div class="header">
        <el-button type="success" @click="addData">新增</el-button>

        <el-form :inline="true" :model="formInline">
             <el-form-item label="姓名：" prop="name">
                <el-input v-model="formInline.name" style="width: 150px"></el-input>
            </el-form-item>
            <el-form-item label="年龄：" prop="age">
                <el-input v-model="formInline.age" style="width: 150px"></el-input>
            </el-form-item>
            <el-form-item label="日期：" prop="date">
                <el-date-picker
                    v-model="formInline.date"
                    type="date"
                    format="YYYY-MM-DD"
                    value-format="YYYY-MM-DD"
                    style="width: 150px"
                ></el-date-picker>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">查询</el-button>
            </el-form-item>
        </el-form>
    </div>
    <el-table :data="tableData" border style="width: 100%" height="800px">
        <el-table-column prop="name" label="姓名" width="200" />
        <el-table-column prop="age" label="年龄" width="200" />
        <el-table-column prop="date" label="日期" />
        <el-table-column label="操作" fixed="right">
            <template #default="scope">
                <el-button @click="editRow(scope)" type="primary">
                    编辑
                </el-button>
                <el-button @click="deleteRow(scope)" type="danger">
                    删除
                </el-button>
            </template>
        </el-table-column>
    </el-table>

    <el-dialog
        v-model="dialogVisible"
        :title="title"
        width="80%"
        :destroy-on-close="true"
    >
        <el-form
            ref="ruleFormRef"
            :model="ruleForm"
            :rules="rules"
            label-width="120px"
            class="demo-ruleForm"
            :size="formSize"
        >
            <el-form-item label="姓名：" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="年龄：" prop="age">
                <el-input v-model="ruleForm.age"></el-input>
            </el-form-item>
            <el-form-item label="日期：" prop="date">
                <el-date-picker
                    v-model="ruleForm.date"
                    type="date"
                    format="YYYY-MM-DD"
                    value-format="YYYY-MM-DD"
                    style="width: 100%"
                ></el-date-picker>
            </el-form-item>
        </el-form>
        <template #footer>
            <span class="dialog-footer">
                <el-button @click="close">取消</el-button>
                <el-button type="primary" @click="close">确定</el-button>
            </span>
        </template>
    </el-dialog>
</template>
<script setup>
import { ref, reactive } from "vue";
import { ElMessageBox } from "element-plus";
import axios from "axios";

axios.get("http://localhost:10010/table/list").then(res => {
  console.log(res)
})

const dialogVisible = ref(false);
const formSize = ref("");
const title = ref("新增");

const ruleForm = reactive({
    name: "",
    age: "",
    date: "",
});

const rules = reactive({
    test: [
        {
            required: true,
            message: "请输入",
            trigger: "blur",
        },
    ],
});

const formInline = reactive({
    name: "",
    age: "",
    date: "",
});

const tableData = [
    {
        date: "2016-05-03",
        name: "zhangsand",
        age: "12",
    },
];

const editRow = (row) => {
    let r = { ...row.row };
    Object.assign(ruleForm, r);
    title.value = "编辑";
    open();
};

const deleteRow = (row) => {
    console.log(row);
};

const addData = () => {
    ruleForm.name = "";
    ruleForm.age = "";
    ruleForm.date = "";
    title.value = "新增";
    open();
};

const open = () => {
    dialogVisible.value = true;
};

const close = () => {
    dialogVisible.value = false;
};

const onSubmit = () => {
  
}

</script>

<style scoped>
.header {
    line-height: 50px;
    display: flex;
    justify-content: space-between;
}
</style>

