
package br.edu.ifpb.pod.data.based.architecture.client.one;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author miolivc
 */
public class Comunication  {
    private static final String HOST = "localhost"; // endereço para o qual a mensagem sera envada
    private static final Integer PORT = 10999; // porta para o qual a mensagem sera envada

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(HOST,PORT); //cria uma conexao
        String message = JOptionPane.showInputDialog("Digite sua mensagem:");

        System.out.println(message);
        
        // Transforma a mensagem num array de bytes
        OutputStream outputStream = socket.getOutputStream();
        byte[] b = new byte[1024];
        b = message.getBytes();

        // envia para o destinatario 
        outputStream.write(b);

        //recupera as respostas 

        socket.close();

    }
    
}
