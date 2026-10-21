package fr.formation.layered;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses; import com.tngtech.archunit.core.importer.ClassFileImporter; import org.junit.jupiter.api.Test;
class ArchitectureTest { @Test void repositoriesDoNotDependOnControllers(){var classes=new ClassFileImporter().importPackages("fr.formation.layered");noClasses().that().resideInAPackage("..repository..").should().dependOnClassesThat().resideInAPackage("..controller..").check(classes);} }
