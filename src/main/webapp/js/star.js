"use strict";
window.onload = function() {
    var star = document.getElementById("star");
    var star_li = star.getElementsByTagName("li");
    var star_word = document.getElementById("star_word");
    var result = document.getElementById("result");
    var i = 0;
    var j = 0;
    var len = star_li.length;
    var word = ['很差', '差', '一般', "好", "很好"]
    for (i = 0; i < len; i++) {
        star_li[i].index = i;
        star_li[i].onmouseover = function() {
            star_word.style.display = "block";
            star_word.innerHTML = word[this.index];
            for (i = 0; i <= this.index; i++) {
                star_li[i].className = "act";
            }
        }
        star_li[i].onmouseout = function() {
            star_word.style.display = "none";
            for (i = 0; i < len; i++) {
                star_li[i].className = "";
            }
        }
        star_li[i].onclick = function() {
            result.innerHTML = (this.index + 1) + "分";
            document.getElementById("level").value=(this.index + 1);
        }
    }
}
function testAjax() {
    var name = document.getElementById("name").value;
    if(name==""||name==null){
        alert("error")
    }else{
        alert(name);
    }


    /*var request =new XMLHttpRequest();
     request.onreadystatechange = function () { // 状态发生变化时，函数被回调
     if (request.readyState === 4) { // 成功完成
     // 判断响应结果:
     if (request.status === 200) {
     // 成功，通过responseText拿到响应的文本:
     alert(request.responseText);
     return success(request.responseText);
     } else {
     // 失败，根据响应码判断失败原因:
     return fail(request.status);
     }
     } else {
     // HTTP请求还在继续...
     }
     }
     request.open("GET","/");
     request.send();*/
}