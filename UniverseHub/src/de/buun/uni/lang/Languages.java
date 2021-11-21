package de.buun.uni.lang;

import de.buun.uni.io.LanguageFile;

import java.util.HashMap;
import java.util.Map;

public class Languages {

    private final Map<String, LanguageFile> languageFileMap;

    public Languages(){
        this.languageFileMap = new HashMap<>();
    }

    public void addLanguage(LanguageFile file){
        if(languageFileMap.containsValue(file)) return;
        this.languageFileMap.put(file.getLanguage(), file);
    }

    public String getMessage(String lang, String path, Object...args){
        LanguageFile file = this.languageFileMap.get(lang);
        if(file == null) return lang + "." + path;
        return file.getMessage(path, args);
    }
}
