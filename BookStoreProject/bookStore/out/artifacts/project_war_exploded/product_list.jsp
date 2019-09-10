<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>bookStore列表</title>
<%--导入css --%>
<link rel="stylesheet" href="css/main.css" type="text/css" />
</head>

<body class="main">

	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td>
					<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;计算机&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;图书列表
					</div>

					<table cellspacing="0" class="listcontent">
						<tr>
							<td>
								<h1>商品目录</h1>
								<hr />
								<h1>计算机</h1>&nbsp;&nbsp;&nbsp;&nbsp;共100种商品
								<hr />
								<div style="margin-top:20px; margin-bottom:5px">
									<img src="images/productlist.gif" width="100%" height="38" />
								</div>
								<table cellspacing="0" class="booklist">
									<tr>
								<c:forEach items="${pb.list }" var="l">
										<td>

											<div class="divbookpic">
												<p>
													<a href="product_list_Servlet?bookname=${l.name }"><img src="${l.imgurl }" width="115"
														height="129" border="0" /> </a>
												</p>
											</div>

											<div class="divlisttitle">
												<a href="product_list_Servlet?bookname=${l.name }">书名:${l.name }<br />售价:${l.price } </a>
											</div></td>
	
									</c:forEach>
									</tr>
								</table>
							<center>
							<c:if test="${pb.currPage!=1 }">
								<a href="showProductByPage?currPage=1">[首页]</a>
								<a href="showProductByPage?currPage=${pb.currPage-1 }">[上一页]</a>
								</c:if>
								
								<c:forEach begin="1" end="${pb.totalPage }" var="n">
								
								<c:if test="${pb.currPage==n }">
										${n }
								</c:if>
								<c:if test="${pb.currPage!=n }">
									<a href="showProductByPage?currPage=${n }">${n }</a>
									</c:if>
									
								</c:forEach>
								<c:if test="${pb.currPage!=pb.totalPage }">
								<a href="showProductByPage?currPage=${pb.currPage+1 }">[下一页]</a>
								<a href="showProductByPage?currPage=${pb.totalPage }">[尾页]</a>
								</c:if>
							</center>
									第${pb.currPage }页/共${pb.totalPage }页
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp" />


</body>
</html>
