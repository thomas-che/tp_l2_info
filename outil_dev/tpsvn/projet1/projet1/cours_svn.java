//svn

// pr se co
http://192.168.46.176/svn/o2180812/
login: o21...
mdp: nne...

// initialiser le svn
svn checkout https://pdicost.univ-orleans.fr/svn/o2180812/ projet1 --username=o2180812

svn status

// ajout 
svn add *

// commit
svn commit -m'msg'

//
svn log
//
svn log -v

// affiche le 2eme commit
svn log -r 2

// affiche des ifon a propos du svn
svn info

// affiche la diff avec l ancien commit
svn diff -r 1

// syncroniser le rep =~ pull
svn update

// si conflic suivre les indication

