# Architecture hexagonale

Le cœur contient le domaine, les cas d'utilisation et les ports. Les adaptateurs Web, JPA et notification sont placés à l'extérieur. Spring assemble le tout dans la classe de démarrage.

`ReservationServiceTest` exécute une règle complète sans contexte Spring, serveur HTTP ou base de données. `ArchitectureTest` interdit au domaine de dépendre du framework.
