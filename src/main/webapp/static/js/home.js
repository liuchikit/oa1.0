$(function () {
    homePage().init();
});
var homePage = function () {
    var page = $("#homePage");
    var tabDiv = page.find("#tabDiv");
    var tabContentDiv = page.find("#tabContentDiv");

    /**
     * 增加标签页
     */
    function addTab(options) {
        //option:
        //tabMainName:tab标签页所在的容器
        //tabName:当前tab的名称
        //tabTitle:当前tab的标题
        //tabUrl:当前tab所指向的URL地址
        var exists = checkTabIsExists(options.tabMainName, options.tabName);
        if(exists){
            $("#tab_a_"+options.tabName).click();
        } else {
            $("#"+options.tabMainName).append('<li id="tab_li_'+options.tabName+'"><a href="#tab_content_'+options.tabName+'" data-toggle="tab" id="tab_a_'+options.tabName+'"><button class="close closeTab" type="button" onclick="closeTab(this);">×</button>'+options.tabTitle+'</a></li>');

            //固定TAB中IFRAME高度
            mainHeight = $(document.body).height() - 5;

            var content = '';
            if(options.content){
                content = option.content;
            } else {
                content = '<iframe src="' + options.tabUrl + '" width="100%" height="'+mainHeight+'px" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="yes" allowtransparency="yes"></iframe>';
            }
            $("#"+options.tabContentMainName).append('<div id="tab_content_'+options.tabName+'" role="tabpanel" class="tab-pane" id="'+options.tabName+'">'+content+'</div>');
            $("#tab_a_"+options.tabName).click();
        }
    }


    /**
     * 关闭标签页
     * @param button
     */
    function closeTab (button) {

        //通过该button找到对应li标签的id
        var li_id = $(button).parent().parent().attr('id');
        var id = li_id.replace("tab_li_","");

        //如果关闭的是当前激活的TAB，激活他的前一个TAB
        if ($("li.active").attr('id') == li_id) {
            $("li.active").prev().find("a").click();
        }

        //关闭TAB
        $("#" + li_id).remove();
        $("#tab_content_" + id).remove();
    };

    /**
     * 判断是否存在指定的标签页
     * @param tabMainName
     * @param tabName
     * @returns {Boolean}
     */
    function checkTabIsExists(tabContentId){

    }

    return{
        init:function () {
            this.loadMenu();
        },

        /**
         * 加载菜单
         */
        loadMenu:function () {
            var me = this;
            ajaxUtil().get("/sys/right/queryRights","type=2",function (response) {
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
                    var url = data.url;
                    if(url != null){
                        me.addTab(data.id,data.text,data.url);
                    }
                });
            })

        },

        addTab:function (id,text,url) {
            var me = this;
            var tabId = "tab-" + id;
            var tabContentId = "tab-content-" + id;

            //若果tab页已经存在，则直接显示
            if(this.checkTabExist(tabContentId)){
                tabDiv.find("#"+ tabId + "").tab("show");
                return;
            }
            tabDiv.find(".active").removeClass("active");
            var tabTemplate = "<li><a href='#{href}'>#{label}</a> <span class='fa fa-times-circle'></span></li>";
            tabTemplate.replace( /#\{href\}/g,tabContentId).replace( /#\{label\}/g, text );

            if(tabContentDiv.find("#"+ tabContentId +"").length > 0){
                tabContentDiv.find("#"+ tabContentId +"").attr("")
            }

            $.ajax({
                url:url,
                beforeSend:function () {

                },
                success:function (content) {
                    var tab = "<li id=" + tabId + "><a href='#" + tabContentId + "' data-toggle='tab'>" + text + "<i class='fa fa-times'></i></a></li>";
                    tabDiv.append(tab);
                    //添加tab内容
                    var tabContent = "<div id='" + tabContentId + "' class='tab-pane active'>" + content +
                        "</div>";
                    page.find("#tabContentDiv").append(tabContent);

                    //给tab标签注册事件
                    tabDiv.find("i").on("click",function () {
                        var tabId = $(this).parent().parent().attr("id");
                        homePage().closeTab(tabId);
                    })

                    tabDiv.tab("refresh");


                },
                error:function (XMLHttpRequest, textStatus, errorThrown) {

                },
                always:function () {

                }
            });
        },

        /**
         * 关闭tab页
         */
        closeTab:function (tabId) {
            var tabContentId = tabDiv.find("#"+ tabId +"").find("a").attr("href").replace(/#/,"");
            tabDiv.find("#" + tabId + "").remove();
            tabContentDiv.find("#" + tabContentId + "").remove();
        },

        /**
         * 检查tab页是否存在
         * @param tabContentId
         * @returns {boolean}
         */
        checkTabExist:function (tabContentId) {
            return tabContentDiv.find("#" + tabContentId + "").length > 0;
        },

        /**
         * 加载按钮监听器
         */
        loadBtnListener:function () {

        }
        
        

    }
};
