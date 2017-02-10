/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.data.based.architecture.simplify.client.two;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author miolivc
 */
public class MessagePersistTwo {
File arquivo;
    
    /**
     * persiste a mensagem do 2 pro 1
     * @param message 
     * @throws java.io.IOException 
     */
    public void escreve(String message) throws IOException{
        this.arquivo = new File("/home/miolivc/Documents/messages/messages-n2.txt");
        if(! arquivo.exists()){
            arquivo.createNewFile();
        }
        
        System.out.print("entrou e criou arquivo");
        
        FileWriter fileWriter = new FileWriter(arquivo, true); // permite escrever num arquivo
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        
        System.out.println("escrever a mensagem");
        
        bufferedWriter.write(message);
        bufferedWriter.newLine();
        
        bufferedWriter.close();
        fileWriter.close();
    }
    
    /**
     * le as mensagens escritas de 1 para 2
     * @return String[]
     * @throws java.io.FileNotFoundException
     */
    public StringBuilder leitura() throws FileNotFoundException, IOException{
        this.arquivo = new File("/home/miolivc/Documents/messages/messages-n1.txt");
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
