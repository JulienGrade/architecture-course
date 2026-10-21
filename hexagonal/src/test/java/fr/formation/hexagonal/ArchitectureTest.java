package fr.formation.hexagonal;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses; import com.tngtech.archunit.core.importer.ClassFileImporter; import org.junit.jupiter.api.Test;
class ArchitectureTest { @Test void domainHasNoFrameworkDependency(){var c=new ClassFileImporter().importPackages("fr.formation.hexagonal");noClasses().that().resideInAPackage("..domain..").should().dependOnClassesThat().resideInAnyPackage("org.springframework..","jakarta.persistence..").check(c);} }
