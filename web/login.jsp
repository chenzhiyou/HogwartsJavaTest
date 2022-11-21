
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>用户登陆 - 天天果园-水果网购首选品牌，水果，我们只挑有来头的！</title>
  <link rel="stylesheet" type="text/css" href="static/css/main.css"/>
  <link rel="stylesheet" type="text/css" href="static/css/rl.css"/>

  <script>
    window.onload=function footer_img_non(){
      document.getElementById("footer_img").style.display="none";
    }
  </script>
</head>
<body>
  <div class="con">
    <div class="box">
      <div class="head">
        <a href="index.jsp">
          <img src="static/img/logo_login.png" alt="" />
        </a>
      </div>

      <div class="text">
        <%
          Object obj = request.getAttribute("showError");
          if(obj!=null){
            boolean showError = (Boolean)obj;
            if(showError){
        %>
        <span><font color="red">您尚未登录，请先登录!!</font></span>
        <%}
        }
        %>
        <div class="text_head">
          <span class="h01">会员登陆</span>
          <div class="xhr"></div>
        </div>
        <form action=<%=request.getContextPath()%>/userServlet?method=login  method="post">
          <div class="text_box">
            <div class="main"><div class="name">邮箱/手机：</div>
              <input type="text" name="str" id="str" value="" />
            </div>
            <div class="main"><div class="name">密码：</div>
              <input type="password" name="pwd" id="pwd" value="" />
            </div>
            <div class="xbutton">
              <input type="submit" name="login" id="login" value="登陆" />
            </div>
            <div class="fpwd">
              <a href="">忘记密码 >></a>
            </div>
          </div>

        </form>
      </div>

      <div class="jmp">
        <div class="jmpp">
          <p>还没有天天果园账号?</p>
          <p>注册赠时令鲜果1份</p>
        </div>
        <div class="jmpa_l">
          <a href="reg.jsp">立即注册&nbsp;></a>
        </div>
      </div>
    </div>

    <jsp:include page="static/footer/footer.jsp"></jsp:include>
  </div>
</body>
</html>
