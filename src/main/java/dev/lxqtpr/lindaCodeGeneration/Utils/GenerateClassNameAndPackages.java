package dev.lxqtpr.lindaCodeGeneration.Utils;

import dev.lxqtpr.lindaCodeGeneration.Templates.ClassTypes;
import org.atteo.evo.inflector.English;

import java.util.Arrays;
import java.util.Objects;

public class GenerateClassNameAndPackages {
    public static String uppercaseFirstLater(String word){
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
    public static String lowerFirstLatter(String word){
        return word.substring(0, 1).toLowerCase() + word.substring(1);
    }
    public static String generatePluralForm(String entityName){
        return English.plural(entityName);
    }
    public static String generateClassName(String entityName, ClassTypes classTypes){
         return uppercaseFirstLater(entityName) + classTypes;
    }
    public static String generatePackageName(String entityName){
        var path = Arrays.stream(GenerateClassNameAndPackages.class
                .getPackage().getName().split("\\."))
                .filter(el -> !Objects.equals(el, "Utils"))
                .toList();
        return String.join(".", path) + ".Domain." + uppercaseFirstLater(entityName) ;
    }
    public static String generateFileName(String entityName, ClassTypes classTypes){
        return uppercaseFirstLater(entityName) + classTypes + ".java";
    }
}
