package fr.formation.hexagonal.application.service;
import fr.formation.hexagonal.application.port.in.*; import fr.formation.hexagonal.application.port.out.*; import fr.formation.hexagonal.domain.*; import java.util.UUID;
public final class ReservationService implements CreateReservationUseCase,CancelReservationUseCase {
 private final RoomPort rooms; private final ReservationPort reservations; private final NotificationPort notifications;
 public ReservationService(RoomPort rooms,ReservationPort reservations,NotificationPort notifications){this.rooms=rooms;this.reservations=reservations;this.notifications=notifications;}
 public Reservation create(Command c){var room=rooms.find(c.roomId()).orElseThrow(()->new ResourceNotFound("Room not found"));if(!room.canHost(c.participants()))throw new BusinessRuleViolation("Room capacity exceeded");var reservation=new Reservation(UUID.randomUUID(),c.roomId(),c.organizerEmail(),c.participants(),c.startsAt(),c.endsAt(),Reservation.Status.CONFIRMED);if(reservations.overlaps(c.roomId(),c.startsAt(),c.endsAt()))throw new BusinessRuleViolation("Room unavailable");var saved=reservations.save(reservation);notifications.reservationConfirmed(c.organizerEmail());return saved;}
 public void cancel(UUID id){var reservation=reservations.find(id).orElseThrow(()->new ResourceNotFound("Reservation not found"));reservations.save(reservation.cancel());}
}
