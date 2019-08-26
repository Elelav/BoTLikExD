/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botlik;

import java.nio.charset.Charset;

/**
 *
 * @author Elelav
 */
public class Botlik {

    /**
     * @param args the command line arguments
     */


    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(Charset.defaultCharset());
        System.setProperty("file.encoding", "UTF-8");
        botlikMind bm = new botlikMind();
        bm.connect();
    }
}
