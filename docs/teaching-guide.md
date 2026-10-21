# Guide d'animation

## Intention

Les quatre projets répondent au même contrat. Ne commencez pas par présenter les arborescences : faites d'abord suivre une requête de création de réservation et demandez où se trouvent les règles, les accès aux données et les dépendances techniques.

## Séquence proposée

| Temps | Activité | Production attendue |
|---:|---|---|
| 20 min | Exécuter le scénario commun | Résultats HTTP identiques |
| 30 min | Explorer la version en couches | Graphe des appels |
| 35 min | Explorer le monolithe modulaire | Carte des modules et API publiques |
| 45 min | Explorer l'hexagonale | Classement ports entrants, ports sortants, adaptateurs |
| 45 min | Explorer la Clean Architecture | Parcours controller, boundary, interactor, entity, gateway |
| 30 min | Comparer les quatre versions | Matrice avantages, coûts et contextes |

## Questions à poser

1. Quelle classe décide qu'une salle est trop petite ?
2. Peut-on tester cette règle sans démarrer Spring ?
3. Quel composant faudrait-il modifier pour remplacer PostgreSQL ?
4. Quel composant faudrait-il modifier pour ajouter une entrée en ligne de commande ?
5. Une dépendance du cœur pointe-t-elle vers un framework ?
6. Quelle version paraît disproportionnée pour cette application et pourquoi ?

## Manipulation courte par version

Dans chaque projet, ajoutez la règle suivante : une réservation ne peut pas dépasser quatre heures. Comparez le nombre de fichiers touchés, la facilité du test et l'emplacement choisi. L'objectif n'est pas d'obtenir le même nombre de modifications, mais de justifier la responsabilité qui porte la règle.

## Conclusion attendue

Les couches réduisent le coût initial. Le monolithe modulaire protège surtout les frontières métier. L'hexagonale protège le cœur à l'aide de ports et d'adaptateurs. La Clean Architecture formalise plus finement les cas d'utilisation et leurs frontières. Ces approches répondent à des coûts de changement différents.
