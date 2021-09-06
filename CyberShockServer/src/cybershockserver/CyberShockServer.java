
package cybershockserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author Samuel Lisboa
 * samuellisboa97@gmail.com
 * startscode.com.br
 * File: 05/09/2021
 *
 */
public class CyberShockServer {
    
    static int zero = 0;
    static int um = 0;
    
    
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
                        
                        if(DADOS[1].equals("0")){
                            if(DADOS[0].equals("get")){
                                out.println(um);
                            }else if(DADOS[0].equals("set")){
                                try{
                                    zero = Integer.parseInt(DADOS[1]);
                                    out.println("#valorSetOK");
                                }catch(Exception e){
                                    out.println("#invalidValor");
                                }
                               
                            }
                        }else if(DADOS[1].equals("1")){
                            if(DADOS[0].equals("get")){
                                out.println(zero);
                            }else if(DADOS[0].equals("set")){
                                 try{
                                    um = Integer.parseInt(DADOS[1]);
                                    out.println("#valorSetOK");
                                }catch(Exception e){
                                    out.println("#invalidValor");
                                }
                            }
                        }else{
                            out.println("#comandoinvalid");
                        }
                        
                        
                                                
                        
                    }catch(Exception e){
                        
                    }
                    
                }
            }.start();
                 
                 
            }
            
            
        }catch(Exception e){
            
        }
    }
    
    
    
    
    
}
