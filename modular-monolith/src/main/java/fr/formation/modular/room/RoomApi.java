package fr.formation.modular.room;
import java.util.List; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/rooms") class RoomApi { private final RoomFacade rooms; RoomApi(RoomFacade rooms){this.rooms=rooms;} @PostMapping @ResponseStatus(HttpStatus.CREATED) RoomFacade.RoomView create(@RequestBody Request r){return rooms.create(r.name(),r.capacity());} @GetMapping List<RoomFacade.RoomView> list(){return rooms.list();} record Request(String name,int capacity){} }
