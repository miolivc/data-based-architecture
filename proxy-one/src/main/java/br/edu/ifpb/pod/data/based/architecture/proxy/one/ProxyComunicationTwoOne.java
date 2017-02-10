
package br.edu.ifpb.pod.data.based.architecture.proxy.one;


/**
 * Envia as mensagens de N2 para N1 e faz leitura das mensagens que N1 envia para N2
 * @author miolivc
 */
public class ProxyComunicationTwoOne {

    public static void main(String[] args) {
        
        MessageWriter messageWriter = new MessageWriter();
        MessageReader messageReader = new MessageReader();
        
        Thread threadWriter = new Thread(messageWriter);
        threadWriter.start();
        
        Thread threadReader = new Thread(messageReader);
        threadReader.start();
        
    }
}
