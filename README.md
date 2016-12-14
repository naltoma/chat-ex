# サーバ・クライアントなコード例: チャット
## 使い方
- コンパイル
  - src/main/java に移動して、``javac *.java``
- 実行方法
  - サーバ側
    - ``java ChatServer ポート番号``
      - 「ポート番号」は、例えば1025。
        - 1024までは一般的なアプリで使用されてる事が多いので、それを避けよう。
        - 参考: [wikipedia:ポート番号](https://ja.wikipedia.org/wiki/ポート番号)
  - クライアント側
    - ``java ChatClient サーバのIPアドレス ポート番号``
      - 「サーバのIPアドレス」は、ChatServer起動時に出力されるはず。
      - 「ポート番号」は、サーバ起動時に指定したポート番号を入力しよう。
    - サーバに接続詞た後は、「.bye」が入力されるまで自由にテキスト入力できる。

## 前提
- プログラミング言語は、授業でPythonで15週。C言語2週。Java8週程度済み。
  - クラス、オブジェクト指向の基礎（継承、カプセル化、ポリモーフィズム）は一通り例題含めて解説済み。
  - GUI周りは特に触っていない。
    - JavaFXが良いらしい？
    - Genericやらあれこれ使いまくってるらしいが、総合的には[Java人工知能プログラミング -オブジェクト指向と関数スタイルによるAIの実装](https://www.amazon.co.jp/gp/product/4864875693/)が良いらしい？
- まだ学部1年次。スレッド、TCP/IP, Socketとか通信周りの知識なし。

## 方針
- まずは必要最小限の機能に。
  - サーバ側
    - ポート番号指定してServerSocket.accept()
    - クライアントの接続待ち。
    - 接続確立後、終了フラグ立つまで行単位で文字列読み込み。
    - 終了フラグ立ったら切断処理。
  - クライアント側
    - サーバのIP, portを指定してサーバに接続。
    - 接続確立後、終了フラグ立つまで行単位で文字列読み込み(stdin)し、サーバに送信。
    - 終了フラグ立ったら切断処理。
- 先送り機能
  - クライアント側への出力？
  - マルチクライアント対応（スレッド例）
  - 簡易GUI例？

## 利用してるAPIへのリンク
- 入出力周り
  - [java.io.InputStreamReader](http://docs.oracle.com/javase/8/docs/api/javax/sound/sampled/AudioInputStream.html); //入力ストリーム
  - [java.io.BufferedReader](http://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html); //効率よく入力ストリームを処理するためのバッファ
  - [java.io.IOException](http://docs.oracle.com/javase/8/docs/api/java/io/IOException.html);
  - [java.io.PrintWriter](http://docs.oracle.com/javase/8/docs/api/java/io/PrintWriter.html); //サーバへの出力ストリームを処理するライブラリ
- サーバ、通信周り
  - [java.net.ServerSocket](http://docs.oracle.com/javase/8/docs/api/java/net/ServerSocket.html); //サーバ
  - [java.net.Socket](http://docs.oracle.com/javase/8/docs/api/java/net/Socket.html); //ソケット(通信を行う際の端点)
  - [java.net.InetAddress](http://docs.oracle.com/javase/8/docs/api/java/net/InetAddress.html); //ローカルIP取得
  - [java.net.UnknownHostException](http://docs.oracle.com/javase/8/docs/api/java/net/UnknownHostException.html);

## 参考サイト
- [Creating a simple Chat Client/Server Solution](http://pirate.shu.edu/~wachsmut/Teaching/CSAS2214/Virtual/Lectures/chat-client-server.html)
- [演習3-1 サーバとクライアント](http://yoslab.net/netprog/index.php?%B1%E9%BD%AC3-1%20%A5%B5%A1%BC%A5%D0%A4%C8%A5%AF%A5%E9%A5%A4%A5%A2%A5%F3%A5%C8)