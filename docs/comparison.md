# Comparer les quatre versions

| Question | Couches | Monolithe modulaire | Hexagonale | Clean Architecture |
|---|---|---|---|---|
| Unité principale | Couche technique | Module métier | Port et adaptateur | Cas d'utilisation et frontière |
| Métier indépendant de Spring | Partiellement | Selon le module | Oui | Oui |
| Persistance abstraite | Repository de service | API interne du module | Port sortant | Gateway de sortie |
| Entrée HTTP | Controller | API du module | Adaptateur entrant | Interface adapter |
| Coût structurel | Faible | Moyen | Moyen à élevé | Élevé |

La version la plus structurée n'est pas automatiquement la meilleure. La décision dépend de la durée de vie, de la complexité métier, des changements attendus, du nombre d'équipes et du coût acceptable.
