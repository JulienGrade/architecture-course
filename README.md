# Architecture interne d'une application Spring Boot

Ce dépôt présente **la même application de réservation de salles** selon quatre architectures. Le contrat HTTP, les règles métier et les scénarios de test restent identiques. Seules l'organisation du code et la direction des dépendances changent.

| Projet | Angle étudié | Port |
|---|---|---:|
| `layered` | Couches techniques | 8081 |
| `modular-monolith` | Modules métier explicites | 8082 |
| `hexagonal` | Ports et adaptateurs | 8083 |
| `clean-architecture` | Entités, cas d'utilisation et frontières | 8084 |

## Fonctionnalités communes

Une salle possède un nom et une capacité. Une réservation possède un organisateur, un nombre de participants et un intervalle de temps. Une réservation est refusée si la salle est trop petite, si son intervalle est invalide ou si elle chevauche une réservation active.

## Lancement

Prérequis : Java 21 et Docker.

```bash
docker compose up -d
./mvnw clean verify
./mvnw -pl layered spring-boot:run
```

Remplacer `layered` par le projet voulu. Chaque application utilise son propre schéma PostgreSQL afin que plusieurs versions puissent fonctionner simultanément.

## Parcours conseillé

Commencez par le même cas d'utilisation dans chaque projet : `CreateReservation`. Relevez son point d'entrée, l'emplacement des règles métier, l'abstraction utilisée pour persister et le nombre de composants dépendant de Spring ou de JPA. Consultez ensuite `docs/comparison.md` et le fichier `ARCHITECTURE.md` du projet.
