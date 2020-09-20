<%@ page import="java.net.URLDecoder" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
    <script>
        $(document).ready(function () {
           $("#btn").click(function () {
               $("#d1").toggle(1500);
           });
        });
    </script>
</head>
<body>
<div id="d1">
    <img src="jquery/deng.jpg">
</div><br>
<button id="btn" >切换</button>
<table>
    <tr></tr>
</table>
<input type="checkbox">
</body>
</html>
