<%--
  Created by IntelliJ IDEA.
  User: yanyanghong
  Date: 2018/8/30
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Code</title>
</head>
<body>

    <div class="row">
        <div class="col-xs-12">
            <div class="page-header-title">Code</div>
        </div>
    </div>
    <div class="row form-inline">
        <div class="col-xs-12">
            <div class="form-group">
                <label for="type">类型 :</label>
                <input type="text" name="type" id="type" class="form-control" placeholder="选择类型" />
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <div id="codeTable" class="table table-striped table-hover">

            </div>
        </div>
    </div>

</body>
</html>
