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
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/category/save">
                        <input type="hidden" name="categoryId" class="form-control"
                               value="${(category.categoryId)!""}">

                        <div class="form-group">
                            <label>名称</label>
                            <input name="categoryName" type="text" class="form-control"
                                   value="${(category.categoryName)!""}"/>
                        </div>
                        <div class="form-group">
                            <label>类型</label>
                            <input name="categoryType" type="text" class="form-control"
                                   value="${(category.categoryType)!""}"/>
                        </div>
                        <#if (category.createTime)??>
                        <div class="form-group">
                            <label>创建时间：</label>
                            <span>  ${category.createTime}</span>
                        </div>
                        </#if>
                        <#if (category.updateTime)??>
                        <div class="form-group">
                            <label>修改时间：</label>
                            <span>  ${category.updateTime}</span>
                        </div>
                        </#if>
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

