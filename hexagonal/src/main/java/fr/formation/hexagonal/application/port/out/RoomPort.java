package fr.formation.hexagonal.application.port.out;
import fr.formation.hexagonal.domain.Room; import java.util.*; public interface RoomPort { Room save(Room room); Optional<Room> find(UUID id); List<Room> findAll(); }
