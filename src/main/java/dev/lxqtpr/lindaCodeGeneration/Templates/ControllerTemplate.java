package dev.lxqtpr.lindaCodeGeneration.Templates;

import static dev.lxqtpr.lindaCodeGeneration.Utils.GenerateClassNameAndPackages.*;

public class ControllerTemplate {
    public static String getControllerTemplate(String entityName){
        var className = generateClassName(entityName, ClassTypes.Controller);
        var packageName = generatePackageName(entityName);
        var serviceName = generateClassName(entityName, ClassTypes.Service);

        return "package " + packageName +";\n \n" +
                "\n" +
                "import lombok.RequiredArgsConstructor;\n" +
                "import org.springframework.web.bind.annotation.*;\n \n" +
                "@RestController\n" +
                "@RequestMapping(\"/"+generatePluralForm(entityName)+"\")\n" +
                "@RequiredArgsConstructor\n" +
                "public class " + className + "{\n" +
                "    private final " + serviceName + " "+ lowerFirstLatter(serviceName) + ";\n" +
                "}";
    }
}
