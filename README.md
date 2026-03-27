# react-springboot-sandbox
React と Spring Boot の学習用サンドボックス

## 概要
- `client/`: React (Vite + TypeScript)
- `server/`: Spring Boot (Gradle + Java)
- `docs/`: 仕様・設計・ハンズオン資料

## 前提
- Node.js (16 以上推奨)
- Java 17 以上
- Git

## 起動方法

### 1) クライアント (React)
1. `cd client`
2. `npm install`
3. `npm run dev`

- ブラウザで `http://localhost:5173` にアクセス
- ビルド: `npm run build`
- テスト: `npm run test`

### 2) サーバー (Spring Boot)
1. `cd server/demo`
2. Linux / macOS: `./gradlew bootRun`
3. Windows: `gradlew.bat bootRun`

- Git Bash など Unixライクシェルの Windows 環境では `./gradlew bootRun` を使う（`gradlew.bat` を直接実行すると `command not found` になることがあります）。
- PowerShell / CMD の場合は `gradlew.bat bootRun` もしくは `./gradlew bootRun` で実行可能。

- API エンドポイント例: `http://localhost:8080/api/todos`
- テスト: `./gradlew test`（Windows でも `gradlew.bat test`）

## トラブルシューティング
- `ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.`
  1. Java 17+ がインストールされていることを確認
  2. Windows 上で PowerShell/cmdで `java -version` が実行できること
  3. `JAVA_HOME` をシステム環境変数に設定
     - 例: `C:\Program Files\Java\jdk-17`
  4. `PATH` へ `%JAVA_HOME%\bin` を追加
  5. 新しいターミナルを開き直し再実行

## 開発フロー
1. サーバー起動
2. クライアント起動
3. `client/src/api/todos.ts` の API ベース URL を必要に応じて調整

## 参照ドキュメント
- `docs/handsOn/React-SpringBoot-catchUp.md` (ハンズオン手順)

