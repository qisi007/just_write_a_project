<template>
    <div class="crud-table">
        <div class="crud-table-body">
            <div class="crud-table-body_tool">
                <div class="crud-table-body_tool_search">
                    <div class="crud-table-body_tool_search_item" 
                        v-for="(item, index) in 3" 
                        :key="index" 
                        :style="{
                            width: state.options.searchItemWidth + 'px'
                        }">
                        <el-input v-model="state.formInline.name" :size="state.options.size" placeholder="姓名" clearable></el-input>
                    </div>
                    
                    <div class="crud-table-body_tool_search_item">
                        <el-button-group :size="state.options.size">
                            <el-button type="primary" @click="onSubmit">查询</el-button>
                            <el-button @click="onReset">重置</el-button>
                        </el-button-group>
                    </div>
                </div>

                <div class="crud-table-body_tool_edit">
                    <!-- <el-button type="success" :size="state.options.size" @click="addData">新增</el-button> -->
                    <el-button-group :size="state.options.size"> 
                        <el-tooltip :effect="state.options.toolButtonEffect || 'dark'" content="新增" :placement="state.options.toolButtonPlacement || 'top'">
                            <el-button class="el-icon-plus "></el-button>
                        </el-tooltip>
                        <el-tooltip :effect="state.options.toolButtonEffect || 'dark'" content="批量删除" :placement="state.options.toolButtonPlacement || 'top'">
                            <el-button class="el-icon-delete"></el-button>
                        </el-tooltip>
                        <el-tooltip :effect="state.options.toolButtonEffect || 'dark'" content="刷新表格" :placement="state.options.toolButtonPlacement || 'top'">
                            <el-button class="el-icon-refresh"></el-button>
                        </el-tooltip>
                        <el-tooltip :effect="state.options.toolButtonEffect || 'dark'" content="自定义表头" :placement="state.options.toolButtonPlacement || 'top'">
                            <el-button class="el-icon-film"></el-button>
                        </el-tooltip>
                        <el-tooltip :effect="state.options.toolButtonEffect || 'dark'" content="导出数据" :placement="state.options.toolButtonPlacement || 'top'">
                            <el-button class="el-icon-printer"></el-button>
                        </el-tooltip>
                        
                        
                        
                        
                        
                        
                    </el-button-group>
                </div>

            </div>
            <div class="crud-table-body_box">
                <el-table :data="state.tableData" 
                        :height="state.options.height || '100%'"
                        :max-height="state.options.maxHeight"
                        :stripe="state.options.stripe"
                        :border="state.options.border || true"
                        :size="state.options.size"
                        :fit="state.options.fit"
                        :show-header="state.options.showheader"
                        :highlight-current-row="state.options.highlightCurrentRow"
                        :current-row-key="state.options.currentRowKey"
                        :row-class-name="state.options.rowClassName"
                        :row-style="state.options.rowStyle"
                        :cell-class-name="state.options.cellClassName"
                        :cell-style="state.options.cellStyle"
                        :header-row-class-name="state.options.headerRowClassName"
                        :header-row-style="state.options.headerRowStyle"
                        :header-cell-class-name="state.options.headerCellClassName"
                        :header-cell-style="state.options.headerCellStyle"
                        :row-key="state.options.rowKey"
                        :empty-text="state.options.emptyText"
                        :default-expand-all="state.options.defaultExpandAll"
                        :default-sort="state.options.defaultSort"
                        :tooltip-effect="state.options.tooltipEffect"
                        :tooltip="state.options.tooltip"
                        :show-summary="state.options.showSummary"
                        :sum-text="state.options.sumText"
                        :summary-method="state.options.summaryMethod"
                        :span-method="state.options.spanMethod"
                        :select-on-indeterminate="state.options.selectOnIndeterminate"
                        :indent="state.options.indent"
                        :lazy="state.options.lazy"
                        :load="state.options.load"
                        :tree-props="state.options.treeProps"
                        @select="select"
                        @select-all="selectAll"
                        @cell-mouse-enter="cellMouseEnter"
                        @cell-mouse-leave="cellMouseLeave"
                        @cell-click="cellClick"
                        @cell-dblclick="cellDblclick"
                        @cell-contextmenu="cellContextmenu"
                        @row-click="rowClick"
                        @row-contextmenu="rowContextmenu"
                        @row-dblclick="rowDblclick"
                        @header-click="headerClick"
                        @header-contextmenu="headerContextmenu"
                        @sort-change="sortChange"
                        @filter-change="filterChange"
                        @current-change="currentChange"
                        @header-dragend="headerDragend"
                        @expand-change="expandChange"
                        style="width: 100%" 
                        ref="tableRef">
                    <el-table-column v-for="(item, index) in state.columns"
                                    :key="index"
                                    :prop="item.prop" 
                                    :label="item.label" 
                                    :type="item.type"
                                    :width="item.width"
                                    :align="item.align || 'center'"
                                    :column-key="item.columnKey"
                                    :min-width="item.minWidth"
                                    :fixed="item.fixed"
                                    :render-header="item.renderHeader"
                                    :sortable="item.sortable || false"
                                    :sort-method="item.sortMethod"
                                    :sort-by="item.sortBy"
                                    :sort-orders="item.sort-orders || ['ascending', 'descending', null]"
                                    :resizable="item.resizable || true"
                                    :formatter="item.formatter"
                                    :show-overflow-tooltip="item.showOverflowTooltip || false"
                                    :header-align="item.headerAlign"
                                    :class-name="item.className"
                                    :label-class-name="item.labelClassName"
                                    :selectable="item.selectable"
                                    :reserve-selection="item.reserveSelection || false"
                                    :filters="item.filters"
                                    :filter-placement="item.filterPlacement"
                                    :filter-multiple="item.filterMultiple || true"
                                    :filter-method="item.filterMethod"
                                    :filtered-value="item.filtered-value"
                                    />

                    <el-table-column label="操作" fixed="right"  width="200">
                        <template #default="{ row }">
                            <el-button :size="state.options.size" @click="editRow(row)" type="primary">
                                编辑
                            </el-button>
                            <el-button :size="state.options.size" @click="deleteRow(row)" type="danger">
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
    </div>
