<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="page" value="${pageContext.request.contextPath}" scope="application" />
<!-- Required meta tags -->
<meta charset="utf-8">


<script>
    head = "";
    baseUrl = "";
</script>




<%--AdminLTE start--%>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="${page}/static/adminLTE/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="${page}/static/adminLTE/fontawesome/css/font-awesome.css">

<!-- Ionicons -->
<link rel="stylesheet" href="${page}/static/adminLTE/ionicons/css/ionicons.css">
<!-- Theme style -->
<link rel="stylesheet" href="${page}/static/adminLTE/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. We have chosen the skin-blue for this starter
      page. However, you can choose any other skin. Make sure you
      apply the skin class to the body tag so the changes take effect.
-->
<link rel="stylesheet" href="${page}/static/adminLTE/dist/css/skins/skin-blue.min.css"><!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.2.3 -->
<script src="${page}/static/adminLTE/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${page}/static/adminLTE/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="${page}/static/adminLTE/dist/js/app.min.js"></script>

<%--AdminLTE end--%>

<%--AdminLTE datatable start--%>
<%--<script type="text/javascript" language="javascript" src="${page}/static/datatables/bootstrapStyle/jquery.dataTables.min.js"></script>--%>
<script type="text/javascript" language="javascript" src="${page}/static/datatables/jquery.dataTables.js"></script>
<script type="text/javascript" language="javascript" src="${page}/static/datatables/bootstrapStyle/dataTables.bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="${page}/static/datatables/bootstrapStyle/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${page}/static/datatables/bootstrapStyle/dataTables.bootstrap.css">
<%--AdminLTE datatable end--%>

<%--<script type="text/javascript" language="javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" language="javascript" src="http://cdn.datatables.net/1.10-dev/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript" src="http://cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.css">--%>


<%-- layer start 必须先引入jquery --%>
<script src="${page}/static/layer-v3.1.1/layer/layer.js"></script>
<%-- layer end --%>

<%--base.js--%>
<script src="${page}/static/js/base.js"></script>

<%--treeview--%>
<script src="${page}/static/thirdpart/bootstrap-treeview.js"></script>