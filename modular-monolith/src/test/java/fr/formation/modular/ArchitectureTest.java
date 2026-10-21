package fr.formation.modular;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses; import com.tngtech.archunit.core.importer.ClassFileImporter; import org.junit.jupiter.api.Test;
class ArchitectureTest { @Test void reservationDoesNotAccessRoomInternals(){var c=new ClassFileImporter().importPackages("fr.formation.modular");noClasses().that().resideInAPackage("..reservation..").should().dependOnClassesThat().haveSimpleName("RoomRecord").check(c);} }