</template>

<script setup>
import { reactive, ref  } from "vue"
const theme = {
    color: 'blue',
    tableHeaderBackground: '#fafafa'
}


const props = defineProps({
    options: Object
})

const state = reactive({
    options: {},
    columns: [],
    tableData: [
        {name: '张三'}, {name: 'lisi'}
    ],
    total: 0,
    pageInfo: {
        page: 1,
        size: 10
    },
    multipleSelection : [],
    formInline: {}
})

const tableRef = ref(null)

state.options = props.options
state.columns = props.options.columns

const handleSizeChange = ( value ) => {
    state.pageInfo.size = value
}

const handleCurrentChange = ( value ) => {
    state.pageInfo.page = value
}

const clearSelected = () => {
    state.multipleSelection = []
    tableRef.value.clearSelection()
}


/**
 * 
 * emit events
 * 
*/

const emit = defineEmits([
    'select',
    'select-all',
    'cell-mouse-enter',
    'cell-mouse-leave',
    'cell-click',
    'cell-dblclick',
    'cell-contextmenu',
    'row-click',
    'row-contextmenu',
    'row-dblclick',
    'header-click',
    'header-contextmenu',
    'sort-change',
    'filter-change',
    'current-change',
    'header-dragend',
    'expand-change'
])


/**
 * 
 * Table Events
 * 
*/
const select = ( ...arguement ) => {
    emit('select', ...arguement)
}
const selectAll = ( ...arguement ) => {
    emit('select-all', ...arguement)
}
const cellMouseEnter = ( ...arguement ) => {
    emit('cell-mouse-enter', ...arguement)
}
const cellMouseLeave = ( ...arguement ) => {
    emit('cell-mouse-leave', ...arguement)
}
const cellClick = ( ...arguement ) => {
    emit('cell-click', ...arguement)
}
const cellDblclick = ( ...arguement ) => {
    emit('cell-dblclick', ...arguement)
}
const cellContextmenu = ( ...arguement ) => {
    emit('cell-contextmenu', ...arguement)
}
const rowClick = ( ...arguement ) => {
    emit('row-click', ...arguement)
}
const rowContextmenu = ( ...arguement ) => {
    emit('row-contextmenu', ...arguement)
}
const rowDblclick = ( ...arguement ) => {
    emit('row-dblclick', ...arguement)
}
const headerClick = ( ...arguement ) => {
    emit('header-click', ...arguement)
}
const headerContextmenu = ( ...arguement ) => {
    emit('header-contextmenu', ...arguement)
}
const sortChange = ( ...arguement ) => {
    emit('sort-change', ...arguement)
}
const filterChange = ( ...arguement ) => {
    emit('filter-change', ...arguement)
}
const currentChange = ( ...arguement ) => {
    emit('current-change', ...arguement)
}
const headerDragend = ( ...arguement ) => {
    emit('header-dragend', ...arguement)
}
const expandChange = ( ...arguement ) => {
    emit('expand-change', ...arguement)
}

/**
 * 
 * Table Methods
 * 
*/

const clearSelection = () => {
    tableRef.value.clearSelection()
}

const toggleRowSelection = (row, selected) => {
    tableRef.value.toggleRowSelection(row, selected)
}

const toggleAllSelection = () => {
    tableRef.value.toggleAllSelection()
}

const toggleRowExpansion = (row, expanded) => {
    tableRef.value.toggleRowExpansion(row, expanded)
}

const setCurrentRow = (row) => {
    tableRef.value.setCurrentRow(row)
}

const clearSort = () => {
    tableRef.value.clearSort()
}


const clearFilter = () => {
    tableRef.value.clearFilter(columnKey)
}

const doLayout = () => {
    tableRef.value.doLayout()
}

const sort = (prop, order) => {
    tableRef.value.sort(prop, order)
}


defineExpose({
    tableRef,
    tableRefValue: tableRef.value,
    clearSelection,
    toggleRowSelection,
    toggleAllSelection,
    toggleRowExpansion,
    setCurrentRow,
    clearSort,
    clearFilter,
    doLayout,
    sort
})


</script>

<style lang="less" scoped>
.crud-table {
    height: 100%;
    display: flex;
    flex-direction: column;
    overflow: hidden;
    padding: 10px;
    box-sizing: border-box;

    .crud-table-body {
        flex: 1;
        overflow: hidden;

        .crud-table-body_tool {
            display: flex;
            align-items: flex-start;
            justify-content: space-between;

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
        }

        .crud-table-body_box {
            height: calc(100% - 135px);
        }
    }
}

</style>
<style lang="less">

.el-table__header-wrapper tr .el-table__cell {
    background-color: v-bind('theme.tableHeaderBackground')!important;
}
</style>
