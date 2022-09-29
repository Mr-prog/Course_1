package server.util;

import server.data.City;

import java.io.*;
import java.util.Hashtable;

public class FileManager {
    private Hashtable<Integer, City> collection;
    private String src;


    public FileManager(String src) {
        this.src = src;
        collection = makeCollection(src);
    }

    private Hashtable<Integer, City> makeCollection(String src) {
        Hashtable<Integer, City> collection;
        read(src);
        String[] data = src.split("[,|\n]");

    }

    public String read(String path) {
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
}
