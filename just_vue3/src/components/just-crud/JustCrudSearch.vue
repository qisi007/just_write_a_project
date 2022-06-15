<template>
    <div class="crud-table-body_tool_search">
        <div class="crud-table-body_tool_search_item" 
            v-for="(item, index) in state.searchOptions" 
            :key="index" 
            :style="{
                width: (state.config.searchItemWidth || 200) + 'px'
            }">
            <el-input v-if="!item.type || item.type=='input'"
                        style="width: 100%"
                        v-model="state.searchParams[item.prop]" 
                        :size="state.config.size" 
                        :placeholder="item.placeholder || item.label" 
                        :clearable="item.clearable || true"></el-input>
            <el-select  v-if="item.type=='select'"
                        style="width: 100%"
                        v-model="state.searchParams[item.prop]" 
                        :placeholder="item.placeholder || item.label"
                        :size="state.config.size"
                        :clearable="item.clearable || true"  >
                <el-option
                    v-for="option in item.options"
                    :key="option.value"
                    :label="option.label"
                    :value="option.value"
                ></el-option>
            </el-select>
            <el-date-picker v-if="item.type=='date'"
                            style="width: 100%"
                            v-model="state.searchParams[item.prop]" 
                            type="date" 
                            :value-format="item.valueFormat || 'YYYY-MM-DD'"
                            :size="state.config.size"

                            :placeholder="item.placeholder || item.label"
                            :clearable="item.clearable || true">
            </el-date-picker>
        </div>
        
        <div class="crud-table-body_tool_search_item">
            <el-button-group :size="state.config.size">
                <el-button type="primary" @click="handleSubmit">查询</el-button>
                <el-button @click="handleReset">重置</el-button>
            </el-button-group>
        </div>
    </div>
</template>

<script setup>
import { reactive, ref, computed  } from "vue"
const props = defineProps({
    config: Object,
    searchOptions: Object
})

const state = reactive({
    config: {},
    searchParams: {},
    searchOptions: []
})

state.config = props.config
state.searchOptions = props.searchOptions


const handleSubmit = () => {
    emit('on-submit', state.searchParams)
}

const handleReset = () => {
    state.searchParams = {}
    emit('on-reset', state.searchParams)
}

/**
 * 
 * emit events
 * 
*/

const emit = defineEmits([
    'on-submit',
    'on-reset'
])

</script>

<style lang="less" scoped>
    .crud-table-body_tool_search {
        display: flex;
        align-items: center;
        flex-wrap: wrap;

        .crud-table-body_tool_search_item {
            margin-right: 5px;
            margin-bottom: 8px;
        }
    }

    .crud-table-body_tool_edit {
        .el-button  {
            font-weight: 600;
        }
    }
</style>