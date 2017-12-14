<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2017/12/7
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/jsp/index.jsp"%>
<section id="rightListPage">
    <div class="col-lg-3 content">
        <div id="rightTree"></div>
    </div>
    <div class="col-lg-3 content">
        <div class="box box-primary">
            <div class="box-header">
                <h3 class="box-title">选中节点</h3>
            </div>
            <div class="box-body">
                <form id="saveOrUpdateForm" class="form-horizontal">
                    <div class="form-group">
                        <div class="col-md-3 ">
                            <label for="" class="control-label pull-right">权限ID</label>
                        </div>
                        <div class="col-md-9">
                            <input name="id" class="form-control" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3">
                            <label class="control-label pull-right">父权限ID</label>
                        </div>
                        <div class="col-md-9">
                            <input name="pid" class="form-control" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3">
                            <label for="" class="control-label pull-right">权限名称</label>
                        </div>
                        <div class="col-md-9">
                            <input name="rightName" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3">
                            <label class="control-label pull-right">权限类型</label>
                        </div>
                        <div class="col-md-9">
                            <input type="radio" value="1" name="rightType"><span>菜单</span>
                            &nbsp;
                            <input type="radio" value="2" name="rightType"><span>按钮</span>

                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3">
                            <label class="control-label pull-right">权限编码</label>
                        </div>
                        <div class="col-md-9">
                            <input name="rightCode" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3">
                            <label class="control-label pull-right">权限描述</label>
                        </div>
                        <div class="col-md-9">
                            <input name="rightDesc" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3">
                            <label class="control-label pull-right">层级</label>
                        </div>
                        <div class="col-md-9">
                            <input name="level" class="form-control" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3">
                            <label class="control-label pull-right">排序</label>
                        </div>
                        <div class="col-md-9">
                            <input name="sort" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3">
                            <label class="control-label pull-right">是否有效</label>
                        </div>
                        <div class="col-md-9">
                            <input name="status" class="form-control">
                        </div>
                    </div>
                    <div class="form-group ">
                        <div class="row">
                            <div class="pull-right">
                                <a name="addBtn" class="btn btn-success">保存</a>
                                <a name="addSubRightBtn" class="btn btn-success">添加子节点</a>
                            </div>
                        </div>

                    </div>
                </form>
            </div>
        </div>
    </div>

    <div id="subRightDiv" class="col-lg-3 content">
    </div>

    <script id="subRightDivScript" type="text/html">
        <div class="box box-primary">
            <div class="box-header">
                <h3 class="box-title">子节点</h3>
            </div>
            <div class="box-body">
                <form id="subForm" class="form-horizontal">
                    <div class="form-group">
                        <div class="col-md-3 ">
                            <label for="" class="control-label pull-right">权限ID</label>
                        </div>
                        <div class="col-md-9">
                            <input name="id" class="form-control" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3">
                            <label class="control-label pull-right">父权限ID</label>
                        </div>
                        <div class="col-md-9">
                            <input name="pid" class="form-control" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3">
                            <label for="" class="control-label pull-right">权限名称</label>
                        </div>
                        <div class="col-md-9">
                            <input name="rightName" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3">
                            <label name="rightType" class="control-label pull-right">权限类型</label>
                        </div>
                        <div class="col-md-9">
                            <input type="radio" value="1" name="rightType"><span>菜单</span>
                            &nbsp;
                            <input type="radio" value="2" name="rightType"><span>按钮</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3">
                            <label class="control-label pull-right">权限编码</label>
                        </div>
                        <div class="col-md-9">
                            <input name="rightCode" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3">
                            <label class="control-label pull-right">权限描述</label>
                        </div>
                        <div class="col-md-9">
                            <input name="rightDesc" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3">
                            <label class="control-label pull-right">层级</label>
                        </div>
                        <div class="col-md-9">
                            <input name="level" class="form-control" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3">
                            <label class="control-label pull-right">排序</label>
                        </div>
                        <div class="col-md-9">
                            <input name="sort" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3">
                            <label class="control-label pull-right">是否有效</label>
                        </div>
                        <div class="col-md-9">
                            <input name="status" class="form-control">
                        </div>
                    </div>
                    <div class="form-group ">
                        <div class="row">
                            <div class="pull-right">
                                <a name="addBtn" class="btn btn-success">保存</a>
                            </div>
                        </div>

                    </div>
                </form>
            </div>
        </div>
    </script>



</section>

<script type="text/javascript" src="/static/js/right/rightList.js"></script>


