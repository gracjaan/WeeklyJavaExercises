package ss.week7.cmdline;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Client class for a simple client-server application
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Client {
    private static final String USAGE
        = "usage: java week7.cmdline.Client <name> <address> <port>";

    /** Starts a Client application. */
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println(USAGE);
            System.exit(0);
        }

        String name = args[0];
        InetAddress addr = null;
        int port = 0;
        ServerSocket serverSock = null;

        // check args[1] - the IP-adress
        try {
            addr = InetAddress.getByName(args[1]);
        } catch (UnknownHostException e) {
            System.out.println(USAGE);
            System.out.println("ERROR: host " + args[1] + " unknown");
            System.exit(0);
        }

        // parse args[2] - the port
        try {
            port = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println(USAGE);
            System.out.println("ERROR: port " + args[2]
                    + " is not an integer");
            System.exit(0);
        }

        // try to open a ServerSocket
        try {
            serverSock = new ServerSocket(port, 0, addr);
        } catch (IOException e) {
            System.out.println("ERROR: could not create a server socket on " + addr
                    + " and port " + port);
        }

        while (true) {
            Socket clientSock = null;
            try {
                // wait for a client to connect
                clientSock = serverSock.accept();
            } catch (IOException e) {
                System.out.println("ERROR: failed to accept connection from client");
            }

            // create Peer object for client and start the two-way communication
            try {
                Peer client = new Peer(name, clientSock);
                Thread streamInputHandler = new Thread(client);
                streamInputHandler.start();
                client.handleTerminalInput();
                client.shutDown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


} // end of class Client


/**
 * Answer to 7.5
 * It looks like the Peer class is not closing the Socket and the associated streams (e.g., the InputStream and OutputStream) when the shutDown method is called. As a result, the Peer process does not close completely when the other Peer sends the EXIT message. To fix it , surround sock.close with try-catch block
 * */
