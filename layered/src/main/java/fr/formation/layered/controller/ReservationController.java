package fr.formation.layered.controller;
import fr.formation.layered.entity.ReservationEntity; import fr.formation.layered.service.ReservationService; import java.time.LocalDateTime; import java.util.UUID; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/reservations")
public class ReservationController {
 private final ReservationService service; public ReservationController(ReservationService service){this.service=service;}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) ReservationEntity create(@RequestBody CreateReservationRequest r){return service.create(r.roomId(),r.organizerEmail(),r.participants(),r.startsAt(),r.endsAt());}
 @GetMapping("/{id}") ReservationEntity get(@PathVariable UUID id){return service.get(id);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) void cancel(@PathVariable UUID id){service.cancel(id);}
 public record CreateReservationRequest(UUID roomId,String organizerEmail,int participants,LocalDateTime startsAt,LocalDateTime endsAt){}
}
