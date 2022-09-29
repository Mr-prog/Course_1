import util.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Server {
    public static void main(String[] args) throws IOException{

        InternetManager net = null;
        try {
            net = new InternetManager(Integer.parseInt(args[1]));
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Неверно указан порт");
            System.exit(1);
        }
        net.init();
        FileManager fileManager;
        CommandManager commandManager = null;
        CollectionManager collectionManager = null;

        try {
            fileManager = new FileManager(args[0]); //args[0]
            collectionManager = new CollectionManager(fileManager);
            commandManager = new CommandManager(collectionManager);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Файл не найден");
            System.exit(1);
        }

        Request req;
        while (true) {
            if (System.in.available() > 0) {
                if (new Scanner(System.in).nextLine().trim().equals("save")) {
                    collectionManager.save();
                }
            }

            net.getSelector().select(500);
            Set keys = net.getSelector().selectedKeys();
            Iterator i = keys.iterator();
            while (i.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) i.next();
                i.remove();
                Accepter acc = new Accepter(net);
                acc.accept(selectionKey);
                Receiver receiver = new Receiver(net);
                if (selectionKey.isReadable()) {
                    SocketChannel sc = (SocketChannel) selectionKey.channel();
                    receiver.init(sc);
                    try {
                        if (receiver.isAvailable()) {
                            req = receiver.read();
                            if (req != null) {
                                String res = commandManager.runPrepared(req);
                                Response resp = new Response(res);
                                Sender.send(resp, sc);
                            }
                        }
                    } catch (IOException e) {
                        collectionManager.save();
                        selectionKey.cancel();
                    }
                }
            }
        }
    }
}
