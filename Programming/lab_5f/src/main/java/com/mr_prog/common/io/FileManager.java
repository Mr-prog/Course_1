package com.mr_prog.common.io;

import com.mr_prog.common.exсeptions.*;


import java.io.*;

import static com.mr_prog.common.io.OutputManager.print;
import static com.mr_prog.common.io.OutputManager.printErr;

public class FileManager implements ReaderWriter {
    private InputStream inputStream;
    private String path;

    public FileManager(String path) {
        this.path = path;
    }

    public FileManager() {
        path = null;
    }


    @Override
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * save collection
     * @return
     */
    @Override
    public String read() {
        StringBuilder str = new StringBuilder();
        try {
            if (path == null) throw new EmptyPathException();
            InputStreamReader reader = null;

            File file = new File(path);
            if (!file.exists()) throw new FileNotExistException();
            if (!file.canRead()) throw new FileDenialException("cannot read file");
            inputStream = new FileInputStream(file);
            reader = new InputStreamReader(inputStream);

            int correctSymbol;
            while ((correctSymbol = reader.read()) != -1) {
                str.append((char) correctSymbol);
            }
            reader.close();
        } catch (FileException e) {
            printErr(e.getMessage());
            System.exit(0);
        } catch (IOException e) {
            printErr("cannot access file");
            System.exit(0);
        }
        return str.toString();
    }

    /**
     * create file
     * @param file
     * @throws CannotCreateFileException
     */
    public void create(File file) throws CannotCreateFileException {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new CannotCreateFileException();
        }
    }

    /**
     * save data in file
     * @param data
     * @return
     */
    @Override
    public boolean write(String data) {
        boolean res = true;
        try {
            if (path == null) throw new EmptyPathException();

            File file = new File(path);

            if (!file.exists()) {
                print("file " + path + " doesnt exist, trying to create new file");
                create(file);
            }
            if (!file.canWrite()) throw new FileDenialException("cannot write file");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(data);
            writer.close();
        } catch (FileException e) {
            printErr(e.getMessage());
            res = false;
        } catch (IOException e) {
            res = false;
            printErr("cannot access file");
        }
        return res;
    }
}
