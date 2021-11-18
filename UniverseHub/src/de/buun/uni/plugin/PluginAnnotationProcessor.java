package de.buun.uni.plugin;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * based on:
 * https://github.com/LordAkkarin/bukkit-plugin-annotations/blob/master/src/main/java/com/torchmind/minecraft/annotation/processor/PluginAnnotationProcessor.java
 */

@SupportedAnnotationTypes({
        "de.buun.uni.plugin.PluginName"
})
public class PluginAnnotationProcessor extends AbstractProcessor {

    private boolean located = false;

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(PluginData.class);
        this.error("Plugin YML Created");
        if(annotatedElements.size() > 1){
            this.error("Found more than one main class!");
            return false;
        }
        if(annotatedElements.size() < 1){
            this.error("Found no main class!");
            return false;
        }

        if(this.located){
            this.error("Class is already located!");
            return false;
        }

        Element mainElement = annotatedElements.iterator().next();
        this.located = true;

        if(!(mainElement instanceof TypeElement mainType)){
            this.error("Element is not a type!");
            return false;
        }

        //Braucht man nicht wirklich da ich nicht dumm programmiere
        if (!(mainType.getEnclosingElement () instanceof PackageElement) && !mainType.getModifiers ().contains (Modifier.STATIC)) {
            this.error ("Main class needs to be a top level class or a static inner class.");
            return false;
        }

        Map<String, Object> pluginYML = setUpData(mainType);

        createYaml(pluginYML);

        return false;
    }

    protected  void error(String message){
        this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, message);
    }

   protected Map<String, Object> setUpData(TypeElement element){
       Map<String, Object> data = new HashMap<>();
       PluginData pluginAnno = element.getAnnotation(PluginData.class);
       data.put("main", element.getQualifiedName().toString()); //Main Path

       data.put("name" , pluginAnno.name());
       data.put("version", pluginAnno.version());

       if (pluginAnno.authors().length == 1) {
           data.put ("author", pluginAnno.authors()[0]);
       } else if (pluginAnno.authors().length > 1) {
           data.put ("authors", pluginAnno.authors());
       }
       return data;
    }

    protected void createYaml(Map<String, Object> data) {
        try{
            FileObject descriptionFile = this.processingEnv.getFiler().createResource(StandardLocation.CLASS_OUTPUT, "", "plugin.yml");
            try (Writer writer = descriptionFile.openWriter()){
                writer.append("#Plugin description is automatically generated from Builders Universe!");
                dump(data, writer);
            }
        }catch (IOException e){
            throw new RuntimeException("Cannot serialize plugin description");
        }
    }

    protected void dump(Map<String, Object> data, Writer writer) throws IOException{
        data.forEach((key, value) -> {
            try {
                writer.append(key)
                        .append(": ")
                        .append(String.valueOf(value))
                        .append("\n");
            }catch (IOException ignored){
                this.error("IOException");
            }
        });
        writer.flush();
    }
}
