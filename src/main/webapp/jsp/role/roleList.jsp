<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2017/12/8
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/jsp/index.jsp"%>
<section id="roleListPage">
    <div    >
        <div class="box">
            <div class="box-header col-md-12">
                <form id="queryForm" class="form-horizontal">
                    <div class="row">
                        <div class="form-group col-md-2">
                            <div class="col-md-5">
                                <label for="" class="control-label pull-right">角色名称</label>
                            </div>
                            <div class="col-md-7">
                                <input name="roleName" class="form-control">
                            </div>
                        </div>
                        <div class="form-group col-md-2">
                            <div class="col-md-5">
                                <label for="" class="control-label pull-right">角色编码</label>
                            </div>
                            <div class="col-md-7">
                                <input name="roleCode" class="form-control">
                            </div>
                        </div>
                        <div class="form-group col-md-2">
                            <a href="#" name="queryBtn" class="btn btn-success">搜索</a>
                            <a href="#" name="addBtn" class="btn btn-success">新增</a>
                        </div>
                    </div>

                </form>
            </div>
            <div class="box-body">
                <table id="roleListTable" class="table table-striped table-bordered" cellspacing="0" width="100%"></table>
            </div>
        </div>

    </div>

    <script type="text/html" class="btn-div">
        <div class="pull-left">
            <div class="inline">
                <div class="btn-group">
                    <button  name="updateBtn"  class="btn btn-success" title="编辑">编辑</button>
                    <button  name="relateRightBtn"  class="btn btn-success" title="分配权限">分配权限</button>
                    <button  name="relateUserBtn"  class="btn btn-success" title="关联用户">关联用户</button>
                </div>

            </div>
        </div>
    </script>

    <script id="saveOrUpdateDiv" type="text/html" class="btn-div">
        <section class="content">
            <div class="box">
                <div class="box-body col-md-12">
                    <form id="saveOrUpdateForm" >
                        <input type="hidden" name="id">
                        <div class="row">
                            <div class="form-group">
                                <label for="" class="control-label">角色名称</label>
                                <input name="roleName" class="form-control">
                            </div>
                            <div class="form-group ">
                                <label for="" class="control-label">角色编码</label>
                                <input name="roleCode" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="" class="control-label">角色描述</label>
                                <input name="roleDesc" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="" class="control-label">是否有效</label>
                                <input name="status" class="form-control">
                            </div>

                        </div>

                    </form>
                </div>
            </div>
        </section>

    </script>

    <scritp id="relateRightDiv" type="text/html">
        <section class="content">
            <div class="box">
                <div id="rightTree"></div>
            </div>
        </section>
    </scritp>
</section>

<script type="text/javascript" src="/static/js/role/roleList.js"></script>

