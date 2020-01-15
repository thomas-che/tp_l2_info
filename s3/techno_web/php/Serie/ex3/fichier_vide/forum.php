<!DOCTYPE html> 
    <head>
        <meta charset="utf-8" />
        <title>OPR php</title>
    </head>

    <body>

        <?php 
        if (! ($_POST['code']=='code') ){
            echo "code faux";
            exit();
        }
        else {
            echo 'bon code';
        }

        ?>

    </body>
</html>