G = {
    "a": ["b"],
    "b": ["a", "c", "d"],
    "c": ["b", "d"],
    "d": ["b", "c", "e"],
    "e": ["d"]
}

def AfficherAretes(G):
    for u in G:
        for v in G[u]:
            print("Arête {%s,%s}" % (u,v))


AfficherAretes(G)

# from graphviz import Graph
# dot = Graph()

# for v in G:
#     print("dans g")
#     dot.node(v, "sommet "+v)

# for v in G:
#     for u in G[v]:
#         if v<=u:
#             dot.edge(v, u)
# dot



# import matplotlib.pyplot as plt

# plt.plot([1,2,3,4])
# plt.ylabel('Label 1')
# plt.show()

import numpy as np
import matplotlib.pyplot as plt


#N = 50
x = np.random.rand(10)
y = np.random.rand(10)
colors = np.random.rand(10)
area = np.pi * 5  # 0 to 15 point radii

plt.scatter(x, y, s=area, c=colors, alpha=0.5)
plt.show()