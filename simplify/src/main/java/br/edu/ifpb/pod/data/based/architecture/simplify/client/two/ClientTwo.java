/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.data.based.architecture.simplify.client.two;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author miolivc
 */
public class ClientTwo {
    public static void main(String[] args) throws IOException {
        
        String message = JOptionPane.showInputDialog("Digite sua mensagem para enviar para o cliente 1:");
    
        MessagePersistTwo messagePersistTwo = new MessagePersistTwo();
        messagePersistTwo.escreve(message);
        
        StringBuilder stringBuilder = messagePersistTwo.leitura();
        
        System.out.println("Mensagens recebidas:" + stringBuilder.toString());
//        for(int i = 0; i < stringBuilder.length(); i++){
//            System.out.format("A mensagem de numero %d eh: %s", i, stringBuilder.);
//        }
    
    }
}
