
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询省份</title>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        //使用jQuery
        //页面加载完毕执行
        $(function (){
            //按钮绑定点击事件
            $("#btn").click(function (){
                //发送ajax请求
                $.ajax({
                    url:"/jQuery/provinceServlet",
                    type:"get",
                    dataType:"json",
                    success:function (json) {
                        //清空select列表，避免每一次刷新都会重复增加一次数据
                        $("#province").empty();
                        //遍历json数组
                        $.each(json,function(i,n){
                            //将子串添加到select标签内，页面上展示
                            $("#province").append("<option value='"+n.id+"'>"+n.name+"</option>")
                        })

                    }
                })
            })
            //给省份的select绑定一个change时间，当select内容发生改变时，触发时间
            $("#province").change(function () {
                //当选定某个省份后，获取select下的子标签option的value值，这个value就是这个省份的id，也是城市的provinceId
                var provinceId=$("select>option:selected").val();
                //做一个ajax请求，获取省份的所有城市信息
                //可以使用$(ajax)发送post或get方式，也可以使用jQuery库中的$.post
                $.post("cityServlet",{provinceId:provinceId},function (cityJson) {
                    //清空select列表，避免每一次刷新都会重复增加一次数据
                    $("#city").empty();
                    $.each(cityJson,function (i,n) {
                        $("#city").append("<option value='"+n.id+"'>"+n.name+"</option>")
                    })
                },"json")

            })
        })
    </script>
</head>
<body>
    <table border="solid" >
        <tr>
            <th>省份</th>
            <td>
                <select id="province">
                    <option value="0">下拉选择....</option>
                </select>
            </td>
            <td>
                <input type="button" id="btn" value="onload数据"/>
            </td>
        </tr>
        <tr>
            <th>城市</th>
            <td>
                <select id="city">
                    <option value="0">下拉显示...</option>
                </select>
            </td>
        </tr>
    </table>
</body>
</html>
