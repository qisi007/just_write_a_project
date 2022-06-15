<template>
    <div class="crud-table">
        <div class="crud-table-body">
            <!-- 工具栏 -->
            <div class="crud-table-body_tool">
                <!-- 左侧条件搜索 -->
                <JustCrudSearch :config="props.config" 
                                :searchOptions="state.searchOptions" 
                                @on-submit="handleSubmit"
                                @on-reset="handleReset"/>
                <!-- 右侧编辑按钮 -->
                <div class="crud-table-body_tool_edit">
                    <el-button-group :size="state.config.size"> 
                        <el-tooltip :effect="state.config.toolButtonEffect || 'dark'" content="新增" :placement="state.config.toolButtonPlacement || 'top'">
                            <el-button class="el-icon-plus "></el-button>
                        </el-tooltip>
                        <el-tooltip :effect="state.config.toolButtonEffect || 'dark'" content="批量删除" :placement="state.config.toolButtonPlacement || 'top'">
                            <el-button class="el-icon-delete"></el-button>
                        </el-tooltip>
                        <el-tooltip :effect="state.config.toolButtonEffect || 'dark'" content="刷新表格" :placement="state.config.toolButtonPlacement || 'top'">
                            <el-button class="el-icon-refresh"></el-button>
                        </el-tooltip>
                        <el-tooltip :effect="state.config.toolButtonEffect || 'dark'" content="自定义表头" :placement="state.config.toolButtonPlacement || 'top'">
                            <el-button class="el-icon-film"></el-button>
                        </el-tooltip>
                        <el-tooltip :effect="state.config.toolButtonEffect || 'dark'" content="导出数据" :placement="state.config.toolButtonPlacement || 'top'">
                            <el-button class="el-icon-printer"></el-button>
                        </el-tooltip>
                    </el-button-group>
                </div>
            </div>
            <!-- 表格 -->
            <div class="crud-table-body_box">
                <el-table :data="state.tableData" 
                        :height="state.config.height || '100%'"
                        :max-height="state.config.maxHeight"
                        :stripe="state.config.stripe"
                        :border="state.config.border || true"
                        :size="state.config.size"
                        :fit="state.config.fit"
                        :show-header="state.config.showheader"
                        :highlight-current-row="state.config.highlightCurrentRow"
                        :current-row-key="state.config.currentRowKey"
                        :row-class-name="state.config.rowClassName"
                        :row-style="state.config.rowStyle"
                        :cell-class-name="state.config.cellClassName"
                        :cell-style="state.config.cellStyle"
                        :header-row-class-name="state.config.headerRowClassName"
                        :header-row-style="state.config.headerRowStyle"
                        :header-cell-class-name="state.config.headerCellClassName"
                        :header-cell-style="state.config.headerCellStyle"
                        :row-key="state.config.rowKey"
                        :empty-text="state.config.emptyText"
                        :default-expand-all="state.config.defaultExpandAll"
                        :default-sort="state.config.defaultSort"
                        :tooltip-effect="state.config.tooltipEffect"
                        :tooltip="state.config.tooltip"
                        :show-summary="state.config.showSummary"
                        :sum-text="state.config.sumText"
                        :summary-method="state.config.summaryMethod"
                        :span-method="state.config.spanMethod"
                        :select-on-indeterminate="state.config.selectOnIndeterminate"
                        :indent="state.config.indent"
                        :lazy="state.config.lazy"
                        :load="state.config.load"
                        :tree-props="state.config.treeProps"
                        @select="select"
                        @select-all="selectAll"
                        @selection-change="selectionChange"
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
                            <el-button :size="state.config.size" @click="editRow(row)" type="primary">
                                编辑
                            </el-button>
                            <el-button :size="state.config.size" @click="deleteRow(row)" type="danger">
                                删除
                            </el-button>
                        </template>
                    </el-table-column>
                </el-table>
            </div>
            <!-- 表格下方 -->
            <div class="crud-table-body_bottom">
                <div>
                    <div class="crud-table-body_bottom_tip" v-if="state.multipleSelection.length">
                        <div :style="{
                            fontSize: tipFontSize
                        }">当前表格已选择：{{state.multipleSelection.length}}条</div>
                        <el-button type="text" 
                                   style="margin-left: 10px; margin-top: 2px" 
                                   :size="state.config.size"
                                   @click="clearSelected">清空</el-button>
                    </div>
                </div>
                <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="state.pageInfo.page"
                    :small="state.config.size == 'small'"
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
import { reactive, ref, computed  } from "vue"
import JustCrudSearch from "./JustCrudSearch.vue"
const theme = {
    color: 'blue',
    tableHeaderBackground: '#fafafa'
}


const props = defineProps({
    config: Object,
    data: Array
})

const state = reactive({
    config: {},
    columns: [],
    tableData: [],
    total: 0,
    pageInfo: {
        page: 1,
        size: 10
    },
    multipleSelection: [],
    searchParams: {},
    searchOptions: []
})

const tipFontSize = computed( () => {
    if ( state.config.size == 'small' ) return '13px'
    return '14px'
})

const tableRef = ref(null)
state.config = props.config
const columnsFormat = props.config.columns.map( el => {
    if ( el.type == 'select' ) {
        let keyConfig = el.optionProps || { label: 'label', value: 'value' }
        el.options = el.options.map( i => {
            return {
                label: i[keyConfig.label],
                value: i[keyConfig.value],
            }
        })
    }
    return el
})


state.columns = columnsFormat
state.tableData = props.data
state.total = props.config.total
state.pageInfo = props.config.pageInfo
theme.tableHeaderBackground = props.config.tableHeaderBackground || '#fafafa'
state.searchOptions = state.columns.filter( el => el.search)

console.log(state.searchOptions)

const handleSizeChange = ( value ) => {
    state.pageInfo.size = value
}

const handleCurrentChange = ( value ) => {
    state.pageInfo.page = value
}

const handleSubmit = ( value ) => {
    console.log(value)
}

const handleReset = () => {
    state.searchParams = {}
}

const clearSelected = () => {
    state.multipleSelection = []
    tableRef.value.clearSelection()
    emit('clear-selected')
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
    'expand-change',
    'selection-change',
    'clear-selected'
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
const selectionChange = ( ...arguement ) => {
    emit('selection-change', ...arguement)
    state.multipleSelection = [...arguement][0]
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
    @import url(./just-crud.less);
</style>
<style lang="less">
.crud-table .el-table__header-wrapper tr .el-table__cell {
    background-color: v-bind('theme.tableHeaderBackground')!important;
}
</style>
