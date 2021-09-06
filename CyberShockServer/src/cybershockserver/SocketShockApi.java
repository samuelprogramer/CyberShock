package cybershockserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Samuel Lisboa
 * samuellisboa97@gmail.com
 * startscode.com.br
 * File: 05/09/2021
 *
 */
public class SocketShockApi {
    /**
     * 
     * @param ComandoServer<br>
     * Get - para pegar informacao
     * Set - para clocar informaçoes
     * 
     * 
     * @return<br>
     * Resposta do server
     * 
     * 
     * @throws IOException 
     */
    String send(String ComandoServer, String ID_userAtac) throws IOException{
        String comand = ComandoServer+"<shock>"+ID_userAtac;
        Socket client = new Socket("starts.sytes.net",4600);
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream(),"UTF-8"));
        out.println(comand);
        String Result = input.readLine();
        out.close();
        input.close();
        return Result;
    }
}
