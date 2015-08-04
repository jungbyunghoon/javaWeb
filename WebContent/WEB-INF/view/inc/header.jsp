<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
  <c:set var="ctxName" value="${pageContext.request.contextPath}"/>

<div id="header">
<div class="top-wrapper">
				<h1 id="logo"><a href="${ctxName}/index"><img src="${ctxName}/resource/images/logo.png" alt="뉴렉처" /></a></h1>
				<h2 class="hidden">메인메뉴</h2>
				<ul id="mainmenu" class="block_hlist">
					<li>
						<a href="">학습가이드</a>
					</li>
					<li>
						<a href="" >과정선택</a>
					</li>
					<li>
						<a href="" >인기과정</a>
					</li>
				</ul>
				<form id="searchform" action="" method="get">
					<fieldset>
						<legend class="hidden">
							과정검색폼
						</legend>
						<label for="query">과정검색</label>
						<input type="text" name="query" />
						<input type="submit" class="button" value="검색" />
					</fieldset>
				</form>
				<h3 class="hidden">로그인메뉴</h3>
				<ul id="loginmenu" class="block_hlist">
					<li>
						<a href="${ctx.Name}/index">HOME</a>
					</li>
					<li>
				<%-- 	<c:if test ="${empty pageContext.request.userPrincipal}">
						</c:if>
						<c:if test ="${not empty pageContext.request.userPrincipal}">
						</c:if>		 --%>
						<a href="${ctxName}/joinus/login"> 로그인</a>
						<a href="${ctxName}/j_spring_security_logout"><security:authentication property="name"/>로그아웃</a>
						<security:authentication property="authorities" var="authorties" />
						<c:forEach items ="${authorities}" var="auth">
						${auth.authority}
						</c:forEach>
						
					
					</li>
					<li>
						<a href="${ctx.Name}/joinus/join">회원가입</a>
					</li>
				</ul>
				<h3 class="hidden">회원메뉴</h3>
				<ul id="membermenu" class="clear">
					<li>
						<a href=""><img src="${ctxName}/resource/images/menu-mypage.png" alt="마이페이지" /></a>
					</li>
					<li>
						<a href="${ctxName}/notice"><img src="${ctxName}/resource/images/menu-customer.png" alt="고객센터" /></a>
					</li>
				</ul>
			</div>
			</div>