package dev.lxqtpr.lindaCodeGeneration.Commands;

import dev.lxqtpr.lindaCodeGeneration.Templates.ClassTypes;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import static dev.lxqtpr.lindaCodeGeneration.Templates.ControllerTemplate.getControllerTemplate;
import static dev.lxqtpr.lindaCodeGeneration.Templates.EntityTemplate.getEntityTemplate;
import static dev.lxqtpr.lindaCodeGeneration.Templates.RepositoryTemplate.getRepositoryTemplate;
import static dev.lxqtpr.lindaCodeGeneration.Templates.ServiceTemplate.getServiceTemplate;
import static dev.lxqtpr.lindaCodeGeneration.Utils.GenerateClassNameAndPackages.*;

@ShellComponent
public class CreateCommand {
    @ShellMethod(key = "create", value = "Generate basic boilerplate code for your backend")
    public String create(@ShellOption String entityName) throws IOException
    {
        var folderPath =  Paths.get(generateCommandsFilePath(entityName));
        Files.createDirectories(folderPath);
        HashMap<String, String> templates = new HashMap<>();

        templates.put(generateFileName(entityName, ClassTypes.Entity), getEntityTemplate(entityName));
        templates.put(generateFileName(entityName, ClassTypes.Controller), getControllerTemplate(entityName));
        templates.put(generateFileName(entityName, ClassTypes.Repository), getRepositoryTemplate(entityName));
        templates.put(generateFileName(entityName, ClassTypes.Service), getServiceTemplate(entityName));

        templates.forEach((key, value) -> {
            try {
                var file = new File(folderPath + "\\" + key);
                try(var fileWriter = new FileWriter(file)) {
                    fileWriter.write(value);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return "Success";
    }
}
