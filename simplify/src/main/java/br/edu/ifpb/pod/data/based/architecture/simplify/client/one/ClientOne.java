
package br.edu.ifpb.pod.data.based.architecture.simplify.client.one;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author miolivc
 */
public class ClientOne {
    
    public static void main(String[] args) throws IOException {
        
        String message = JOptionPane.showInputDialog("Digite sua mensagem para enviar para o cliente 2:");
    
        MessagePersistOne messagePersistOne = new MessagePersistOne();
        messagePersistOne.escreve(message);
        
        StringBuilder stringBuilder = messagePersistOne.leitura();
        
        System.out.println("Mensagens recebidas:" + stringBuilder.toString());
    }
    
}
