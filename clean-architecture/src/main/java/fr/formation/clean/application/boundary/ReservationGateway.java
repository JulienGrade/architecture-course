package fr.formation.clean.application.boundary;
import fr.formation.clean.domain.entity.Reservation;import java.time.LocalDateTime;import java.util.*;public interface ReservationGateway{Reservation save(Reservation reservation);Optional<Reservation> findById(UUID id);boolean hasOverlap(UUID roomId,LocalDateTime startsAt,LocalDateTime endsAt);}
