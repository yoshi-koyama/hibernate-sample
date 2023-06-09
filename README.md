# このプロジェクトについて

hibernate-coreを使ったサンプルプロジェクトです。

# 使用技術

- Java 17
- MySQL 8.0
- Docker

# 起動手順

## データベースの起動

Dockerを使ってMySQLを起動します。

```bash
docker-compose up -d
```

起動できたら、以下のコマンドでデータベースに接続します。

```bash
docker-compose exec db mysql -u root -p
```

passwordは`password`です。

テーブルの確認をします。

```roomsql
mysql> use minecraft
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed

mysql> show tables;
+---------------------+
| Tables_in_minecraft |
+---------------------+
| player_score        |
+---------------------+
1 row in set (0.01 sec)

mysql> SELECT id, player_name, score, difficulty, registered_at FROM player_score;
+----+-------------+-------+------------+---------------------+
| id | player_name | score | difficulty | registered_at       |
+----+-------------+-------+------------+---------------------+
|  1 | koujienami  |    70 | normal     | 2023-06-09 09:43:11 |
|  2 | koujienami  |    65 | hard       | 2023-06-09 09:43:11 |
+----+-------------+-------+------------+---------------------+
2 rows in set (0.00 sec)

mysql> exit
```

なお、Dockerがない場合自分の環境にインストールしたMySQLを使ってOKです。
ただし、`hibernate.cfg.xml`の設定を変更する必要があります。

```
<property name="connection.url">jdbc:mysql://localhost:3307/minecraft</property>
```

について、port番号を3307から3306に変更したり、データベース名を適宜修正してください。
それから、player_scoreテーブルを作成してデータを入れましょう。

SQLは./sql/01_create_table.sqlを参考にしてください。

## Mainの実行

Mainクラスを実行してください。

コンソールに下記のような出力が出ていればOKです。

```
START
id: 1, player_name: koujienami, score: 70, difficulty: normal, registered_at: 2023-06-09T09:43:11+09:00[Asia/Tokyo]
id: 2, player_name: koujienami, score: 65, difficulty: hard, registered_at: 2023-06-09T09:43:11+09:00[Asia/Tokyo]
END
```