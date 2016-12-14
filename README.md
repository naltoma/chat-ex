# サーバ・クライアントなコード例: チャット
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

## 参考サイト
- [Creating a simple Chat Client/Server Solution](http://pirate.shu.edu/~wachsmut/Teaching/CSAS2214/Virtual/Lectures/chat-client-server.html)
- [演習3-1 サーバとクライアント](http://yoslab.net/netprog/index.php?%B1%E9%BD%AC3-1%20%A5%B5%A1%BC%A5%D0%A4%C8%A5%AF%A5%E9%A5%A4%A5%A2%A5%F3%A5%C8)