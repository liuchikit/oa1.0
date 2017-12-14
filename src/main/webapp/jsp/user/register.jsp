<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2017/12/6
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/jsp/index.jsp"%>
<section class="content-header">
    <h1>
        新增用户
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 用户管理</a></li>
        <li class="active">新增用户</li>
    </ol>
</section>
<!-- Main content -->
<section class="content">
    <div class="col-lg-4">
        <div class="box">
            <div class="box-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <div class="col-md-2 ">
                            <label for="" class="control-label pull-right">账户</label>
                        </div>
                        <div class="col-md-10">
                            <input class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-2">
                            <label class="control-label pull-right">姓名</label>
                        </div>
                        <div class="col-md-10">
                            <input class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-2">
                            <label class="control-label pull-right">密码</label>
                        </div>
                        <div class="col-md-10">
                            <input class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-2">
                            <label class="control-label pull-right">邮箱</label>
                        </div>
                        <div class="col-md-10">
                            <input class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-2">
                            <label class="control-label pull-right">手机号码</label>
                        </div>
                        <div class="col-md-10">
                            <input class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-2">
                            <label class="control-label pull-right">生日</label>
                        </div>
                        <div class="col-md-10">
                            <input class="form-control">
                        </div>
                    </div>
                    <div class="form-group ">
                        <button type="button" class="btn-info center-block">添加</button>
                    </div>

                </form>

            </div>
        </div>
    </div>

</section>
