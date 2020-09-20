<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  用户名:<form action="${pageContext.request.contextPath}/servlet2" method="post">
     <input type="text" name="name" >
     <input type="submit" value="提交">
   </form>

  </body>
</html>
