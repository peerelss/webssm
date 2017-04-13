<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/abc.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/star.css" />

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/star.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/abc.js"></script>
    <title>保存地址到Tumblr</title>
</head>
<body>
    <form class="center" name="input" action="addTumblr" method="post">
        <div>
            <span class="name_tag">name</span>
            <input type="text" size="30" id="name"  name="name" />
            <br />
        </div>
        <div>
            <span class="name_tag">tag</span>
            <input type="text" size="30" id="tag" name="tag" OnInput="checkTag()"/>
            <br />
        </div> level
        <div class="wrapper">
            打分结果
            <span id="result"></span>
            <ul id="star">
                <li>★</li>
                <li>★</li>
                <li>★</li>
                <li>★</li>
                <li>★</li>
            </ul>

        </div>
        <input type="text" size="30" id="level" name="level" />
        <br />
        <input type="submit" value="Submit" />

    </form>

    <div id="para1">
        <input type="submit" value="AJAX" onclick="getAjax()" />
        <div id="test-response-text">
            This is a paragraph.
        </div>
        <h1>This is a heading</h1>
        <input type="submit" value="刷新" onclick="getPrice()" />
    </div>
    <div id="price"></div>
    <div id="star_word">
        一般
    </div>
    <div>
        <th>维护人员：</th>
        <td>
            <select  id="whman" style="width: 152px" class="select_field" name="whman" onchange="setTag(this.options[this.options.selectedIndex].value)">
                <option value="" style="color:#999999">请选择</option>
            </select><font color="red">*</font>
        </td>
    </div>
</body>
</html>