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
                    <form role="form" method="post" action="/sell/seller/product/save">


                        <input type="hidden" name="productId" class="form-control"
                               value="${(productInfo.productId)!""}">

                        <div class="form-group">
                            <label>名称</label>
                            <input name="productName" type="text" class="form-control"
                                   value="${(productInfo.productName)!""}"/>
                        </div>
                        <div class="form-group">
                            <label>价格</label>
                            <input name="productPrice" type="text" class="form-control"
                                   value="${(productInfo.productPrice)!""}"/>
                        </div>
                        <div class="form-group">
                            <label>库存</label>
                            <input name="productStock" type="text" class="form-control"
                                   value="${(productInfo.productStock)!""}"/>
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input name="productDescription" type="text" class="form-control"
                                   value="${(productInfo.productDescription)!""}"/>
                        </div>
                        <div class="form-group">
                            <label>图片</label>
                            <img height="150px" width="150px" src="${(productInfo.productIcon)!""}" alt=""/>
                            <input name="productIcon" type="text" class="form-control"
                                   value="${(productInfo.productIcon)!""}"/>
                        </div>
                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryType" class="form-control">
                                <#list categoryList as category>
                                    <option value="${category.categoryType}"
                                        <#if (productInfo.categoryType)?? && (productInfo.categoryType == category.categoryType)>
                                            selected
                                        </#if>
                                    >${ category.categoryName}
                                    </option>
                                </#list>
                            </select>
                        </div>
                        <#if (productInfo.createTime)??>
                        <div class="form-group">
                            <label>创建时间：</label>
                            <span>  ${productInfo.createTime}</span>
                        </div>
                        </#if>
                        <#if (productInfo.updateTime)??>
                        <div class="form-group">
                            <label>修改时间：</label>
                            <span>  ${productInfo.updateTime}</span>
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

