var relateUserPage = function () {
    var page = systemUtil().getCurrentPage();
    var tabData = tabUtil().getTabData();
    var roleId = tabData.roleId;
    var queryForm = page.find("#queryForm");
    var table = page.find("table");
    var datatable;
    var url = "/sys/role";
    var listUrl = "/sys/role/queryRelatedUsers";

    function fnCreatedRow(rowDom, rowData, rowNum) {
        var me = roleList();
        $(rowDom).on("click", function () {
            console.log(rowData);
        });

    };

    return {
        init: function () {
            this.loadTable(true);
            this.loadBtnListener();
        },

        loadBtnListener: function () {
            var me = this;
            queryForm.find("[name='queryBtn']").on("click", function () {
                me.loadTable(false);
            });
            table.find("[name='checkAllBox']").on("change",function () {
                var flag = table.find("[name='checkAllBox']").prop("checked");
                table.find("input[type='checkbox']").prop("checked",flag);
            })
        },

        loadTable: function (flag) {
            var me = this;
            var columns = [
                {title:"<input type='checkbox' name='checkAllBox'/>",data:function (rowData) {
                    return "<input type='checkbox' value='" + rowData.id + "'/>"
                }},
                {data: 'name', title: '用户名称'},
                {data: 'account', title: '用户账号'},

            ];
            if (flag) {
                datatable = tableUtil.load(table, listUrl + "?" + queryForm.serialize() + "&roleId=" + roleId, null, columns,
                    {
                        fnCreatedRow: fnCreatedRow
                    }
                );
            } else {
                tableUtil.reload(datatable, listUrl + "?" + queryForm.serialize() + "&roleId=" + roleId);
            }
        },

    }
}
$(function () {
    relateUserPage().init();
})