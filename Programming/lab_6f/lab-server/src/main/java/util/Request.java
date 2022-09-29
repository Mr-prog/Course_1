package util;

import content.City;

import java.io.Serializable;

public class Request implements Serializable {
    private static final long serialVersionUID = 322L;
    private String command;
    private String arg;
    private City obj;

    public Request(String command) {
        this.command = command;
    }

    public Request(String command, String arg) {
        this.command = command;
        this.arg = arg;
    }

    public Request(String command, String arg, City obj) {
        this.command = command;
        this.arg = arg;
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "Request{" +
                "command='" + command + '\'' +
                ", arg='" + arg + '\'' +
                ", obj=" + obj +
                '}';
    }

    public String getCommand() {
        return command;
    }

    public String getArg() {
        return arg;
    }

    public City getObj() {
        return obj;
    }
}
