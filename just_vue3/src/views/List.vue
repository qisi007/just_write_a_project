
<template>
<div class="index">
    <div class="header">
        <el-form :inline="true" :model="state.formInline">
            <el-form-item prop="name">
                <el-input v-model="state.formInline.name" placeholder="姓名" style="width: 200px" clearable></el-input>
            </el-form-item>
            <el-form-item>
                <el-button-group>
                    <el-button type="primary" @click="onSubmit">查询</el-button>
                    <el-button @click="onReset">重置</el-button>
                </el-button-group>
            </el-form-item>
        </el-form>
        <el-button type="success" @click="addData">新增</el-button>
    </div>
    <div class="table-wrap">
        <div class="table-box">
            <el-table :data="state.tableData" 
                    border 
                    style="width: 100%" 
                    v-loading="state.loading"
                    ref="tableRef"
                    height="100%"
                    @selection-change="handleSelectionChange">
                <el-table-column type="selection" width="55"> </el-table-column>
                <el-table-column prop="name" label="名称" align="center"/>
                <el-table-column prop="attribute" label="属性"  align="center">
                    <template #default="{ row }">
                        {{formatColumn("attributeDict", row.attribute)}}
                    </template>
                </el-table-column>
                <el-table-column prop="position" label="位置"  align="center">
                    <template #default="{ row }">
                        {{formatColumn("positionDict", row.position)}}
                    </template>
                </el-table-column>
                <el-table-column prop="talent" label="天赋"  align="center">
                    <template #default="{ row }">
                        {{formatColumn("talentDict", row.talent)}}
                    </template>
                </el-table-column>
                <el-table-column prop="q" label="技能q"  align="center"/>
                <el-table-column prop="w" label="技能w"  align="center"/>
                <el-table-column prop="e" label="技能e"  align="center"/>
                <el-table-column prop="r" label="技能r"  align="center"/>
                <el-table-column prop="skin" label="皮肤"  align="center"/>
                <el-table-column label="操作" fixed="right"  width="200">
                    <template #default="{ row }">
                        <el-button @click="editRow(row)" type="primary">
                            编辑
                        </el-button>
                        <el-button @click="deleteRow(row)" type="danger">
                            删除
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <div class="table-bottom">
            <div>
                <div class="table-bottom-tip" v-if="state.multipleSelection.length">
                    <div>当前表格已选择：{{state.multipleSelection.length}}条</div>
                    <el-button type="text" style="margin-left: 10px" @click="clearSelected">清空</el-button>
                </div>
            </div>
            <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="state.pageInfo.page"
                :page-sizes="[10, 20, 50, 100]"
                :page-size="state.pageInfo.size"
                layout="total, prev, pager, next,sizes,  jumper"
                background
                :total="state.total"
                >
                </el-pagination>
        </div>
    </div>

    <el-dialog
        v-model="state.dialogVisible"
        :title="state.title"
        :width="800"
        :destroy-on-close="true"
    >
        <el-form
            ref="ruleFormRef"
            :model="state.ruleForm"
            :rules="state.rules"
            label-width="120px"
            class="demo-ruleForm"
            :size="state.formSize"
        >
            <el-form-item label="姓名：" prop="name">
                <el-input v-model="state.ruleForm.name" placeholder="请输入姓名"></el-input>
            </el-form-item>
            <el-form-item label="属性：" prop="attribute">
                <el-select v-model="state.ruleForm.attribute" style="width: 100%" placeholder="请选择属性">
                    <el-option
                        v-for="item in state.attributeDict"
                        :key="item.code"
                        :label="item.name"
                        :value="item.code"
                        >
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="位置：" prop="position">
                <el-select v-model="state.ruleForm.position" style="width: 100%" placeholder="请选择位置">
                    <el-option
                        v-for="item in state.positionDict"
                        :key="item.code"
                        :label="item.name"
                        :value="item.code"
                        >
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="天赋：" prop="talent">
                <el-select v-model="state.ruleForm.talent" filterable  style="width: 100%" placeholder="请选择天赋">
                    <el-option
                        v-for="item in state.talentDict"
                        :key="item.code"
                        :label="item.name"
                        :value="item.code"
                        >
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="技能q：" prop="q">
                <el-input v-model="state.ruleForm.q" placeholder="请输入技能q"></el-input>
            </el-form-item>
            <el-form-item label="技能w：" prop="w">
                <el-input v-model="state.ruleForm.w" placeholder="请输入技能w"></el-input>
            </el-form-item>
            <el-form-item label="技能e：" prop="e">
                <el-input v-model="state.ruleForm.e" placeholder="请输入技能e"></el-input>
            </el-form-item>
            <el-form-item label="技能r：" prop="r">
                <el-input v-model="state.ruleForm.r" placeholder="请输入技能r"></el-input>
            </el-form-item>
            <el-form-item label="皮肤：" prop="skin">
                <el-input v-model="state.ruleForm.skin" placeholder="请输入皮肤"></el-input>
            </el-form-item>
        </el-form>
        <template #footer>
            <span class="dialog-footer">
                <el-button @click="close">取消</el-button>
                <el-button type="primary" @click="submit">确定</el-button>
            </span>
        </template>
    </el-dialog>
