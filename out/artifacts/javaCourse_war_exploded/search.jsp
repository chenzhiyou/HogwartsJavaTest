<%@ page import="com.myfruits.domain.Fruit" %>
<%@ page import="com.myfruits.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>天天果园-水果网购首选品牌，水果，我们只挑有来头的！</title>
    <link rel="stylesheet" type="text/css" href="static/css/sel.css"/>
    <link rel="stylesheet" type="text/css" href="static/css/main.css"/>
    <script src="static/js/sel.js"></script>
    <jsp:include page="/fruitServlet?method=hot"></jsp:include>
    <jsp:include page="static/head/head.jsp"></jsp:include>
  <%
    List<Fruit> hotFruits=(List<Fruit>)request.getAttribute("fruits");
    List<Fruit> selFruits=null;
    User user=new User();
    if(session.getAttribute("user")!=null)
      user=(User)session.getAttribute("user");
    if(request.getAttribute("selFruits")!=null)
      selFruits=(List<Fruit>)request.getAttribute("selFruits");
  %>
</head>
<body style="position: relative;">
  <div class="fruit_info">
    <div class="fruit_hot" >
      <div class="hf_title"><span class="ht_l">热卖商品</span><span class="ht_r"><a href="">MORE+</a></span></div>

      <%
        int i=1;
        for(Fruit fruits:hotFruits)
        {
          out.print("    <div class=\"hot_fruit\">\n" +
                  "      <div class=\"hf_img\"><a href=\""+request.getContextPath()+"/fruitServlet?method=info&uid="+user.getId()+"&fid="+fruits.getFid()+"\"><img src=\"static/img/fruits/"+fruits.getFid()+"/(1).jpg\" /></a></div>\n" +
                  "      <div c=\"hf_text\">\n" +
                  "        <div class=\"hf_name\"><a href=\""+request.getContextPath()+"/fruitServlet?method=info&uid="+user.getId()+"&fid="+fruits.getFid()+"\">"+fruits.getFname()+"</a></div>\n" +
                  "        <div class=\"hf_mon\">￥<span>"+fruits.getUp()+"</span></div>\n" +
                  "      </div>\n" +
                  "    </div>");
          i++;
          if(i==6)
            break;
        }

      %>
    </div>

    <div class="sel">
      <div class="selfruits">
        <ul class="selfruits_ul">
          <li class="selfruits_li">
            品类：
            <a href="<%=request.getContextPath()%>/searchServlet?method=all" class="selkey sgreen">不限</a>
            <a href="<%=request.getContextPath()%>/searchServlet?method=search&keyword=绿奇异果" class="selkey">绿奇异果</a>
            <a href="<%=request.getContextPath()%>/searchServlet?method=search&keyword=阳光金果" class="selkey">阳光金果</a>
            <a href="<%=request.getContextPath()%>/searchServlet?method=search&keyword=苹果" class="selkey">苹果</a>
            <a href="<%=request.getContextPath()%>/searchServlet?method=search&keyword=梨" class="selkey">梨</a>
            <a href="<%=request.getContextPath()%>/searchServlet?method=search&keyword=葡萄" class="selkey">葡萄</a>
          </li>
          <%--<li class="selfruits_li">--%>
            <%--产地：--%>
            <%--<a href="/SELServlet?selkey=all" class="selkey sgreen">不限</a>--%>
            <%--<a href="" class="selkey">进口</a>--%>
            <%--<a href="" class="selkey">国产</a>--%>
          <%--</li>--%>
          <li class="selfruits_li">
            价格：
            <a href="<%=request.getContextPath()%>/searchServlet?method=all" class="selkey sgreen">不限</a>
            <a href="<%=request.getContextPath()%>/searchServlet?method=money&keyword=a" class="selkey">100以下</a>
            <a href="<%=request.getContextPath()%>/searchServlet?method=money&keyword=b" class="selkey">100~300</a>
            <a href="<%=request.getContextPath()%>/searchServlet?method=money&keyword=c" class="selkey">300以上</a>
          </li>
          <%--<li class="selfruits_li" id="sort">--%>
            <%--排序：--%>
            <%--<a href="/SELServlet?selkey=all" class="selkey sgreen">默认</a>--%>
            <%--<a href="" class="selkey">价格由小到大</a>--%>
            <%--<a href="" class="selkey">价格由大到小</a>--%>
          <%--</li>--%>
        </ul>

      </div>


      <div class="fruitboxs">
        <%
          if (selFruits!=null)
          {
            for(Fruit fruit:selFruits)
            {
              out.print("        <div class=\"fruit_box\">\n" +
                      "          <div class=\"fruit_img\">\n" +
                      "            <a href=\""+request.getContextPath()+"/fruitServlet?method=info&uid="+ user.getId()+"&fid="+fruit.getFid()+"\"><img src=\"static/img/fruits/"+fruit.getFid()+"/(1).jpg\" /></a>\n" +
                      "          </div>\n" +
                      "          <div class=\"fruit_name\">\n" +
                      "            <a href=\""+request.getContextPath()+"/fruitServlet?method=info&uid="+ user.getId()+"&fid="+fruit.getFid()+"\">"+fruit.getFname()+"</a>\n" +
                      "          </div>\n" +
                      "          <div class=\"fruit_spec\">\n" +
                      "            "+fruit.getSpec()+"\n" +
                      "          </div>\n" +
                      "          <div class=\"fruit_up\">\n" +
                      "            ￥"+fruit.getUp()+"\n" +
                      "          </div>\n" +
                      "          <div class=\"flogo\">\n" +
                      "            <img src=\"img/flogo.png\"/>\n" +
                      "          </div>\n" +
                      "        </div>");
            }
          }
        %>

      </div>

      </div>
  </div>

</body>
</html>
