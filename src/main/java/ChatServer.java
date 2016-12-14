/**
 * ref: http://pirate.shu.edu/~wachsmut/Teaching/CSAS2214/Virtual/Lectures/chat-client-server.html
 */

import java.io.InputStreamReader; //入力ストリーム
import java.io.BufferedReader; //効率よく入力ストリームを処理するためのバッファ
import java.io.IOException;
import java.net.ServerSocket; //サーバ
import java.net.Socket; //ソケット(通信を行う際の端点)
import java.net.InetAddress; //ローカルIP取得
import java.net.UnknownHostException;

public class ChatServer {
    private ServerSocket   server   = null;
    private Socket         socket   = null;
    private BufferedReader streamIn = null;

    public ChatServer(int port){
        try {
            //指定されたport番号を利用してサーバを起動。
            System.out.println("Binding to port " + port + ", please wait  ...");
            server = new ServerSocket(port);

            //ローカルIPの取得
            try {
                InetAddress addr = InetAddress.getLocalHost();
                System.out.println("Server started: " + addr.getHostAddress());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }

            //クライアント接続待ち
            System.out.println("Waiting for a client ...");
            socket = server.accept();

            //接続確立->クライアントからの入力読み込みのための設定
            System.out.println("Client accepted: " + socket);
            open();

            //入力ストリームを行単位で読み込み続ける。".bye"が届いたらbreak
            while (true){
                try {
                    String line = streamIn.readLine(); //入力読み込み
                    System.out.println(line);
                    if (line.equals(".bye") == true) {
                        break;
                    }
                } catch (IOException ioe) {
                    break;
                }
            }

            //サーバの停止
            close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public void open() throws IOException {
        streamIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void close() throws IOException {
        if (socket != null)
            socket.close();
        if (streamIn != null)
            streamIn.close();
    }

    public static void main(String args[]) {
        ChatServer server = null;
        if (args.length != 1)
            System.out.println("Usage: java ChatServer port");
        else
            server = new ChatServer(Integer.parseInt(args[0]));
    }
}