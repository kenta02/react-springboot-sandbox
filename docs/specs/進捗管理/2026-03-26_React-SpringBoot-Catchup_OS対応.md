# React-SpringBoot-Catchup OS対応進捗

## 実施内容

- `docs/React-SpringBoot-Catchup.md` の初期セットアップを Windows / macOS の両方で読める形に修正
- 絶対パス指定を削除
- Unix 固定の `curl | tar` 手順を Spring Initializr Web 利用前提へ変更
- Vite 利用時の開発コマンドを `npm run dev` に修正
- Spring Boot Wrapper の OS 別コマンドを表形式で追加

## 確認結果

- macOS / Linux と Windows で差が出る箇所は Wrapper 実行ファイル名に限定して明示できた
- 少なくともドキュメント上は、特定 OS 前提の構成ではなくなった

## 残課題

- 実リポジトリ上で `client` / `server` が未作成の場合、必要に応じて雛形生成を別タスクで行う

## 本日の対応（追加）

- `server/demo` の `TodoService` / `TodoController` のコンパイルエラーを修正
  - `TodoRequest` 型のスペルミス、`todoRepository` フィールドの不整合を修正
  - `@RequestMapping("/api/todos")` に修正
- `build.gradle` に `spring-boot-starter-validation` を追加し、`jakarta.validation` 依存を解決
- `./gradlew clean test --no-daemon` 実行でビルド成功
