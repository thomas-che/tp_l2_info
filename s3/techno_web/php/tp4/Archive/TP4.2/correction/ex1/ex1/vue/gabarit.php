<!DOCTYPE html>
<html lang="fr">
    <head>
      <title>Ma page</title>
      <meta charset="utf-8">
	  <link rel="stylesheet"  href="vue/style/style.css" />
	  
    </head>
  <body>
 
   <form id="monForm" action="forum.php" method="post">
   <fieldset>
          <legend> Poster un message </legend>
   	 
	
	 <p><label>  Login  : </label><input type="text" name="user" /></p>
	 <p><label>  Mot de passe  : </label><input type="text" name="mdp" /></p>
	 <p><label>  Message  : </label><input type="text" name="msg" /> </p>
	 <p> <input type="submit" value="Envoyer votre msg" name="envoyer"  /> </p>

	   
   </fieldset>  
   </form>


   <?php echo $contenu; ?>

   <form id="monForm" action="forum.php" method="post">
   <fieldset>
          <legend> Effacer un message </legend>
   	 
	
	 <p><label>  Id du message  : </label><input type="text" name="idmsg" /></p>
	 <p> <input type="submit" value="Supprimer le msg" name="supprimer"  /> </p>

	   
   </fieldset>  
   </form>


</body>
</html>