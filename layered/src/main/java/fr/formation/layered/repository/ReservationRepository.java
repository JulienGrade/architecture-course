package fr.formation.layered.repository;
import fr.formation.layered.entity.ReservationEntity;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReservationRepository extends JpaRepository<ReservationEntity, UUID> {
    boolean existsByRoomIdAndStatusAndStartsAtLessThanAndEndsAtGreaterThan(UUID roomId, ReservationEntity.Status status, LocalDateTime endsAt, LocalDateTime startsAt);
}
