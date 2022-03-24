package com.mr_prog.common.io;

public interface ReaderWriter {
    public void setPath(String pth);

    public String read();

    public boolean write(String data);
}
