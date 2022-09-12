import exceptions.NetException;
import util.CommandManager;
import util.IOManager;
import util.InternetManager;
import util.Request;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.NoSuchElementException;

public class Client {
    public static void main(String[] args) {
        CommandManager cm = new CommandManager();
        IOManager io = new IOManager();
        InternetManager net = null;
        try {
            net = new InternetManager(InetAddress.getLoopbackAddress(), Integer.parseInt(args[0]));
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Неверно указан порт");
            System.exit(1);
        }
        if (!net.connect()) {
            System.out.println("\u001B[31m" + "Сервер не отвечает" + "\u001B[0m");
            while (!net.connect()) {
            }
        }


        while (true) {
            Request res = null;
            try {
                String[] arr = io.promptArgs();

                res = cm.run(arr);
                if (res != null) {
                    System.out.println(net.exchange(res));
                }
                if (arr[0].equals("exit")) {
                    net.close();
                    break;
                }
            } catch (NoSuchElementException e) {
                System.out.println("\u001B[31m" + "Нажат Ctrl+D - выхожу из программы" + "\u001B[0m");
                System.exit(0);
            } catch (NetException e) {
                System.out.println("\u001B[31m" + e.getMessage() + "\u001B[0m");
                resend(res, net);
            } catch (NullPointerException e) {
                System.out.println("\u001B[31mОшибка отправки\u001B[0m");
                resend(res, net);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    private static void resend(Request res, InternetManager net) {
        System.out.println("Попытка переподключения");
        while (!net.connect()) {
        }
        try {
            System.out.println("Повторная отправка");
            net.exchange(res);
        } catch (NetException | ClassNotFoundException | IOException ex) {
            System.out.println("\u001B[31m" + "Ошибка при повторной отправке" + "\u001B[0m");
        }

    }
}
