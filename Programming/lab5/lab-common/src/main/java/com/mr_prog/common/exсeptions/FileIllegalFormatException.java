package com.mr_prog.common.exсeptions;

public class FileIllegalFormatException extends FileException {
    public FileIllegalFormatException(){
        super("Illegal format file");
    }
}
