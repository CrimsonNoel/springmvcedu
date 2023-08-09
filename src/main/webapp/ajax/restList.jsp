<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<title>Insert title here</title>
<script>
$(document).ready(function() {
		 $.get("${pageContext.request.contextPath}/rest/list", function(data, status){
			 alert("data: "+data +"\n Status: "+status)  // 바로 json object로 전송된다 
			 console.log(data)
		let out=""	 
	for (b of data) {
		out +="<tr>"
		out +="<td>"+b.id+"</td>"
		out +="<td>"+b.email+"</td>"
		out +="<td>"+b.address.address1+"</td>"
		out +="<td>"+b.address.address2+"</td>"
		out +="<td>"+b.zipcode+"</td>"
	
		out +="</tr>"
	}	
		 $("#json").html(out)
		 }) }) 

</script>
</head>

<body>
	<div class="w3-container">
		<h3 class="w3-center" id="head"></h3>
		<a class="w3-button   w3-right  w3-grey"
			href="${pageContext.request.contextPath}/board/boardForm">게시판 입력</a>
		<table class="w3-table-all" style="color: #000">
			<tbody>
				<tr>
					<th>id</th>
					<th>email</th>
					<th>address1</th>
					<th>address2</th>
					<th>zipcode</th>
				
				</tr>
			</tbody>
			<tbody id="json">


			</tbody>




		</table>
		<br>








	</div>
</body>
</html>