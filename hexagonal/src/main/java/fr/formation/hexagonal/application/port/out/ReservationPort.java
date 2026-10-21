package fr.formation.hexagonal.application.port.out;
import fr.formation.hexagonal.domain.Reservation; import java.time.LocalDateTime; import java.util.*; public interface ReservationPort { Reservation save(Reservation reservation); Optional<Reservation> find(UUID id); boolean overlaps(UUID roomId,LocalDateTime startsAt,LocalDateTime endsAt); }
