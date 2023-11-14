<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Liste Voiture</title>
</head>
<body>
 <div class="container mt-5">
<div class="card">
 <div class="card-header">
 Liste des Voitures
 </div>
 <div class="card-body">

 <table class="table table-striped">

 <tr>
 <th>ID</th><th>Modele</th><th>coleur</th><th>prix</th><th>Date realisation</th><th>Suppression</th><th>Edition</th>
 </tr>
 <c:forEach items="${voiture}" var="v">
 <tr>
 <td>${v.idVoiture }</td>
 <td>${v.modele }</td>
 <td>${v.coleur }</td>
 <td>${v.prix }</td>
 <td><fmt:formatDate pattern="dd/MM/yyyy" value="${v.relaseDate}" /></td>
 <td><a onclick="return confirm('Etes-vous sûr ?')"href="supprimerVoiture?id=${v.idVoiture }">Supprimer</a></td>
 <td><a href="modifierVoiture?id=${v.idVoiture }">Edit</a></td>
 </tr>
 </c:forEach>
 </table>
 
 
 </div>
 </div>
</body>
</html>