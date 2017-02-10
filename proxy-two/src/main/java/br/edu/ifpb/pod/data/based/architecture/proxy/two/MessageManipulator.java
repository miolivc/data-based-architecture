
package br.edu.ifpb.pod.data.based.architecture.proxy.two;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Faz a escrita e leitura de mensagens
 * @author miolivc
 */
public class MessageManipulator {
    File arquivo;
    
    /**
     * persiste a mensagem do client-one para client-two no arquivo messages-n1-n2.txt
     * @param message 
     * @throws java.io.IOException 
     */
    public void escreve(String message) throws IOException{
        this.arquivo = new File("/home/miolivc/messages/messages-n1-n2.txt");
        if(! arquivo.exists()){
            arquivo.createNewFile();
        }
        
        FileWriter fileWriter = new FileWriter(arquivo, true); // permite escrever num arquivo
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        
        bufferedWriter.write(message);
        bufferedWriter.newLine();
        
        bufferedWriter.close();
        fileWriter.close();
    }
    
    /**
     * le as mensagens escritas de client-two para client-one no arquivo messages-n2-n1.txt
     * @return String[]
     * @throws java.io.FileNotFoundException
     */
    public StringBuilder leitura() throws FileNotFoundException, IOException{
        this.arquivo = new File("/home/miolivc/messages/messages-n2-n1.txt");
        if(! arquivo.exists()){
            arquivo.createNewFile();
        }
        
        FileReader fileReader = new FileReader(arquivo);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        
        while(bufferedReader.ready()){
            String linha = bufferedReader.readLine();
            stringBuilder.append(linha);
        }
        return stringBuilder;
    }
}
