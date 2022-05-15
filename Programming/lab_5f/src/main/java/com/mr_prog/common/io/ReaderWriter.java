package com.mr_prog.common.io;

import com.mr_prog.common.exсeptions.CannotCreateFileException;

import java.io.File;

public interface ReaderWriter {
    public void setPath(String path);

    public String read();

    public boolean write(String data);
}