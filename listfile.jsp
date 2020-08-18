<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>下载文件显示页面</title>
  </head>
  <body>
      <!-- 遍历Map集合 -->
      <div class="result-content">
			<c:forEach var="me" items="${fileNameMap}">
				<c:url value="/servlet/DownLoadServlet" var="downurl">
				<c:param name="filename" value="${me.key}"></c:param>
				</c:url>
			${me.value}<a href="${downurl}">下载</a>
			<br/>
		</c:forEach>
	<a href="/MonkeyShop/manage/admin_productselect">返回首页面</a>
	</div> 
  </body>
</html>