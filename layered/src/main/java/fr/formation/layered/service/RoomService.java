package fr.formation.layered.service;
import fr.formation.layered.entity.RoomEntity;
import fr.formation.layered.repository.RoomRepository;
import java.util.List; import java.util.UUID;
import org.springframework.stereotype.Service;
@Service
public class RoomService {
    private final RoomRepository repository;
    public RoomService(RoomRepository repository){this.repository=repository;}
    public RoomEntity create(String name,int capacity){ if(name==null||name.isBlank()||capacity<1) throw new BusinessException("Invalid room"); return repository.save(new RoomEntity(UUID.randomUUID(),name.trim(),capacity)); }
    public List<RoomEntity> list(){return repository.findAll();}
}
