
package br.edu.ifpb.pod.data.based.architecture.proxy.two;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author miolivc
 */
public class MessageReader implements Runnable {
    private MessageManipulator messageManipulator;
    
    @Override
    public void run(){
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(10998));

            Socket socket = serverSocket.accept();

            StringBuilder sb = messageManipulator.leitura();
            OutputStream outputStream = socket.getOutputStream();

            byte[] b = new byte[1024];
            b = sb.toString().getBytes();
            outputStream.write(b);

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
