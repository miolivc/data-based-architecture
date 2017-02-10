
package br.edu.ifpb.pod.data.based.architecture.client.one;

import java.io.IOException;
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
        while(true){
            Socket socket = new Socket(HOST,PORT); //cria uma conexao
            String message = JOptionPane.showInputDialog("Digite sua mensagem:");
        
            // Transforma a mensagem num array de bytes
            byte[] b = new byte[1024];
            b = message.getBytes(message);
        
            // envia para o destinatario 
            socket.getOutputStream().write(b);
        
            //recupera as respostas 
        
            socket.close();
        
        }
    }
}
