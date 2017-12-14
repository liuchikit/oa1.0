<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2017/12/2
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp"%>
<script src="${ctx}/static/js/login.js"></script>
<style>
    #loginDiv{
        margin-top: 10%;
    }
</style>
<div id="loginPage">
    <section class="col-lg-4"></section>
    <section id="loginDiv" class="content col-lg-4">
        <div class="box box-info">
            <div class="box-header">
                <i class="fa "></i>
                <h3 class="box-title">登录</h3>
                <!-- tools box -->
              <%--  <div class="pull-right box-tools">
                    <button type="button" class="btn btn-info btn-sm" data-widget="remove" data-toggle="tooltip"
                            title="Remove">
                        <i class="fa fa-times"></i></button>
                </div>--%>
                <!-- /. tools -->
            </div>
            <div class="box-body">
                <form id="loginForm" action="#" method="post">
                    <div class="form-group">
                        <input class="form-control" name="account" placeholder="账户">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="password" placeholder="密码">
                    </div>
                    <div>
                    </div>
                    <div class="box-footer clearfix">
                        <button type="button" class="pull-right btn btn-default" id="">注册
                            <i class="fa fa-arrow-circle-right"></i></button>
                        <button type="button" class="pull-right btn btn-default" name="loginBtn">登录
                            <i class="fa fa-arrow-circle-right"></i></button>
                    </div>
                </form>
            </div>

        </div>
    </section>
    <section class="col-lg-4"></section>
</div>


