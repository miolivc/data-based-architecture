
package br.edu.ifpb.pod.data.based.architecture.proxy.two;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author miolivc
 */
public class ProxyComunicationOneTwo {
    private MessageManipulator messageManipulator;
    
    private void escreveMensagens() throws IOException{
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
        
    }
   
    private void mostraMensagens() throws IOException{
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
        
    }
    
    public static void main(String[] args) throws IOException {
        
        
    }

}
