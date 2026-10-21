package fr.formation.layered.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity @Table(name="reservations")
public class ReservationEntity {
    @Id private UUID id;
    private UUID roomId;
    private String organizerEmail;
    private int participants;
    private LocalDateTime startsAt;
    private LocalDateTime endsAt;
    @Enumerated(EnumType.STRING) private Status status;
    protected ReservationEntity() {}
    public ReservationEntity(UUID id, UUID roomId, String organizerEmail, int participants, LocalDateTime startsAt, LocalDateTime endsAt){
        this.id=id; this.roomId=roomId; this.organizerEmail=organizerEmail; this.participants=participants; this.startsAt=startsAt; this.endsAt=endsAt; this.status=Status.CONFIRMED;
    }
    public void cancel(){ status=Status.CANCELLED; }
    public UUID getId(){return id;} public UUID getRoomId(){return roomId;} public String getOrganizerEmail(){return organizerEmail;} public int getParticipants(){return participants;} public LocalDateTime getStartsAt(){return startsAt;} public LocalDateTime getEndsAt(){return endsAt;} public Status getStatus(){return status;}
    public enum Status { CONFIRMED, CANCELLED }
}
