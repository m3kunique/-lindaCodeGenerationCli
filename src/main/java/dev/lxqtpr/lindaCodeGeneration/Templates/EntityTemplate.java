package dev.lxqtpr.lindaCodeGeneration.Templates;

import static dev.lxqtpr.lindaCodeGeneration.Utils.GenerateClassNameAndPackages.generateClassName;
import static dev.lxqtpr.lindaCodeGeneration.Utils.GenerateClassNameAndPackages.generatePackageName;

public class EntityTemplate {
    public static String getEntityTemplate(String entityName){
        var className = generateClassName(entityName, ClassTypes.Entity);
        var packageName = generatePackageName(entityName);
        return "package " + packageName + ";\n" +
                "\n" +
                "import jakarta.persistence.*;\n" +
                "import lombok.*;\n" +
                "\n" +
                "\n" +
                "@Entity\n" +
                "@Getter\n" +
                "@Setter\n" +
                "@AllArgsConstructor\n" +
                "@NoArgsConstructor\n" +
                "@Builder\n" +
                "public class " + className + " {\n" +
                "\n" +
                "    @Id\n" +
                "    @GeneratedValue(strategy = GenerationType.IDENTITY)\n" +
                "    private Long id;\n" +
                "}";
    }
}
