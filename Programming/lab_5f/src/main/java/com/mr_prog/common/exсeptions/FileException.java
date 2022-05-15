package com.mr_prog.common.exсeptions;

import java.io.IOException;

public class FileException extends IOException {
    FileException(String msg) {
        super(msg);
        System.out.println(msg);
        System.exit(0);
    }
}
