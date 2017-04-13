'use strict';
var Sys = {};
var ua = navigator.userAgent.toLowerCase();
var s;
var json;
(s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :
    (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
        (s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :
            (s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :
                (s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;

//以下进行测试
if (Sys.ie) document.write('IE: ' + Sys.ie);
if (Sys.firefox) document.write('Firefox: ' + Sys.firefox);
if (Sys.chrome) document.write('Chrome: ' + Sys.chrome);
if (Sys.opera) document.write('Opera: ' + Sys.opera);
if (Sys.safari) document.write('Safari: ' + Sys.safari);
function refreshPrice(data) {
    var p = document.getElementById('price');
    p.innerHTML = '当前价格：' +
        data['0000001'].name +': ' +
        data['0000001'].price + '；' +
        data['1399001'].name + ': ' +
        data['1399001'].price;
}
function getPrice() {
    var
        js = document.createElement('script'),
        head = document.getElementsByTagName('head')[0];
    js.src = 'http://api.money.126.net/data/feed/0000001,1399001?callback=refreshPrice';
    head.appendChild(js);
}
function success(text) {
    document.getElementById("test-response-text").innerHTML=text;
}

function fail(code) {
    var textarea = document.getElementById('test-response-text');
    textarea.value = 'Error code: ' + code;
}
function toJson(str) {
    return JSON.parse(str);
}
function addSelectList(text) {
    json=JSON.parse(text);
    console.log(json);
    var whman=document.getElementById('whman');
    whman.length=0;
    for(var i=0;i<json.length;i++){
        var opt=new Option(json[i].tag,i);
        whman.options.add(opt);
    }
    /*for(var o in json){
        var opt = new Option(o.tag);
        whman.options.add(opt);
    }*/
    /*for(var i=1990;i<2017;i++){
        var opt = new Option(i*2, i);
        whman.options.add(opt);
    }*/
}
function setTag(s) {
    document.getElementById("tag").value=json[s].tag;
}
function getAjax(){
    var request =new XMLHttpRequest();
    request.onreadystatechange = function () { // 状态发生变化时，函数被回调
        if (request.readyState === 4) { // 成功完成
            // 判断响应结果:
            if (request.status === 200) {
                // 成功，通过responseText拿到响应的文本:
                //  alert(request.responseText);
                return success(request.responseText);
            } else {
                // 失败，根据响应码判断失败原因:
                return fail(request.status);
            }
        } else {
            // HTTP请求还在继续...
        }
    }
    var nameTemp=document.getElementById("name").value;
    var tagTemp=document.getElementById("tag").value;
    var levelTemp=document.getElementById("level").value;

    var urlStr="/addTumblr?name="+nameTemp+"&tag="+tagTemp+"&level="+levelTemp;
    request.open("GET",urlStr);
    request.send();
}

function checkTag() {
    var request =new XMLHttpRequest();
    request.onreadystatechange = function () { // 状态发生变化时，函数被回调
        if (request.readyState === 4) { // 成功完成
            // 判断响应结果:
            if (request.status === 200) {
                // 成功，通过responseText拿到响应的文本:
                //  alert(request.responseText);
                return addSelectList(request.responseText);
            } else {
                // 失败，根据响应码判断失败原因:
                return fail(request.status);
            }
        } else {
            // HTTP请求还在继续...
        }
    }
    var tagTemp=document.getElementById("tag").value;

    var urlStr="../tag/list/"+tagTemp;
    request.open("GET",urlStr);
    request.send();
}