<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	spring start

	<ul>
		<li>Hello====
		<li><a href="${pageContext.request.contextPath}/hello.do">hello.do</a></li>
		<li><a href="<%=request.getContextPath()%>/hello-raw.do">hello-raw.do</a></li>
		<li><a href="<%=request.getContextPath()%>/hello.do2">hello.do2</a></li>
	</ul>

	<ul>
		<li>model
		<li><a href="<%=request.getContextPath()%>/event/list">event/list</a></li>
	</ul>


	<ul>
		<li>@RequestMapping, @PathVariable:
		<li><a href="<%=request.getContextPath()%>/member/regist">/member/regist</a>:
			GET/POST 예, RegistrationController</li>

		<li><a href="<%=request.getContextPath()%>/members">/members</a>:
			@PathVariable 사용 위한 목록 출력, MemberController.members()</li>
		<li><a href="<%=request.getContextPath()%>/members/m2">/members/m2</a>:
			@PathVariable 예, MemberController.memberDetail()</li>

		<li><a href="<%=request.getContextPath()%>/members/m2/orders/1">/members/m2/orders/1</a>:
			@PathVariable 예, MemberController.memberOrderDetail()</li>
		<li><a href="<%=request.getContextPath()%>/members/m2/orders/1a">/members/m2/orders/1a</a>:
			@PathVariable 400 응답 예, MemberController.memberOrderDetail()</li>


		<li><a href="<%=request.getContextPath()%>/files/a123">/files/a123</a>:
			@PathVariable 정규표현식, FileController.fileInfo()</li>
		<li><a href="<%=request.getContextPath()%>/files/a1">/files/a1</a>:
			@PathVariable 정규표현식 404, FileController.fileInfo()</li>
		<li><a href="<%=request.getContextPath()%>/folders/1/2/3/files">/files/1/2/3/files</a>:
			@RequestMapping Ant패턴, FileController.list()</li>


</ul>


	<ul>
	<li>요청 파라미터 처리:</li>
	<li><a href="<%=request.getContextPath() %>/event/detail?id=1">event/detail?id=1</a>:
	 HttpServletRequest을 이용한 파라미터 구하기, EventController.detail()</li>
	<li><a href="<%=request.getContextPath() %>/event/detail2?id=1">event/detail2?id=1</a>:
	 @RequestParam을 이용한 파라미터 구하기, EventController.detail2()</li>
	<li><a href="<%=request.getContextPath() %>/event/detail2">event/detail2</a>:
	 @RequestParam 필수 파라미터 400 에러, EventController.detail2()</li>
	<li><a href="<%=request.getContextPath() %>/search">search</a>:
	 @RequestParam 필수 아님 설정, SearchController.search()</li>
	</ul>
	
	<ul>
	<li>커맨드 객체, @ModelAttribute:</li>
		<li><a href="<%=request.getContextPath() %>/member/regist">/member/regist</a>: 
		커맨드 객체, @ModeAttribute로 커맨드 객체 이름 지정, RegistrationController</li>
	
	<li><a href="<%=request.getContextPath() %>/acl/list">/acl/list</a>
	: 커맨드 객체 리스트 처리, AclController
	</li>	
	
	
	</ul>









	</ul>



</body>



















</html>