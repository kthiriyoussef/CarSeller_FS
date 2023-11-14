<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

<!-- Bootstrap JS -->
<script src="/webjars/bootstrap/5.0.0-beta3/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Creer un Voiture</title>
</head>
<body>
<div class="container mt-5" >
<div class="card-body">
<form action="saveVoiture" method="post">
<div class="form-group">
<label class="control-label">Modele :</label>
 <input type="text" name="modele" class="form-control"></div>
Coleur : <input type="text" name="coleur"class="form-control">
Prix : <input type="text" name="prix"class="form-control">
date realisation : <input type="date" name="date"class="form-control">
<button type="submit" value="ajouter" class="btn btn-primary">Ajouter</button>
</pre>
</form>
</div>
</div>
${msg}
<br/>
<br/>
<a href="ListeVoiture">Liste Produits</a>
</body>
</html>