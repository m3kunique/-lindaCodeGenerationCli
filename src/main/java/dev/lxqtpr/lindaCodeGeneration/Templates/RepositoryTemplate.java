package dev.lxqtpr.lindaCodeGeneration.Templates;

import static dev.lxqtpr.lindaCodeGeneration.Utils.GenerateClassNameAndPackages.generateClassName;
import static dev.lxqtpr.lindaCodeGeneration.Utils.GenerateClassNameAndPackages.generatePackageName;

public class RepositoryTemplate {
    public static String getRepositoryTemplate(String entityName){
        var className = generateClassName(entityName, ClassTypes.Repository);
        var packageName = generatePackageName(entityName);
        var entity =  generateClassName(entityName, ClassTypes.Entity);
        return "package " +packageName + ";\n" +
                "import org.springframework.data.jpa.repository.JpaRepository;\n" +
                "\n" +
                "public interface "+ className + " extends JpaRepository<" + entity +", Long> {\n" +
                "}";
    }
}
