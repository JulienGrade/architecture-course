package fr.formation.layered.controller;
import fr.formation.layered.entity.RoomEntity; import fr.formation.layered.service.RoomService; import java.util.*; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/rooms")
public class RoomController {
 private final RoomService service; public RoomController(RoomService service){this.service=service;}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) RoomEntity create(@RequestBody CreateRoomRequest r){return service.create(r.name(),r.capacity());}
 @GetMapping List<RoomEntity> list(){return service.list();}
 public record CreateRoomRequest(String name,int capacity){}
}