</div>
</template>
<script setup>
import { ref, reactive, onMounted } from "vue";
import { ElMessage, ElMessageBox } from "element-plus";
import HeroApi from "../api/hero";

const state = reactive({
    tableData: [],
    loading: false,
    total: 0,
    pageInfo: {
        page: 1,
        size: 10
    },
    formInline: {},
    ruleForm: {},
    title: "新增",
    formSize: "",
    dialogVisible: false,
    rules: {
        name: [
            {
                required: true,
                message: "请输入姓名",
                trigger: "blur",
            },
        ],
        attribute: [
            {
                required: true,
                message: "请选择属性",
                trigger: "blur",
            },
        ],
        position: [
            {
                required: true,
                message: "请选择位置",
                trigger: "blur",
            },
        ],
        talent: [
            {
                required: true,
                message: "请输入天赋",
                trigger: "blur",
            },
        ],
 
    },
    attributeDict: [],
    positionDict: [],
    talentDict: [],
    multipleSelection : []
});

const ruleFormRef = ref(null)
const tableRef = ref(null)

const getTableData = () => {
    state.loading = true
    HeroApi.getTableList({...state.pageInfo, ...state.formInline}).then( res => {
        state.tableData = res.data;
        state.total = res.total;
        state.loading = false
    })
}

const handleSizeChange = ( value ) => {
    state.pageInfo.size = value
    getTableData()
}

const handleCurrentChange = ( value ) => {
    state.pageInfo.page = value
    getTableData()
}

const editRow = (row) => {
    state.ruleForm = { ...row };
    state.title = "编辑"
    open();
};

const deleteRow = (row) => {
    ElMessageBox.confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
        }).then(() => {
            HeroApi.deleteData(row.id).then( res => {
                if( res.success ) {
                    ElMessage.success(res.message);
                    getTableData()
                }
            })
          })
    
};

const addData = () => {
    state.title = "新增";
    state.ruleForm = {};
    open();
};

const open = () => {
    state.dialogVisible = true;
};

const close = () => {
    state.dialogVisible = false;
};

const submit = async () => {
    try {
        const result = await ruleFormRef.value.validate()
        if ( !result ) return
        if ( state.title == '新增' ) {
            HeroApi.addData(state.ruleForm).then(res => {
                if( res.success ) {
                    ElMessage.success(res.message);
                    close();
                    getTableData()
                }
            })
        } else {
            HeroApi.editData(state.ruleForm).then(res => {
                if( res.success ) {
                    ElMessage.success(res.message);
                    close();
                    getTableData()
                }
            })
        }
    } catch(e) {

    }
}

const onSubmit = () => {
    getTableData()
}

const onReset = () => {
    state.formInline = {}
    getTableData()
}

const getDictionary = () => {
    HeroApi.getDictionaryByType('attribute').then( res => {
        state.attributeDict = res.data
    })
    HeroApi.getDictionaryByType('position').then( res => {
        state.positionDict = res.data
    })
    HeroApi.getDictionaryByType('talent').then( res => {
        state.talentDict = res.data
    })
}

const formatColumn = ( dict, key ) => {
    let dictionary = state[dict]
    if ( !dictionary ) return ""
    let result = dictionary.find( el => el.code == key )
    return result ? result.name : ""
}

const handleSelectionChange = ( val ) => {
    state.multipleSelection = val
}

const clearSelected = () => {
    state.multipleSelection = []
    tableRef.value.clearSelection()
}

onMounted( () => {
    getTableData()
    getDictionary()
})

</script>

<style lang="less" scoped>


.index {
    display: flex;
    height: 100%;
    padding: 10px;
    box-sizing: border-box;
    flex-direction: column;
    height: calc(100% - 50px);
}
.header {
    line-height: 50px;
    display: flex;
    justify-content: space-between;
}

.table-wrap {
    height: calc(100% - 60px);
    overflow: hidden;
}

.table-wrap .table-box {
    height: calc(100% - 50px);
}

.table-bottom {
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 50px;
}

/deep/.el-input--suffix .el-input__inner {
    margin-left: 30px;
}

.table-bottom-tip {
    display: flex;
    font-size: 14px;
    align-items: center;
    color: #409eff;
    background-color: #ecf5ff;
    padding: 0 15px;
    border-radius: 3px;
    border: 1px solid #d9ecff;
}
</style>

