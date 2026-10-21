# Contrat fonctionnel commun

## Endpoints

| Méthode | URI | Résultat |
|---|---|---|
| `POST` | `/api/rooms` | Crée une salle |
| `GET` | `/api/rooms` | Liste les salles |
| `POST` | `/api/reservations` | Crée une réservation |
| `GET` | `/api/reservations/{id}` | Consulte une réservation |
| `DELETE` | `/api/reservations/{id}` | Annule une réservation |

## Création d'une salle

```json
{"name":"Ada","capacity":12}
```

## Création d'une réservation

```json
{
  "roomId":"00000000-0000-0000-0000-000000000001",
  "organizerEmail":"ada@example.com",
  "participants":8,
  "startsAt":"2030-01-15T09:00:00",
  "endsAt":"2030-01-15T11:00:00"
}
```

Les erreurs métier utilisent le statut `422`, les ressources absentes `404` et les données syntaxiquement invalides `400`.
