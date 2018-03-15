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
                            <th>订单ID</th>
                            <th>姓名</th>
                            <th>手机号</th>
                            <th>地址</th>
                            <th>金额</th>
                            <th>订单状态</th>
                            <th>支付状态</th>
                            <th>创建时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                <#list orderDTOPage.content as orderDTO>
                <tr>
                    <td>${orderDTO.orderId}</td>
                    <td>${orderDTO.buyerName}</td>
                    <td>${orderDTO.buyerPhone}</td>
                    <td>${orderDTO.buyerAddress}</td>
                    <td>${orderDTO.orderAmount}</td>
                    <td>${orderDTO.getOrderStatusEnum(orderDTO.orderStatus).getMsg()}</td>
                    <td>${orderDTO.getPayStatusEnum(orderDTO.payStatus).getMsg()}</td>
                    <td>${orderDTO.createTime}</td>
                    <td><a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}">详情</a></td>
                    <#if orderDTO.getOrderStatusEnum(orderDTO.orderStatus).getMsg() == "已取消">
                     <td class="disabled">已取消</td>
                    <#elseif orderDTO.getOrderStatusEnum(orderDTO.orderStatus).getMsg()== "已完结">
                     <td class="disabled">已完结</td>
                    <#else >
                    <td><a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a></td>
                    </#if>

                </tr>
                </#list>
                        </tbody>
                    </table>
                </div>
            <#--分页查询-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                <#if  currentPage lte 1>
                    <li class="disabled"><a href="#">上一页</a></li>
                <#else>
                     <li><a href="/sell/seller/order/list?page=${currentPage-1}&size=${currentSize}">上一页</a></li>
                </#if>
               <#list 1..orderDTOPage.getTotalPages() as index>
                   <#if (index lte 5 || index-5 gte 5) && currentPage == index>
                            <li class="disabled"><a href="/sell/seller/order/list?page=${index}&size=${currentSize}">${index}</a></li>
                   <#elseif (index lte 5 || index-5 gte 5) && currentPage != index>
                            <li><a href="/sell/seller/order/list?page=${index}&size=${currentSize}">${index}</a></li>
                   <#elseif index == 6 >
                    <li class="disabled"><a href="">...</a></li>
                   <#else >
                   </#if>
               </#list>
                <#if currentPage gte orderDTOPage.getTotalPages() >
                    <li class="disabled"><a href="#">下一页</a></li>
                <#else >
                    <li><a href="/sell/seller/order/list?page=${currentPage+1}&size=${currentSize}">下一页</a></li>
                </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/ecmascript-6">
    let webSocket = null;
    if ('WebSocket' in window){
            ws =  new WebSocket('ws://')
    }else {
        alert('该浏览器不支持webSocket')；
    }

    ws.onopen = function () {
        console.log("建立连接");
    }

    ws.onclose = function () {
        console.log("关闭连接");
    }

    ws.onmessage = function (even) {
        console.log("收到消息：" + even.data);
        //弹窗提醒
        //播放音乐
    }
    
    ws.onerror = function () {
        alert("webSocket发生错误");
    }

    window.onbeforeunload  = function () {
        ws.close();
    }
</script>
</body>
</html>

