# Monolithe modulaire

Le projet reste un seul déploiement, mais son unité principale est le domaine fonctionnel. Les classes internes d'un module sont package-private. Seule une façade publique peut être appelée par un autre module.

Le module `reservation` connaît `RoomFacade`, mais ne connaît ni `RoomRecord` ni `RoomJpaRepository`. Le test ArchUnit matérialise cette frontière.
