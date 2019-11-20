<?php 

require_once('modele/modele.php') ;
require_once('vue/vue.php');


function CtlAcceuil(){
	$discussion=getDiscussion();
	afficherDiscussion($discussion);
}

function CtlAjouterMessage($login,$message,$mdp){
    if (!empty($login) && !empty($message)&& !empty($mdp)) { 
		$pseudo=checkUser($login,$mdp);
		if ($pseudo!=null){	
	      ajouterMessage($pseudo[0]->nom,$message);
	     }
		 else{
		  throw new Exception("Login ou mdp non valide"); 
	    }   	 
	    CtlAcceuil();
	}
	else  {throw new Exception("Login, message ou mdp vide"); }   
}

function CtlSupprimerMessage($id){
	 if  (ctype_digit($id)){
	supprimerMessage($id);
	CtlAcceuil();	
     }
	 else {throw new Exception("Id message non valide");} 
}  

function CtlErreur($erreur){
	afficherErreur($erreur);
}


