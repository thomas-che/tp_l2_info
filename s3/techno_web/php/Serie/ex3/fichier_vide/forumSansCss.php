<!DOCTYPE html> <html lang="fr" xml:lang="fr" 
xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <title>FORUM_SANS_CSS</title> <!-- FORUM_SANS_CSS -->
    </head>

    <body>

        <form action="page2.php" method="POST">
            <fieldset>
                <legend>Formulaire</legend>
                <p><label>Nom : <input type="text" name="nom" /></label></p>
                <p><label>Message : <input type="text" name="msg" /></label></p>

                <p><input type="submit" /></p>
            </fieldset>
        </form>

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
            
            // && !empty($_POST['nom']) && !empty($_POST['msg'])

            if ( isset($_POST) && !empty($_POST['nom']) && !empty($_POST['msg']) ) {
                $nom=$_POST['nom'];
                $msg=$_POST['msg'];
                $requete="INSERT INTO forum VALUES ( 0 , '$nom' , '$msg' ) ";
                $resultat=$connexion->query($requete);
                $resultat->closeCursor();
        // pour vider le tab $_POST
                unset($_POST);  
            }
            
            else {
                echo '<p>le champ nom ou message est vide</p>';
            }
        ?>
        <form action="page2.php" method="POST">
            <fieldset>
                <legend>Ancien discussion</legend>

        <?php
            // afficher la discission
            $requete="SELECT * FROM forum ORDER BY id DESC";
            $resultat=$connexion->query($requete) ;
            $resultat-> setFetchMode(PDO::FETCH_OBJ);
            $i=0;
            while ($ligne=$resultat->fetch()) {
                if ($i<10) {
                    echo '<p><label>' . htmlspecialchars $ligne->nom . '</label> : ' . htmlspecialchars $ligne->msg . '</p>' ;
                }
                $i++;
            }
            $resultat->closeCursor();
        ?>
            </fieldset>
        </form>


    </body>
</html>