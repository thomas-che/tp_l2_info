<!DOCTYPE html>
<html lang="fr">
 		<head>
   			 <meta charset="utf-8">
   			 <link rel="stylesheet" href="style.css">
   			 <title>tp3 exo1</title>
        </head>
 	    <body>
 	    	<?php 
	        try {
	        require_once('connect.php') ;
	        $connexion=new PDO('mysql:host='.SERVEUR.';dbname='.BDD,USER,PASSWORD) ;
	        $connexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	        }
	        catch(PDOException $e) {
	        $msg = 'ERREUR dans ' . $e->getFile() . ' Ligne : ' . $e->getLine() . ' : ' . $e->getMessage() ;
	        exit($msg);
	        }
	        $connexion->query("SET NAMES UTF8") ; 
	        ?>

	        <div class="matable">
	        <table>
	        	<?php
	        		echo '<caption>EXAMENS</caption>';
	        		$j=0;
	        		while ($j<31) {
	        			if ((31-$j )<7) {
	        				$longeur=31-$j;
	        			}
	        			else {
	        				$longeur=7;
	        			}
	        			
	        			if ($j%7==0) {
	        				echo '<tr>';
	        				for ($i=1;$i<=$longeur;$i++)
	        				{ 
	        					$jourcal=$i+$j;

	        					$requete="SELECT matiere,salle FROM examens WHERE numjour=$jourcal ";
						        $resultat=$connexion->query($requete) ;
						        $donnees = $resultat->fetch();
						        $resultat->closeCursor();

						        if ($donnees == null) {
						        	echo '<td class="standard">' . $jourcal . '</td>';
						        }
						        else {
						        	echo '<td class="tache">' . $jourcal . '<br/>' . $donnees['matiere'] . '<br/>' . $donnees['salle'] . '</td>';
						        }
	        				}
	        				echo '</tr>';
	        			}
	        			else {
	        				echo "else";
	        			}
	        			$j=$j+7;	
	        		}
	        	?>
	        </table>
	    </div>
  	    </body>	
</html>