
<%@page import="com.newlecture.web.vo.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.dao.mybatis.MyBatisNoticeDao"%>
<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 


<%
	NoticeDao noticeDao = new MyBatisNoticeDao();
	List<Notice> list = noticeDao.getNotices(1);
	request.setAttribute("list",list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NEW LECTURE</title>
</head>
<link href="../css/style.css" type="text/css" rel="stylesheet" />
<style>

</style>
<body>

	<header id="header">
		<h1><a href=""><img src="../images/logo.png" alt="newlecture"/></a></h1>

		<section id="top" class="h1">
			<h1>머릿말</h1>

			<nav id="main-menu">
				<h1>메인메뉴</h1>
				<ul>
					<li><a href="">학습가이드</a></li>
					<li><a href="">뉴렉과정</a></li>
					<li><a href="">강좌선택</a></li>
				</ul>
			</nav>

			<section id="lecture-search-form">
				<h1 class="h1">강좌검색 폼</h1>
				<form>
					<fieldset>
						<legend>검색정보</legend>
						<label>과정검색</label> 
						<input type="text" /> 
						<input type="submit" value="검색" />
					</fieldset>
				</form>
			</section>

			<nav>
				<h1 class="h1">회원메뉴</h1>
				<ul>
					<li><a href="">HOME</a></li>
					<li><a href="">로그인</a></li>
					<li><a href="">회원가입</a></li>
				</ul>
			</nav>


			<nav>
				<h1>고객메뉴</h1>
				<ul>
					<li><a href="">마이페이지</a></li>
					<li><a href="">고객센터</a></li>
				</ul>
			</nav>
		</section>
	</header>


	<aside>

		<h1 class="h1">고객센터</h1>
		<nav>
			<h1>고객센터메뉴</h1>
			<ul>
				<li><a href="">공지사항</a></li>
				<li><a href="">1:1고객문의</a></li>
				<li><a href="">학습안내</a></li>
			</ul>
		</nav>

		<nav>
			<h1>추천사이트</h1>
			<ul>
				<li><a href=""><img src="../images/answeris.png"
						alt="answeris" /></a></li>
				<li><a href=""><img src="../images/tune-a.png" alt="tune-a" /></a></li>
			</ul>
		</nav>

	</aside>

	<main>
	<section>

		<h1 class="h1">공지사항</h1>
		<section>
			<h1>경로</h1>
			<ul>
				<li>HOME</li>
				<li>고객센터</li>
				<li>공지사항</li>
			</ul>
		</section>


		<section>
			<h1 class="h1">공지사항 검색폼</h1>
			<form>
				<fieldset>
					<legend>공지사항 검색정보</legend>
					<label>검색필드</label> <select>
						<option>제목</option>
						<option>작성자</option>
					</select> <label>검색어</label> <input type="text" /> <input type="submit"
						value="검색" />
				</fieldset>
			</form>
		</section>

		<section>
			<h1 class="h1">공지사항 목록</h1>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
				
				<c:forEach var="n" items="${list}">
				<%-- <%for(int i=0; i<10; i++){%> --%>
					<tr>
						<td>${n.code}</td>
						<td><a href="noticeDetail.jsp?c=${n.code}">${n.title}</a></td>
						<td>${n.writer}</td>
						<td><fmt:formatDate value="${n.regDate}" pattern="YYYY-MM-dd"/></td>
						<td>${n.hit}</td>
						
<%-- 						<td><%=list.get(i).getCode() %></td>
						<td><a href="noticeDetail.jsp?c=<%=list.get(i).getCode()%>"><%=list.get(i).getTitle() %></a></td>
						<td><%=list.get(i).getWriter() %></td>
						<td><%=list.get(i).getRegDate() %></td>
						<td><%=list.get(i).getHit() %></td> --%>
						
						
					</tr>
					<%-- <%} %> --%>
					</c:forEach>

				</tbody>
			</table>
		</section>

		<section>
			<h1>현재 페이지 번호</h1>
			<p>1 of 3 pages</p>
		</section>

		<nav>
			<h1>페이지</h1>
			<ul>
				<li><a href="">1</a></li>
				<li><a href="">2</a></li>
				<li><a href="">3</a></li>
				<li><a href="">4</a></li>
				<li><a href="">5</a></li>
			</ul>
		</nav>
	</section>
	</main>

	<aside></aside>


	<footer>
		<section>
			<h1>뉴렉쳐</h1>
			<nav>
				<h1 class="h1">관리자 정보</h1>
				<dl>
					<dt>주소:</dt>
					<dd>서울특별시 동대문구 장안1동 423-4번지 윤진빌딩 4층</dd>
					<dt>관리자메일 :</dt>
					<dd>admin@newlecture.com</dd>
					<dt>전화:</dt>
					<dd>02-478-4084</dd>
					<dt>사업자 등록번호:</dt>
					<dd>132-18-46763</dd>
					<dt>통신 판매업 신고:</dt>
					<dd>제2013-서울강동-0969 호</dd>
					<dt>상호:</dt>
					<dd>뉴렉처</dd>
					<dt>대표:</dt>
					<dd>박용우</dd>
					<dt>관리자:</dt>
					<dd>전성일</dd>
				</dl>
			</nav>

			<nav>
				<h1 class="h1">저작권 정보</h1>
				<p>Copyright ⓒ newlecture.com 2012-2014 All Right Reserved.
					Contact admin@newlecture.com for more information</p>
			</nav>

		</section>
	</footer>
</body>




</html>