/*
*   自己封装的js文件
*/
function jQuery(selector){
    if (typeof selector == "string") {
        if (selector.charAt(0) == "#") {
            obj=document.getElementById(selector.substring(1));
            return new jQuery()
        }
    }
    if (typeof selector == "function") {
        window.onload=selector
    }
    this.val=function (v){
        if (v == undefined) {
            return obj.value;
        }else{
            obj.value=v
        }
    }
    this.html=function (htmlStr){
        obj.innerHTML=htmlStr
    }
    this.click=function (fun){
        obj.onclick=fun;
    }
    this.focus=function (fun){
        obj.onfocus=fun;
    }
    this.blur=function (fun){
        obj.onblur=fun;
    }
    this.change=function (fun){
        obj.onchange=fun;
    }
    /**
     * 分析：使用ajax函数发送ajax请求的时候，需要程序员给我们传递过来什么？
     *      请求的方式（type）：GET/POST
     *      请求的URL（url）：url
     *      请求提交的数据（data）：data
     *      请求发送异步还是同步（async）：true表示异步，false表示同步
     *      这些需要传递的参数，我们可以在前端页面调用ajax函数的时候形参采用json对象的方式传给js文件
     */
    //jsonArgs:json对象
    //ajax:静态函数
    jQuery.ajax=function (jsonArgs){
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange=function () {
            if (this.readyState == 4) {
                if (this.status == 200) {
                    //这个工具类在封装的时候先不管这么多，假设服务器端传回来的都是具有json格式的字符串，然后转换为json对象
                    var jsonObj=JSON.parse(this.responseText)
                    //将json对象传给前端，前端可以访问json对象的属性
                    jsonArgs.success(jsonObj)
                }
            }
        }
        //如果是post请求，通过post的方式发送ajax请求，如果是get请求，通过get方式发送ajax请求
        //toUpperCase()：全部转为大写
        if (jsonArgs.type.toUpperCase() == "POST") {
            xhr.open(jsonArgs.type,jsonArgs.url,jsonArgs.async)
            xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
            xhr.send(jsonArgs.data)
        }
        if (jsonArgs.type.toUpperCase() == "GET") {
            xhr.open(jsonArgs.type,jsonArgs.url+"?"+jsonArgs.data,jsonArgs.async)
            xhr.send()
        }

    }
}
$=jQuery
//必须创建对象，ajax静态方法才能执行
new jQuery()