
package cybershockserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author Samuel Lisboa
 * samuellisboa97@gmail.com
 * startscode.com.br
 * File: 05/09/2021
 *
 */
public class CyberShockServer {
    public static void main(String[] args) {
        try{
            ServerSocket server = null;
            server = new ServerSocket(4600);
            System.out.println("Server Iniciado");
            while (true) {
                Socket conexao = server.accept();
                new Thread(){
                @Override
                public void run() {
                    super.run(); 
                    try{
                        BufferedReader inFromCliente = new BufferedReader(
                                new InputStreamReader(conexao.getInputStream(),StandardCharsets.UTF_8));
                        PrintWriter out = new PrintWriter(
                                new OutputStreamWriter(conexao.getOutputStream(), StandardCharsets.UTF_8), true);
                        String entradaDados = inFromCliente.readLine();
                        System.out.println(entradaDados);
                        String DADOS[] = entradaDados.split("<shock>");
                        
                        out.println("#resultadook");
                        
                        
                    }catch(Exception e){
                        
                    }
                    
                }
            }.start();
                 
                 
            }
            
            
        }catch(Exception e){
            
        }
    }
    
}
