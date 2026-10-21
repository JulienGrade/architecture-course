# Architecture en couches

La requête traverse `controller`, `service`, puis `repository`. Les entités JPA sont partagées entre les couches, ce qui rend la version courte et familière mais couple fortement le modèle au stockage.

## Règles

- Un contrôleur dépend uniquement d'un service.
- Un service contient l'orchestration et les règles métier.
- Un service accède aux données par un repository.
- Un repository ne dépend pas des couches supérieures.

## Observation guidée

Suivez `POST /api/reservations`. Repérez que `ReservationService` dépend directement de Spring Data, des entités JPA et du service technique de notification. Essayez ensuite d'imaginer son test sans Spring : ce coût est l'une des limites étudiées.
