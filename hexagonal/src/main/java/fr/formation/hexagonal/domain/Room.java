package fr.formation.hexagonal.domain;
import java.util.UUID;
public record Room(UUID id,String name,int capacity) { public Room { if(id==null||name==null||name.isBlank()||capacity<1)throw new BusinessRuleViolation("Invalid room"); } public boolean canHost(int participants){return participants>0&&participants<=capacity;} }
