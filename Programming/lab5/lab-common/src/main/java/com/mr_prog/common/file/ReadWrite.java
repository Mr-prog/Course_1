package com.mr_prog.common.file;

public interface ReadWrite {
    public void setPath(String path);

    public String read();

    public boolean write(String data);
}
