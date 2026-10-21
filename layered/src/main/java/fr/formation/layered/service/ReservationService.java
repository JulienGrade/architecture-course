package fr.formation.layered.service;
import fr.formation.layered.entity.*; import fr.formation.layered.repository.*;
import java.time.LocalDateTime; import java.util.UUID; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
@Service
public class ReservationService {
    private final RoomRepository rooms; private final ReservationRepository reservations; private final NotificationService notifications;
    public ReservationService(RoomRepository rooms,ReservationRepository reservations,NotificationService notifications){this.rooms=rooms;this.reservations=reservations;this.notifications=notifications;}
    @Transactional public ReservationEntity create(UUID roomId,String email,int participants,LocalDateTime startsAt,LocalDateTime endsAt){
        var room=rooms.findById(roomId).orElseThrow(()->new NotFoundException("Room not found"));
        if(email==null||email.isBlank()||participants<1||startsAt==null||endsAt==null||!startsAt.isBefore(endsAt)) throw new BusinessException("Invalid reservation");
        if(participants>room.getCapacity()) throw new BusinessException("Room capacity exceeded");
        if(reservations.existsByRoomIdAndStatusAndStartsAtLessThanAndEndsAtGreaterThan(roomId,ReservationEntity.Status.CONFIRMED,endsAt,startsAt)) throw new BusinessException("Room unavailable");
        var saved=reservations.save(new ReservationEntity(UUID.randomUUID(),roomId,email,participants,startsAt,endsAt)); notifications.confirmed(email); return saved;
    }
    public ReservationEntity get(UUID id){return reservations.findById(id).orElseThrow(()->new NotFoundException("Reservation not found"));}
    @Transactional public void cancel(UUID id){var reservation=get(id);reservation.cancel();}
}
