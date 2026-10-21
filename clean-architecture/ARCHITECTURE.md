# Clean Architecture

Les entités contiennent les règles les plus stables. Les interactors exécutent les cas d'utilisation à travers des input boundaries et des gateways. Les contrôleurs et la persistance sont des interface adapters.

Cette version formalise davantage les entrées et sorties que la version hexagonale. Comparez `CreateReservationInteractor` à `ReservationService` : l'intention est proche, le vocabulaire et la granularité diffèrent.
