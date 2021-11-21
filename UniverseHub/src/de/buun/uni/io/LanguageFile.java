package de.buun.uni.io;

import java.io.File;

public class LanguageFile extends ReadWriteFile{

    private final String language;

    public LanguageFile(File dir, String language) {
        super(dir.getAbsolutePath() + "\\" + language + ".lang");
        this.language = language;
    }

    public String getMessage(String path, Object...args){
        String text = get(path);
        if(args.length == 0) return text;
        for(int i = 0; i < args.length; i++){
            text = text.replace("<arg" + i + ">", String.valueOf(args[i]));
        }
        return text;
    }

    public String getLanguage(){
        return this.language;
    }


}
