package dev.lxqtpr.lindaCodeGeneration.Templates;

import static dev.lxqtpr.lindaCodeGeneration.Utils.GenerateClassNameAndPackages.*;

public class ServiceTemplate {
    public static String getServiceTemplate(String entityName){
        var className = generateClassName(entityName, ClassTypes.Service);
        var packageName = generatePackageName(entityName);
        var repositoryName = generateClassName(entityName, ClassTypes.Repository);
        return "package " + packageName +";\n" +
                "\n" +
                "import " + packageName+"."+repositoryName + ";\n" +
                "import lombok.RequiredArgsConstructor;\n" +
                "import org.springframework.stereotype.Service;\n" +
                "@Service\n" +
                "@RequiredArgsConstructor\n" +
                "public class " + className + "{\n" +
                "    private final " + repositoryName + " " + lowerFirstLatter(repositoryName) + ";\n" +
                "}";
    }
}
