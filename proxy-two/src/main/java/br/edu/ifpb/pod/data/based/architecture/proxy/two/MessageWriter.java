
package br.edu.ifpb.pod.data.based.architecture.proxy.two;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author miolivc
 */
public class MessageWriter implements Runnable{
    MessageManipulator messageManipulator;
    
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(10999));

            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            byte[] b = new byte[1024];
            inputStream.read(b);
            String message = new String(b);

            // Coloca no arquivo as mensagens enviadas de n1 para n2
            messageManipulator.escreve(message);

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
