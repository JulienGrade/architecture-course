package fr.formation.modular.room;
import fr.formation.modular.shared.*; import jakarta.persistence.*; import java.util.*; import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Service;
@Service class RoomModule implements RoomFacade {
 private final RoomJpaRepository repository; RoomModule(RoomJpaRepository repository){this.repository=repository;}
 public RoomView create(String name,int capacity){if(name==null||name.isBlank()||capacity<1)throw new BusinessException("Invalid room");return view(repository.save(new RoomRecord(UUID.randomUUID(),name.trim(),capacity)));}
 public RoomView require(UUID id){return repository.findById(id).map(this::view).orElseThrow(()->new NotFoundException("Room not found"));}
 public List<RoomView> list(){return repository.findAll().stream().map(this::view).toList();} private RoomView view(RoomRecord r){return new RoomView(r.id,r.name,r.capacity);}
}
interface RoomJpaRepository extends JpaRepository<RoomRecord,UUID>{}
@Entity @Table(name="rooms") class RoomRecord { @Id UUID id; String name; int capacity; protected RoomRecord(){} RoomRecord(UUID id,String name,int capacity){this.id=id;this.name=name;this.capacity=capacity;} }
