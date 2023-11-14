<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

<title>Modifier un Voiture</title>
</head>
<body>
<div class="container mt-5">
<div class="card-body">
<form action="updateVoiture" method="post">
<div class="form-group">

id : <input type="text" name="idVoiture" value="${voiture.idVoiture}" readonly class="form-control">
Modele :<input type="text" name="modele" value="${voiture.modele}" class="form-control">
Coleur :<input type="text" name="coleur" value="${voiture.coleur}" class="form-control">
prix :<input type="text" name="prix" value="${voiture.prix}" class="form-control">
Date creation :
 <fmt:formatDate pattern="yyyy-MM-dd" value="${voiture.relaseDate}" var="formatDate" />
 <input type="date" name="date" value="${formatDate}" class="form-control"></input>
 </div>
<div><Button type="submit" value="Modifier" class="btn btn-primary">Modifier</Button></div>
</pre>
</form>
<br/>
<br/>
<a href="ListeVoiture">Liste Voiture</a>
</body>
</html>