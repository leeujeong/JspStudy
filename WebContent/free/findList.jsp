<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.css" integrity="sha512-4wfcoXlib1Aq0mUtsLLM74SZtmB73VHTafZAvxIp/Wk9u1PpIsrfmTvK0+yKetghCL8SHlZbMyEcV8Z21v42UQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<style>
		a{
			text-decoration :none;
			color:black;
		}
		.title{
			color:green;
		}
		.insert{
			font-size:20px;
			font-weight:bold;
			color:orange;
		}
		
		.wrap1{
			padding:10px;
		}
		.reply_link{
			font-size:8px;
			color:green;
		}
		.reply_link{
			cursor:pointer;
		}
		.reply_form{
			display:none;
		}
		.btn{
			color: green;
		}
		.btn:hover{
			color: crimson;
		}
		table{
			width:100%;
			border-collapse: collapse;
			border: 2px solid gray;
		}
		td{
			padding: 5px;
			border: 2px solid silver;
		}
		.thead{
			background-color: orange;
			text-align : center;
		}
		.page_num{
			color:orange;
		}
		.page_num:hover{
			font-weight:bold;
		}
		.footer{
		 	text-align : center;
		}
	</style>
	
	<script>
		$(document).ready(function(){
			$('.reply_link').on('click', function(){
				$(this).parent().parent().next().toggleClass('reply_form');
			});
		});
	</script>
</head>
<body>

	<header>
		<h1><a href="index.jsp" class="title">WEB PAGE TITLE</a></h1>
	</header>

	<hr>
	<!-- 검색란 -->
	<form action="find.free" >
		<!-- option의 value를 DB컬럼명으로 직접사용 -->
		<select name="column">
			<option value="WRITER">작성자</option>
			<option value="CONTENT">내용</option>
			<option value="ALL">작성자 + 내용 </option>
		</select>
		<input type="text" name="query">
		<button>검색</button>
		<input type="button" value="전체보기" onclick="location.href='list.free'">
		
	</form>
	
	
	<!-- 작성 링크 -->
	<div class="wrap1">
		<c:if test="${loginUser != null}">
			<a href="insertForm.free" class="insert">새글작성</a>		
		</c:if>
	</div>
	
	
	<!-- 목록 -->
	<span >전체 게시글 : ${totalRecord}개</span><br>
	<table border="1">
		<thead class="thead">
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td>내용</td>
				<td>조회수</td>
				<td>최종수정일</td>
				<td>X</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="6">없다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach items="${list}" var="free">
					<c:if test="${free.state == 0}">
						<tr>
							<td>${free.fNo}</td>
							<td>${free.writer}</td>
							<td>
								<!-- depth만큼 들여쓰기 -->
								<c:forEach begin="1" end="${free.depth}">
									&nbsp;&nbsp;
								</c:forEach>
								<!-- 댓글(depth 1 이상) [re] -->
								<c:if test="${free.depth >=1}">
									[re]:&nbsp;
								</c:if>
								<!-- 20자 이내는 그대로 표시 -->
								<c:if test="${free.content.length() < 20}">
									<a href="view.free?fNo=${free.fNo}">${free.content}</a>&nbsp;&nbsp;&nbsp;
								</c:if>
								<!-- 20자 넘어가면 20자만 표시 -->
								<c:if test="${free.content.length() >= 20}">
									<a href="view.free?fNo=${free.fNo}">${free.content.substring(0, 20)}</a>&nbsp;&nbsp;&nbsp;
								</c:if>
								<a class="reply_link">댓달</a>								
							</td>
							<td>${free.hit}</td>
							<td>${free.lastModified}</td>
							<td>
								<c:if test="${loginUser.id == free.writer}">								
									<a onclick="fnDelete(this)" href="delete.free?fNo=${free.fNo}"><i class="far fa-times-circle"></i></a>
									<script type="text/javascript">
										function fnDelete(a){
											$(a).on('click', function(event){
												if (confirm('삭제할까요?') == false) {
													event.preventDefault();
													return false;
												}
												return true;
											});
										}
									</script>
								</c:if>
							</td>
						</tr>
						<tr class="reply_form">
							<td colspan="6">
								<form action="insertReply.free" method="post">
								
								<!-- 원글의 DEPTH, GOUPNO, GROUPORD를 넘겨줌 -->
									<input type="hidden" name="depth" value="${free.depth}">
									<input type="hidden" name="groupNo" value="${free.groupNo}">
									<input type="hidden" name="groupOrd" value="${free.groupOrd}">
									<input type="text" name="writer" value="${loginUser.id}" readonly>
									<input type="text" name="content"placeholder="내용">
									<button>댓글달기</button>
								</form>
							</td>
						</tr>
					</c:if>
					<c:if test="${free.state == -1}">
						<tr>
							<td colspan="6">삭제된 게시글입니다.</td>
						</tr>
					</c:if>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot class="footer">
			<tr>
				<td colspan="6">
					
					<!-- 1페이지로 이동 : 1페이지는 링크가 필요 없음. -->
					<c:if test="${p.page == 1}">
						<span class="btn">◀◀</span>&nbsp;&nbsp;
					</c:if>
					<c:if test="${p.page != 1}">
						<a href="find.free?column=${column}&query=${query}&page=1" class="btn">◀◀</a>&nbsp;&nbsp;
					</c:if>
					
					<!-- 이전 블록으로 이동 : 1블록은 링크가 필요 없음. -->
					<c:if test="${p.page <= p.pagePerBlock}">
						<span class="btn">◀</span>&nbsp;&nbsp;
					</c:if>
					<c:if test="${p.page > p.pagePerBlock}">
						<a href="find.free?column=${column}&query=${query}&page=${p.beginPage - 1}" class="btn">◀</a>&nbsp;&nbsp;
					</c:if>
					
					<!-- 페이지 번호 : 현재 페이지는 링크가 필요 없음. -->
					<c:forEach var="i" begin="${p.beginPage}" end="${p.endPage}">
						<c:if test="${p.page == i}">
							<span class="page_num">${i}</span>&nbsp;&nbsp;
						</c:if>
						<c:if test="${p.page != i}">
							<a href="find.free?column=${column}&query=${query}&page=${i}" class="page_num">${i}</a>&nbsp;&nbsp;
						</c:if>
					</c:forEach>
					
					<!-- 다음 블록으로 이동 : 마지막 블록은 링크가 필요 없음. -->
					<c:if test="${p.endPage == p.totalPage}">
						<span class="btn">▶</span>&nbsp;&nbsp;
					</c:if>
					<c:if test="${p.endPage != p.totalPage}">
						<a href="find.free?column=${column}&query=${query}&?page=${p.endPage + 1}" class="btn">▶</a>&nbsp;&nbsp;
					</c:if>
					
					<!-- 마지막 페이지로 이동 : 마지막 페이지는 링크가 필요 없음. -->
					<c:if test="${p.page == p.totalPage}">
						<span class="btn">▶▶</span>&nbsp;&nbsp;
					</c:if>
					<c:if test="${p.page != p.totalPage}">
						<a href="find.free?column=${column}&query=${query}&page=${p.totalPage}" class="btn">▶▶</a>&nbsp;&nbsp;
					</c:if>
	
				</td>
			</tr>
		</tfoot>
	</table>

</body>
</html>