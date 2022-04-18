package com.mr_prog.common.file;

import com.mr_prog.common.exсeptions.CannotCreateFileException;

import java.io.File;

public interface ReadWrite {
    public void setPath(String path);

    public String read();

    public boolean write(String data);

    public void create(File file) throws CannotCreateFileException;
}
