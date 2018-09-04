<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="row">
        <div class="col-xs-12">
            <div class="form-group">
                <label for="type">类型 :</label>
                <select name="type" id="type" class="form-control">
                    <option value="">选择Code类型</option>
                    <c:if test="${not empty codeTypeList}">
                        <c:forEach items="${codeTypeList}" var="codeType">
                            <option value="${codeType}">${codeType}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <div id="codeTable" class="table table-striped table-hover"></div>
        </div>
    </div>

    <script>
        $(function () {
           initBootstrapTable();
        });

        $("#type").on("change", function () {
            $("#codeTable").bootstrapTable("refresh");
        });

        function queryParams(params) {
            return {
                pageSize: params.limit,
                pageIndex: params.offset / params.limit,
                type: $("#type").val()
            };
        }

        var serialNo = 1;
        function initBootstrapTable() {
            $("#codeTable").bootstrapTable({
                url: url,
                method: 'POST',
                dataType: 'json',
                contentType: "application/x-www-form-urlencoded",
                cache: false,
                sidePagination: "server",
                pagination: true,
                queryParams: queryParams,
                pageNumber: 1,
                pageSize: 10,
                pageList: [10],
                uniqueId: "referenceNo",
                cellStyle: function (value, row, index, field) {
                    return {
                        css: {'word-wrap': 'break-word', 'word-break': 'break-all'}
                    }
                },
                columns: [
                    {
                        field : '',
                        title : '#',
                        align : 'center',
                        valign : 'middle',
                        formatter: function (value, row, index) {
                            return serialNo++;
                        }
                    },
                    {
                        field : 'type',
                        title : '类型',
                        align : 'center',
                        valign : 'middle'
                    },
                    {
                        field : 'name',
                        title : '常量名',
                        align : 'center',
                        valign : 'middle'
                    },
                    {
                        field : 'value',
                        title : '值',
                        align : 'center',
                        valign : 'middle'
                    },
                    {
                        field : 'description',
                        title : '描述',
                        align : 'center',
                        valign : 'middle'
                    },
                    {
                        field : 'createBy',
                        title : '创建者',
                        align : 'center',
                        valign : 'middle'
                    },
                    {
                        field : 'createDate',
                        title : '创建时间',
                        align : 'center',
                        valign : 'middle'
                    },
                    {
                        field : '',
                        title : '操作',
                        align : 'center',
                        valign : 'middle',
                        formatter: function (value, row, index) {
                            return '<i class="fa fa-remove"></i>';
                        }
                    }
                ]
            });
        }
    </script>

</body>
</html>
