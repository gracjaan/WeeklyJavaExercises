package ss.week7.cmdline;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Peer for a simple client-server application
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Peer implements Runnable {
    public static final String EXIT = "exit";

    protected String name;
    protected Socket sock;
    protected BufferedReader in;
    protected BufferedWriter out;


    /**
     * @requires (nameArg != null) && (sockArg != null) 
     * @param   nameArg name of the Peer process
     * @param   sockArg Socket of the Peer process
     */
    public Peer(String nameArg, Socket sockArg) throws IOException {
        this.name = nameArg;
        this.sock = sockArg;
        this.in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        this.out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
    }

    /**
     * Reads strings of the stream of the socket connection and
     * writes the characters to the default output.
     */
    public void run() {
        Scanner scan = new Scanner(in);
        while (scan.hasNext()){
            System.out.println(scan.nextLine());
        }
    }

    /**
     * Reads a string from the console and sends this string over
     * the socket-connection to the Peer process.
     * On Peer.EXIT the method ends
     */
    public void handleTerminalInput() {
        Scanner scan = new Scanner(in);
        while (scan.hasNext()){
            String line = scan.nextLine();
            try {
                if (line.equals("exit")) {
                    out.flush();
                }
                out.write(line);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Closes the connection, the sockets will be terminated
     */
    public void shutDown() {
        try {
            sock.close();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**  returns name of the peer object*/
    public String getName() {
        return name;
    }

    /** read a line from the default input */
    static public String readString(String text) {
        System.out.print(text);
        String antw = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            antw = in.readLine();
        } catch (IOException e) {
        }

        return (antw == null) ? "" : antw;
    }
}
