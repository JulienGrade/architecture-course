package fr.formation.clean.domain.entity;
import java.util.UUID; public record Room(UUID id,String name,int capacity){public Room{if(id==null||name==null||name.isBlank()||capacity<1)throw new DomainException("Invalid room");}public boolean accepts(int participants){return participants>0&&participants<=capacity;}}
