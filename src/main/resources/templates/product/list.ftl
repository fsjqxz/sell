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
                            <th>商品ID</th>
                            <th>名称</th>
                            <th>图片</th>
                            <th>单价</th>
                            <th>库存</th>
                            <th>描述</th>
                            <th>类目</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                <#list productInfos.content as productInfo>
                <tr>
                    <td>${productInfo.productId}</td>
                    <td>${productInfo.productName}</td>
                    <td><img height="100" width="100" src="${productInfo.productIcon}" alt=""></td>
                    <td>${productInfo.productPrice}</td>
                    <td>${productInfo.productStock}</td>
                    <td>${productInfo.productDescription}</td>
                    <td>${productInfo.categoryType}</td>
                    <td><a href="/sell/seller/product/index?productId=${productInfo.productId}">修改</a></td>
                    <td>
                        <#if productInfo.getProductStatusEnum().msg == "上架">
                            <a href="/sell/seller/product/off_sale?productId=${productInfo.productId}">下架</a>
                            <#else >
                             <a href="/sell/seller/product/on_sale?productId=${productInfo.productId}">上架</a>
                        </#if>
                    </td>
                </tr>
                </#list>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
    <#--分页查询-->
    <div class="col-md-12 column">
            <ul class="pagination pull-right">
                <#if  currentPage lte 1>
                    <li class="disabled"><a href="#">上一页</a></li>
                <#else>
                     <li><a href="/sell/seller/product/list?page=${currentPage-1}&size=${currentSize}">上一页</a></li>
                </#if>
               <#list 1..productInfos.getTotalPages() as index>
                   <#if (index lte 5 || index-5 gte 5) && currentPage == index>
                            <li class="disabled"><a href="/sell/seller/product/list?page=${index}&size=${currentSize}">${index}</a></li>
                   <#elseif (index lte 5 || index-5 gte 5) && currentPage != index>
                            <li><a href="/sell/seller/product/list?page=${index}&size=${currentSize}">${index}</a></li>
                   <#elseif index == 6 >
                    <li class="disabled"><a href="">...</a></li>
                   <#else >
                   </#if>
               </#list>
                <#if currentPage gte productInfos.getTotalPages() >
                    <li class="disabled"><a href="#">下一页</a></li>
                <#else >
                    <li><a href="/sell/seller/product/list?page=${currentPage+1}&size=${currentSize}">下一页</a></li>
                </#if>
            </ul>
        </div>
</div>
</body>
</html>

