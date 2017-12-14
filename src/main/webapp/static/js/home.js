$(function () {
    homePage().init();
});
var homePage = function () {
    var page = $("#homePage");
    return{
        init:function () {
            this.loadMenu();
        },
        loadMenu:function () {ajaxUtil().get("/sys/right/queryMenus",null,function (response) {
            if(response.success){
                var treeData = response.data;
                var tree = page.find("#treeView");
                tree.treeview({
                    color:"white",
                    backColor:"#1E282C",
                    data: treeData,
                    onhoverColor:"#1E282C",
                    showBorder:false,
                });
            }

            tree.on('nodeSelected', function(event, data) {
                console.log(data);
                var url = data.url;
                if(url != null){
                    page.find("#iframe").attr("src",url);
                }
            });
        })

            var defaultData = [
                {
                    text: '系统配置',
                    tags: ['1'],
                    nodes: [
                        {
                            text: '用户管理',
                            url:'',
                            tags: ['2'],

                        },
                        {
                            text: '角色管理',
                            url:'/sys/role/toRoleList',
                            tags: ['0']
                        },
                        {
                            text: '权限管理',
                            url:'/sys/right/toRightList',
                            tags: ['0']
                        }
                    ]
                },
            ];



        },
        loadMenuListener:function () {
            page.find("#treeView").on("click",function () {
                var url = $(this).attr("name");
                if(url != null){
                    page.find("#iframe").attr("src",url);
                }

            })
        },

    }
}
