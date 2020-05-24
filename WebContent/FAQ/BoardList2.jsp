<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${listcount > 0 }">
	<tr>
		<th colspan="3">MVC 게시판 - list</th>
		<th colspan="2">
			<font size=2>글 개수 : ${listcount }</font>
		</th>
	</tr>
	<tr>
		<th width="8%"><div>번호</div></th>
		<th  width="50%"><div >제목</div></th>
		<th width="14%"><div >작성자</div></th>
		<th  width="17%"><div >날짜</div></th>
		<th  width="11%"><div >조회수</div></th>
	</tr>		
	<c:set var="num" value="${listcount-(page-1)*limit}"/>	
	<c:forEach var="b" items="${boardlist}">	
	<tr>
	  <td>
		<c:out value="${num}"/><%-- num 출력 --%>		
		<c:set var="num" value="${num-1}"/>	<%-- num = num - 1 의미--%>	
	  </td>
	  <td>
	     <div>	
			
		    <c:if test="${b.RE_LEV != 0}">  <%--  답글인 경우 --%>
				<c:forEach var="a" begin="0" 
				           end="${b.RE_LEV*2}" step="1">
				&nbsp; 	
				</c:forEach>			
			▶
			</c:if>  
			 
			<c:if test="${b.RE_LEV == 0}">  <%-- 원문인 경우 --%>
				&nbsp; ▶ 
			</c:if> 			
			
			<a href="./BoardDetail.FA?num=${b.SN}">
				${b.SUBJECT}
			</a>
			</div>
		</td>
		<td>
			<div>${b.USERID}</div>
		</td>
		<td>
			<div>${b.RSG_DTM}</div>
		</td>	
		<td>
			<div>${b.READCOUNT}</div>
		</td>
	</tr>
	</c:forEach>
	
	<tr class="h30 lime center btn">
		<td colspan=5>			
			<c:if test="${page <= 1 }">
				이전&nbsp;
			</c:if>
			<c:if test="${page > 1 }">			
				 <a href="./BoardList.FA?page=${page-1}">이전</a>&nbsp;
			</c:if>
					
			<c:forEach var="a" begin="${startpage}" end="${endpage}">
				<c:if test="${a == page }">
					${a}
				</c:if>
				<c:if test="${a != page }">
					<a href="./BoardList.FA?page=${a}">${a}</a>
				</c:if>
			</c:forEach>
			
			<c:if test="${page >= maxpage }">
				&nbsp;다음 
			</c:if>
			<c:if test="${page < maxpage }">
				<a href="./BoardList.FA?page=${page+1}">&nbsp;다음</a>
			</c:if>
		</td>
	</tr>
	</c:if>