package top.dolo.springboot02.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SeverTest {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(10000);
            Socket s = ss.accept();
            InputStream is = s.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            String str = null;
            while ((str = bf.readLine()) != null) {
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
