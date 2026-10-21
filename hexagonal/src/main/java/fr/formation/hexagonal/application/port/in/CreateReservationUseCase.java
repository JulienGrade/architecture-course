package fr.formation.hexagonal.application.port.in;
import fr.formation.hexagonal.domain.Reservation; import java.time.LocalDateTime; import java.util.UUID;
public interface CreateReservationUseCase { Reservation create(Command command); record Command(UUID roomId,String organizerEmail,int participants,LocalDateTime startsAt,LocalDateTime endsAt){} }
