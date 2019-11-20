<?php

require_once('controleur/controleur.php');
try {   if (isset($_POST['envoyer'])){
		           $user=$_POST['user'];
		           $msg=$_POST['msg'];
				   $mdp=$_POST['mdp'];
		           CtlAjouterMessage($user,$msg,$mdp);
		    }
		 elseif (isset($_POST['supprimer'])){ 
	     	       $id=$_POST['idmsg'];
				   CtlSupprimerMessage($id);
		     } 
	   	else CtlAcceuil(); 	 
	}
	
catch(Exception $e) {
                $msg = $e->getMessage() ;
			    CtlErreur($msg);
  }



