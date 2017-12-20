var roleList = function () {
    var page = systemUtil().getCurrentPage();
    var queryForm = page.find("#queryForm");
    var table = page.find("#roleListTable");
    var datatable;
    var url = "/sys/role";
    var listUrl = "/sys/role/list";

    function fnCreatedRow(rowDom, rowData, rowNum) {
        var me = roleList();
        $(rowDom).on("click", function () {
            console.log(rowData);
        });

        $(rowDom).find("[name='updateBtn']").on("click", function () {
            me.saveOrUpdate(rowData.id);
        });

        $(rowDom).find("[name='relateRightBtn']").on("click", function () {
            me.relateRight(rowData.id);
        });

        $(rowDom).find("[name='relateUserBtn']").on("click", function () {
            me.openRelateRightTab(rowData.id);
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

            page.find("[name='addBtn']").on("click", function () {
                me.saveOrUpdate();
            })

        },



        /**
         * 角色分配权限
         * @param id
         */
        relateRight: function (id) {
            var title = "分配权限";
            layerUtil.open(title, page.find("#relateRightDiv").html(),
                function (layero, index) {
                    if (id != null) {
                        ajaxUtil().get("/sys/right/queryRights", "type=4&roleId=" + id, function (response) {
                            if (response.success) {
                                var treeData = response.data;
                                var tree = layero.find("#rightTree");
                                tree.treeview({
                                    data: treeData,
                                    showBorder: false,
                                    showCheckbox: true,
                                });

                            }
                        });
                    }
                },
                function (index, layero) {
                    var tree = layero.find("#rightTree");
                    var checkedIds = [];

                    var checkedNodes = tree.treeview("getChecked");
                    for (var i in checkedNodes) {
                        checkedIds.push(checkedNodes[i].id);
                    }
                    ajaxUtil().post("/sys/role/relateRights", "roleId=" + id + "&rightIds=" + checkedIds, function (response) {
                        if (response.success) {
                            layerUtil.success(response.msg);
                            layer.close(index);
                        } else {
                            layerUtil.fail(response.msg);
                        }
                    });

                }, {area: ['400px', 'auto'],})
        },

        saveOrUpdate: function (id) {
            var title;
            var method;
            if (id != null) {
                title = "编辑";
                method = "put";
            } else {
                method = "post";
                title = "新增";
            }

            layerUtil.open(title, page.find("#saveOrUpdateDiv").html(),
                function (layero, index) {
                    var form = layero.find("#saveOrUpdateForm");
                    if (id != null) {
                        ajaxUtil().get(url + "/getById", "id=" + id, function (response) {
                            var role = response.data;
                            formUtil().fill(form, role);
                        });
                    }
                },
                function (index, layero) {
                    var form = layero.find("#saveOrUpdateForm");
                    ajaxUtil().saveOrUpdate(url, form.serialize(), method, function (response) {
                        if (response.success) {
                            layerUtil.success(response.msg);
                        } else {
                            layerUtil.fail(response.msg);
                        }
                    });
                }, {area: ['400px', 'auto'],})
        },

        loadTable: function (flag) {
            var me = this;
            var columns = [
                {data: 'id', title: 'ID', visible: false},
                /*  {   title: '序号', data: null, render: function (data, type, row, meta) {
                      return meta.settings._iDisplayStart + meta.row + 1;
                      }
                  },*/
                {data: 'roleName', title: '角色名称'},
                {data: 'roleCode', title: '角色编码'},
                {data: 'roleDesc', title: '角色描述'},
                {data: 'status', title: '是否有效'},
                {
                    title: '操作', width: '250px', data: function () {
                    return page.find(".btn-div").html();
                }
                }
            ];
            if (flag) {
                datatable = tableUtil.load(table, listUrl + "?" + queryForm.serialize(), null, columns,
                    {
                        fnCreatedRow: fnCreatedRow
                    }
                );
            } else {
                tableUtil.reload(datatable, listUrl + "?" + queryForm.serialize());
            }

        },

        openRelateRightTab:function (roleId) {
            var tabData = {"roleId":roleId};
            tabData = JSON.stringify(tabData);
            tabUtil().addTab("111","关联用户","/sys/role/toRelateUserPage",tabData);
        }
    }
}
$(function () {
    roleList().init();
})