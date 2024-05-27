Wachstumsordnung des Quick-Union-Algorithmus:
(alle Komponenten in einer Zusammenhangskomponente)
Analyse der Quick-Union-Operationen
Quick-Union Algorithmus

Im Quick-Union-Algorithmus werden Verbindungen durch das Finden der Wurzeln zweier Elemente und das Verbinden dieser Wurzeln erstellt. Die beiden Hauptoperationen sind:

    Find: Bestimmt die Wurzel des Baumes, zu dem ein Element gehört.
    Union: Verbindet die Wurzeln zweier Bäume.

Zeitkomplexität der Operationen
    Find: Im schlimmsten Fall O(n), weil der Baum eine Höhe von n−1 haben kann (in extrem unausgeglichenen Fällen).
    Union: Besteht aus zwei Find-Operationen und dem Verbinden der Wurzeln, also auch O(n).

Gesamtkomplexität bei Vereinigung aller Komponenten

Wenn wir n Elemente haben und diese zu einer einzigen Zusammenhangskomponente vereinen wollen, benötigen wir n−1 Union-Operationen.
Da jede Union-Operation im schlimmsten Fall O(n) Zeit benötigt, ergibt sich:

(n−1)×O(n)=O(n2)

Beispielanalyse der Schritte:
 
    Initial: 0 1 2 3 4 5 6 7 8 9 (10 Komponenten)
    Union(0, 1): 1 1 2 3 4 5 6 7 8 9 (9 Komponenten)
    Union(2, 1): 1 1 1 3 4 5 6 7 8 9 (8 Komponenten)
    Union(1, 3): 3 3 3 3 4 5 6 7 8 9 (7 Komponenten)
    Union(6, 9): 3 3 3 3 4 5 9 7 8 9 (6 Komponenten)
    Union(4, 7): 3 3 3 3 7 5 9 7 8 9 (5 Komponenten)
    Union(5, 8): 3 3 3 3 7 8 9 7 8 9 (4 Komponenten)
    Union(1, 5): 8 8 8 8 7 8 9 7 8 9 (3 Komponenten)
    Union(1, 8): 8 8 8 8 7 8 9 7 8 9 (3 Komponenten)
    Union(9, 1): 8 8 8 8 7 8 8 7 8 8 (2 Komponenten)
    Union(8, 2): 8 8 8 8 7 8 8 7 8 8 (2 Komponenten)
    Union(8, 3): 8 8 8 8 7 8 8 7 8 8 (2 Komponenten)
    Union(8, 4): 7 7 7 7 7 7 7 7 7 7 (1 Komponente)

Jede Union-Operation reduziert die Anzahl der Komponenten um eins.

Mit Heuristiken wie "Union by Rank" und "Path Compression" wird die Komplexität deutlich reduziert:
    Union by Rank: Verbessert die Balance der Bäume und hält die Höhe gering.
    Path Compression: Reduziert die Pfadlänge, indem Knoten direkt mit der Wurzel verbunden werden.

Diese Verbesserungen führen zu einer amortisierten Zeitkomplexität von O(α(n)) für Find und Union,
wobei α(n) die inverse Ackermann-Funktion ist, die in der Praxis nahezu konstant ist.

Ohne Verbesserungen hat der Quick-Union-Algorithmus eine Zeitkomplexität von O(n2) für die Vereinigung aller Komponenten.
Mit den Heuristiken "Union by Rank" und "Path Compression" kann diese Komplexität auf O(nα(n)) reduziert werden,
was in der Praxis nahezu linear ist.