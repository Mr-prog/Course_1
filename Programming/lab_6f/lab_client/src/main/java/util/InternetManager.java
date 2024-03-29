package util;

import exceptions.NetException;

import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;

public class InternetManager {

    private int port;
    InetAddress host;
    public Socket sock;
    public OutputStream os;
    public InputStream is;

    public static InternetManager net;

    public InternetManager(InetAddress host, int port) {
        this.host = host;
        this.port = port;
        this.net = this;
    }

    public static InternetManager get() {
        return net;
    }

    public boolean connect() {
        try {
            sock = new Socket(host, port);
            os = sock.getOutputStream();
            is = sock.getInputStream();
            System.out.println("Connected");
            return true;
        } catch (ConnectException e) {
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("Неверно указан порт");
            System.exit(1);
            return false;
        } catch (IOException | NullPointerException e) {
            return false;
        }
    }

    public void send(Request req) throws NetException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(req);
        try {
            os.write(baos.toByteArray());
        } catch (SocketException e) {
            throw new NetException("Ошибка подключения: " + e.getLocalizedMessage());
        } catch (IOException e) {
            throw new NetException("Ошибка IO: " + e.getLocalizedMessage());
        }
    }

    public Response read() throws ClassNotFoundException {
        try {
            ByteBuffer buf = ByteBuffer.allocate(1024 * 128);
            is.read(buf.array());
            ByteArrayInputStream bais = new ByteArrayInputStream(buf.array());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (Response) ois.readObject();
        } catch (java.io.IOException e) {
            System.out.println("Ошибка чтения");
        }
        return null;
    }


    public void close() throws IOException {
        os.close();
        is.close();
        sock.close();
    }

    public String exchange(Request res) throws NetException, IOException, ClassNotFoundException {
        this.send(res);
        String msg = ((Response) this.read()).getMsg();
        return msg;
    }
}
