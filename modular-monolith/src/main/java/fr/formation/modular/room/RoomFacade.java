package fr.formation.modular.room;
import java.util.List; import java.util.UUID;
public interface RoomFacade { RoomView create(String name,int capacity); RoomView require(UUID id); List<RoomView> list(); record RoomView(UUID id,String name,int capacity){} }
