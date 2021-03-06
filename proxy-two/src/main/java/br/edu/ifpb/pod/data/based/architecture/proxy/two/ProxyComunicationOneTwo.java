
package br.edu.ifpb.pod.data.based.architecture.proxy.two;


/**
 * Envia as mensagens de N1 para N2 e faz leitura das mensagens que N2 envia para N1
 * @author miolivc
 */
public class ProxyComunicationOneTwo {

    public static void main(String[] args) {
        
        MessageWriter messageWriter = new MessageWriter();
        MessageReader messageReader = new MessageReader();
        
        Thread threadWriter = new Thread(messageWriter);
        threadWriter.start();
        
        Thread threadReader = new Thread(messageReader);
        threadReader.start();
        
    }
}
