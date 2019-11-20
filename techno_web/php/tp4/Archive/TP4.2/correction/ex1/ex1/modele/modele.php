
<?php

require_once('connect.php');

function getConnect(){
	$connexion=new PDO('mysql:host='.SERVEUR.';dbname='.BDD,USER,PASSWORD);
	$connexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	$connexion->query('SET NAMES UTF8');
	return $connexion;
}


function getDiscussion(){
	$connexion=getConnect();
	$requete="select * from forum" ;         // Limit 10 signifie les 10 premiers
	$resultat=$connexion->query($requete); 
	$resultat->setFetchMode(PDO::FETCH_OBJ);
    $discussion=$resultat->fetchall(); // chargement du rés dans un tab
    $resultat->closeCursor();
	return $discussion;
}	


function ajouterMessage($pseudo,$message){
	$connexion=getConnect();
    $requete="INSERT INTO forum VALUES('', '$pseudo', '$message')" ;
    $resultat=$connexion->query($requete);  
    $resultat->closeCursor();
}
		
function supprimerMessage($id){
	$connexion=getConnect();
    $requete="delete from forum where id=$id" ;
    $resultat=$connexion->query($requete);  
    $resultat->closeCursor();
}		
		
function checkUser($id,$mdp){
	$connexion=getConnect();
    $requete="select nom from user where id='$id' and mdp='$mdp' " ;
    $resultat=$connexion->query($requete);
	$resultat->setFetchMode(PDO::FETCH_OBJ);
	$nom=$resultat->fetchall(); // chargement du rés dans un tab
    $resultat->closeCursor();
	return $nom;
}
	

	