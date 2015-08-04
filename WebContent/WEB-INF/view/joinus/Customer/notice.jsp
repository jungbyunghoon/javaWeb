<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="content">
					<h2>ê³µì§ì¬í­</h2>
					<h3 class="hidden">ë°©ë¬¸íì´ì§ ë¡ê·¸</h3>
					<ul id="breadscrumb" class="block_hlist clear">
						<li>HOME</li>
						<li>
							ê³ ê°ì¼í°
						</li>
						<li>
							ê³µì§ì¬í­ëª©ë¡
						</li>
					</ul>
					<h3 class="hidden">ê³µì§ì¬í­ ëª©ë¡</h3>
					<form id="content-searchform" class="article-search-form" action="notice.jsp" method="get">
						<fieldset>
							<legend class="hidden">
								ëª©ë¡ ê²ì í¼
							</legend>
							<input type="hidden" name="pg" value="" />
							<label for="f"
							class="hidden">ê²ìíë</label>
							<select name="f">
								<option value="TITLE">ì ëª©</option>
								<option value="CONTENT">ë´ì©</option>
							</select>
							<label class="hidden" for="q">ê²ìì´</label>
							<input type="text"
							name="q" value="" />
							<input type="submit" value="ê²ì" />
						</fieldset>
					</form>
					<table class="article-list margin-small">
						<caption class="hidden">
							ê³µì§ì¬í­
						</caption>
						<thead>
							<tr>
								<th class="seq">ë²í¸</th>
								<th class="title">ì ëª©</th>
								<th class="writer">ìì±ì</th>
								<th class="regdate">ìì±ì¼</th>
								<th class="hit">ì¡°íì</th>
							</tr>
						</thead>

						<tbody>
						<c:forEach var="n" items="${list}">

							<tr>
								<td class="seq">${n.code}</td>
								<td class="title">
								<a href="noticeDetail?c=${n.code}">${n.title}</a>
								[${n.cmtCount}]
							<c:forEach var="f" items="${n.files}">
								${f.name}
								</c:forEach>
								</td>
								<td class="writer">${n.writerName}</td>
								<td class="regdate"><fmt:formatDate value="${n.regDate}" pattern="yyyy-MM-dd"/></td>
								<td class="hit">${n.hit}</td>
							</tr>
							</c:forEach>

						</tbody>
					</table>
					<p class="article-comment margin-small">
					<security:authorize ifAnyGranted="ROLE_ADMIN, ROLE_TEACHER"> <!-- íëë§ íì¸ëë©´ë¨ -->
						<a class="btn-write button" href="noticeReg">ê¸ì°ê¸°</a>
					</security:authorize>
					</p>
					<p id="cur-page" class="margin-small">
						<span class="strong">1</span> /
						10	page
					</p>
					<div id="pager-wrapper" class="margin-small">
						<div class="pager clear">
							<p id="btnPrev">
								<a class="button btn-prev"
								href="notice.jsp">ì´ì </a>
							</p>
							<ul>
								<li>
									<a class="strong" href="">1</a>
								</li>
								<li>
									<a href="">2</a>
								</li>
								<li>
									<a href="">3</a>
								</li>
								<li>
									<a href="">4</a>
								</li>
								<li>
									<a href="">5</a>
								</li>
							</ul>
							<p id="btnNext">
								<span class="button btn-next">ë¤ì</span>
							</p>
						</div>
					</div>
				</div>