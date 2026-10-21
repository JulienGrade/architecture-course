package fr.formation.layered.repository;
import fr.formation.layered.entity.RoomEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {}
