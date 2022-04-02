<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Catalogue</h1>
		<table class="table">
			<c:forEach items="${produits}" var="p">
				<tr>
					<td>${p.id}</td>
					<td>${p.libelle}</td>
					<td>${p.prix}</td>
					<td>${p.description}</td>
					<td><a href="${ctx}/catalogue/save?id=${p.id}" class="btn btn-outline-primary">Update Qté</a></td>
					<td><a href="${ctx}/catalogue/delete?id=${p.id}" class="btn btn-outline-danger">Supprimer Article</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>