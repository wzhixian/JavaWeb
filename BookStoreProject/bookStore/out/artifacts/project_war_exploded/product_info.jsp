<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
</head>

<body class="main">

	<jsp:include page="head.jsp" />

	<jsp:include page="menu_search.jsp" />


	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td><div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.html">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a
							href="product_list.html">&nbsp;计算机</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp; 
					</div>





					<table cellspacing="0" class="infocontent">
						<tr>
							<td><img src="ad/page_ad.jpg" width="645" height="84" />

											
								<table width="100%%" border="0" cellspacing="0">
											<c:forEach items="${produst_list }" var="p">
									<tr>
										<td width="30%">

											<div class="divbookcover">
												<p>
													<img src="${p.imgurl }"
														width="213" height="269" border="0" />
												</p>
											</div>

											<div style="text-align:center; margin-top:25px">
												<a href="buyServlet?bookname=${p.name }">
													<img src="images/buybutton.gif" border="0" /> 
												</a>
											</div></td>
										<td style="padding:20px 5px 5px 5px"><img
											src="images/miniicon3.gif" width="16" height="13" /><font
											class="bookname">&nbsp;&nbsp;${p.name }</font>

											<hr />售价：<font color="#FF0000">￥${p.price }</font>
											<hr /> 类别：${p.category }

											<hr />
											<p>
												<b>内容简介：</b>
											</p> ${p.description }</td>
											</c:forEach>
									</tr>
								</table>
									
								</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>


	<jsp:include page="foot.jsp" />


</body>
</html>
