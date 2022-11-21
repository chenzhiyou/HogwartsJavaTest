<%@ page import="com.tuling.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tuling.domain.Fruit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8" />
  <title></title>
  <link rel="stylesheet" type="text/css" href="static/css/BSindex.css"/>
  <link rel="stylesheet" type="text/css" href="static/css/main.css"/>
  <script src="static/js/BSindex.js" type="text/javascript" charset="utf-8"></script>
  <%
    String show="x0";
    if(request.getAttribute("sky")!=null)
      show=(String)request.getAttribute("sky");
  %>
</head>
<body >
<div class="mean">
  <div class="logo">
    <a href="index.jsp"><img src="static/img/alogo.png" alt="" /></a>
  </div>

  <div class="mean_ul">
    <div class="mean_li" onclick="sss('u')">用户管理</div>
    <div class="user_list" id="user_list">
      <div class="mm"><a href="<%=request.getContextPath()%>/BSServlet?method=alluser">全部用户</a></div>
      <div class="mm"><a href="addUser.jsp">添加用户</a></div>
    </div>
    <div class="mean_li" onclick="sss('f')">商品管理</div>
    <div class="fruit_list" id="fruit_list">
      <div class="mm"><a href="<%=request.getContextPath()%>/BSServlet?method=allfruit">库存水果</a></div>
      <div class="mm"><a href="<%=request.getContextPath()%>/BSServlet?method=hotfruit">热卖水果</a></div>
      <div class="mm"><a href="addFruit.jsp">水果入库</a></div>
    </div>
  </div>

</div>


<div class="gong" id="x4">
  <div class="con">
    <div class="tit">
      <ul>
        <li>水果</li>
        <li class="i">&nbsp;</li>
        <li>规格</li>
        <li class="i">&nbsp;</li>
        <li>单价</li>
        <li class="i">&nbsp;</li>
        <li>操作</li>
      </ul>
    </div>
    <%
      List<Fruit> fruits=new ArrayList<Fruit>();
      if(request.getAttribute("allfruit")!=null) {

        fruits = (List<Fruit>) request.getAttribute("allfruit");

        for(Fruit fruit:fruits) {
          out.print("    <div class=\"info\">\n" +
                  "      <ul>\n" +
                  "        <li><a href=\""+request.getContextPath()+"/BSServlet?method=findfruit&fid="+fruit.getFid()+"\">"+fruit.getFname()+"</a></li>\n" +
                  "        <li class=\"i\">&nbsp;</li>\n" +
                  "        <li><a href=\""+request.getContextPath()+"/BSServlet?method=findfruit&fid="+fruit.getFid()+"\">"+fruit.getSpec()+"</a></li>\n" +
                  "        <li class=\"i\">&nbsp;</li>\n" +
                  "        <li><a href=\""+request.getContextPath()+"/BSServlet?method=findfruit&fid="+fruit.getFid()+"\">"+fruit.getUp()+"</a></li>\n" +
                  "        <li class=\"i\">&nbsp;</li>\n" +
                  "        <li><a href=\""+request.getContextPath()+"/BSServlet?method=delfruit&fid="+fruit.getFid()+"\">删除</a></li>\n" +
                  "      </ul>\n" +
                  "    </div>");
        }
      }
    %>


  </div>
</div>


</body>
</html>
