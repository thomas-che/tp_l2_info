# coding: utf-8

from GUI import GUI
import json
import random


def creer_grille(l, c):
    """ Cette fonction crée une grille aléatoire de taille l par c
    contenant des murs placés aléatoirement
    """
    # with open("grille.json", "r", encoding="utf-8") as fichier:
    #	(grille, p) = json.load(fichier)

    type = ["grass", "wall", "grass", "grass"]
    g = []
    w = []
    for j in range(0, c):
        w.append("wall")

    g.append(w)
    for i in range(0, l - 2):
        line = ["wall"]
        for j in range(0, c - 2):
            x = random.randint(0, 2)
            line.append(type[x])
        line.append("wall")
        g.append(line)
    g.append(w)

    px = random.randint(1, l - 1)
    py = random.randint(1, c - 1)
    while (g[px][py] != "grass"):
        px = random.randint(1, l - 1)
        py = random.randint(1, c - 1)

    cx = random.randint(1, l - 1)
    cy = random.randint(1, c - 1)
    while (g[cx][cy] != "grass"):
        cx = random.randint(1, l - 1)
        cy = random.randint(1, c - 1)

    g[cx][cy]='cookie'

    print("grille =", g, "\n p[0]=", px, "\n p[1]=", py)
    return g, (px, py)


def voisins(G, pos):
    l = []

    listProsition = [(pos[0], pos[1] - 1), (pos[0], pos[1] + 1), (pos[0] - 1, pos[1]), (pos[0] + 1, pos[1])]

    for i in listProsition:
        if (G[i[0]][i[1]] != "wall"):
            l.append(i)
        # print (l)
    return l


def ParcoursRobot(G, depart, gui):
    atteint = []
    P = []
    P.append(depart)

    prev_chemin = []
    prev_chemin.append(depart)
    chemin = []

    while P != []:
        # print("WHILE : P= ",P," ; atteint= ",atteint)
        u = P.pop()
        chemin.append(u)
        # print("test not in atteint: u= ",u,u not in atteint)

        if (u not in atteint):
            atteint.append(u)
            l = voisins(G, u)
            for i in l:
                # print("DANS FOR : P= ",P,"\t i= ",i)
                P.append(i)
            # print("\tapres append : P= ",P,"\t i= ",i)

            gui.deplacer_oscar(prev_chemin, chemin)
            prev_chemin.append(u)

        # avant modif avec correction prof PB >> INDENTATION !! <<
        # gui.deplacer_oscar(prev_chemin, chemin)
        # prev_chemin.append(u)

        if (G[u[0]][u[1]] == "cookie"):
            print("\n\n\n \tBRAVO : cookie trouve")
            break


# correction fonc
def ParcoursRobotC(G, depart, gui):
    atteint = set()
    P = [(depart, [depart])]  # pile avec initilament le sommet de dep et le chemin dep

    prev_chemin = [depart]
    while P:
        (u, chemin) = P.pop()
        if (u not in atteint):
            atteint.add(u)
            x, y = u

            gui.deplacer_oscar(prev_chemin, chemin)
            prev_chemin = chemin

            if (G[x][y] == "cookie"):
                print("trouver cookie")
                break

            for v in voisins(G, u):
                P.append((v, chemin + [v]))

    print("Perdu !!")

if __name__ == '__main__':
    grille, pos_robot = creer_grille(10, 10)
    GUI(grille, pos_robot, ParcoursRobot)
