<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
<head>
	<link rel="shortcut icon" href="/favicon.ico" />
	<link rel="bookmark" href="/favicon.ico" type="image/x-icon"/>
</head>
    <body>
    <% request.setCharacterEncoding("utf-8"); %>
    <div class="main-wrap">
        <div class="crumb-wrap">
			<div class="search-wrap">
				<div class="search-content">
				<div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">图书管理</span></div>
					<form action="/MonkeyShop/manage/admin_doproductselect" method="get">
	                 	<table class="search-tab">
		                 	<tr>
			                    <th width="70">关键字:</th>
								<td><input class="common-text" placeholder="关键字" name="lookwords" value="${param.lookwords}" id="" type="text"></td>
								<td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
        <div id="register" class="result-wrap">
            <form action="/MonkeyShop/manage/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/MonkeyShop/manage/admin_toproductadd"><i class="icon-font"></i>新增图书</a>
                	</div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="60%">
                        <tr>
                            <th>ID</th>
                            <th>文件名称</th>
                            <th>操作</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="p" items="${plist}">
                        	<tr>
                        		<td>${p.PRODUCT_ID }</td>
                        		
                        		<td><img src="../images/product/${p.PRODUCT_FILENAME}" width="80" height="80">
                        			${p.PRODUCT_NAME }
                        		</td>
                        		<%-- <c:forEach var="me" items="${fileNameMap}"> --%>
                        		<td>
							        <c:url value="/servlet/DownLoadServlet" var="downurl">
							            <c:param name="filename" value="${me.key}"></c:param>
							        </c:url>
							        	${me.value}<a href="${downurl}">下载</a>
							    </td>
							    <%-- </c:forEach> --%>
                        		<td>
									<a class="link-del" href="javascript:Delete('你确定要删除【${p.PRODUCT_NAME}】吗？', '/MonkeyShop/manage/admin_productdel?id=${p.PRODUCT_ID}')">删除</a>
	                            </td>
                        	</tr>
	                    </c:forEach>
                        <script>
	                      	function Delete(mess, url) {
	                    		if(confirm(mess)) {
	                    			location.href=url;
	                    		}
	                    	}
                        	function catedel(id) {
                        		if(confirm("你确认要删除这个分类吗")) {
                        			location.href="admin_docatedel?id="+id;
                        		}
                        	}
                        	function selall(o) {
                        		var a = document.getElementsByName('id[]');
                        		for(var i=0; i<a.length; i++) {
                        			a[i].checked = o.checked;
                        		}
                        	}
                        	function delmore(mess, formname) {
                        		if(confirm(mess)) {
                        			var form = document.getElementById(formname);
                        			form.submit();
                        		}
                        	}
                        </script>
                    </table>
                    <div class="list-page"> 
                    	共 ${tsum} 条记录， 当前 ${age}/${tpage} 页
                    	<a href="admin_doproductselect?cp=1${searchParams}">首页</a>
                    	<a href="admin_doproductselect?cp=${age-1<1?1:age-1}${searchParams}">上一页</a>
                    	<a href="admin_doproductselect?cp=${age+1>tpage?tpage:age+1}${searchParams}">下一页</a>
                    	<a href="admin_doproductselect?cp=${tpage}${searchParams}">尾页</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>