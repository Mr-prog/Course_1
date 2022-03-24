package com.mr_prog.common.io;

import java.io.*;

public class FileManager implements ReaderWriter{
    private InputStream inputStream;
    private String path;

    public FileManager(String path) {
        this.path = path;
    }

    public FileManager() {
        path = null;
    }

    public void setPath(String pth) {
        path = pth;
    }

    public String read()
    {
        String str = "";
        return str;
    }

    private void create(File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean write(String str){
        boolean res = true;
        return res;
    }
}

