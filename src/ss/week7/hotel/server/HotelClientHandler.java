//package ss.week7.hotel.server;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.net.Socket;
//
///**
// * HotelClientHandler for the Hotel Server application.
// * This class can handle the communication with one
// * client.
// *
// * @author Wim Kamerman
// */
//public class HotelClientHandler implements Runnable {
//
//	/** The socket and In- and OutputStreams */
//	private BufferedReader in;
//	private BufferedWriter out;
//	private Socket sock;
//
//	/** The connected HotelServer */
//	private HotelServer srv;
//
//	/** Name of this ClientHandler */
//	private String name;
//
//	/**
//	 * Constructs a new HotelClientHandler. Opens the In- and OutputStreams.
//	 *
//	 * @param sock The client socket
//	 * @param srv  The connected server
//	 * @param name The name of this ClientHandler
//	 */
//	public HotelClientHandler(Socket sock, HotelServer srv, String name) {
//		try {
//			in = new BufferedReader(
//					new InputStreamReader(sock.getInputStream()));
//			out = new BufferedWriter(
//					new OutputStreamWriter(sock.getOutputStream()));
//			this.sock = sock;
//			this.srv = srv;
//			this.name = name;
//		} catch (IOException e) {
//			shutdown();
//		}
//	}
//
//	/**
//	 * Continuously listens to client input and forwards the input to the
//	 * {@link #handleCommand(String)} method.
//	 */
//	public void run() {
//		String msg;
//		try {
//			msg = in.readLine();
//			while (msg != null) {
//				System.out.println("> [" + name + "] Incoming: " + msg);
//				handleCommand(msg);
//				out.newLine();
//				out.flush();
//				msg = in.readLine();
//			}
//			shutdown();
//		} catch (IOException e) {
//			shutdown();
//		}
//	}
//
//	/**
//	 * Handles commands received from the client by calling the according
//	 * methods at the HotelServer. For example, when the message "i Name"
//	 * is received, the method doIn() of HotelServer should be called
//	 * and the output must be sent to the client.
//	 *
//	 * If the received input is not valid, send an "Unknown Command"
//	 * message to the server.
//	 *
//	 * @param msg command from client
//	 * @throws IOException if an IO errors occur.
//	 */
//	private void handleCommand(String msg) throws IOException {
//		// To be implemented
//	}
//
//	/**
//	 * Shut down the connection to this client by closing the socket and
//	 * the In- and OutputStreams.
//	 */
//	private void shutdown() {
//		System.out.println("> [" + name + "] Shutting down.");
//		try {
//			in.close();
//			out.close();
//			sock.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		srv.removeClient(this);
//	}
//}
