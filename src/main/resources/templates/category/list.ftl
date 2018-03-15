<!doctype html>
<html lang="en">
<#include  "../common/header.ftl">
<title>卖家后端管理系统</title>
</head>
<body>
<div id="wrapper" class="toggled">
<#--边栏-->
    <#include "../common/nav.ftl">
<#--主要内容区域-->
    <div id="page-content-wrapper">
        <div class="container">
            <div class="row clearfix">
            <#--列表循环-->
                <div class="col-md-12 column">
                    <table class="table table-hover table-bordered">
                        <thead>
                        <tr>
                            <th>类目ID</th>
                            <th>名称</th>
                            <th>type</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th >操作</th>
                        </tr>
                        </thead>
                        <tbody>
                <#list categoryList as category>
                <tr>
                    <td>${category.categoryId}</td>
                    <td>${category.categoryName}</td>
                    <td>${category.categoryType}</td>
                    <td>${category.createTime}</td>
                    <td>${category.updateTime}</td>
                    <td><a href="/sell/seller/category/index?categoryId=${category.categoryId}">修改</a></td>
                </tr>
                </#list>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
<#--分页查询-->
</div>
</body>
</html>

