package com.mr_prog.common.file;

import java.io.InputStream;

public class FileManager implements ReadWrite{
    private InputStream inputStream;
    private String path;

    FileManager (String path){
        this.path = path;
    }


    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String read() {
        return null;
    }

    @Override
    public boolean write(String data) {
        return false;
    }
}
