import 'dart:async';
import 'package:path/path.dart';

import 'package:sqflite/sqflite.dart';

final String columnId = 'id';
final String columnContent = 'content';

class Todo {
  int? id;
  String? content;

  Todo({this.id, required this.content});

  Map<String, dynamic> toMap() {
    var map = <String, dynamic>{
      columnContent: content,
    };

    if (id != null) {
      map[columnId] = id;
    }
    return map;
  }

  Todo.fromMap(Map<String, dynamic> map) {
    id = map[columnId];
    content = map[columnContent];
    print('$id, $content');
  }
}

class MemoProvider {
  static Database? _database;

  Future<Database?> get database async {
    if (_database != null) return _database;

    _database = await initDB();
    return _database;
  }

  initDB() async {
    String path = join(await getDatabasesPath(), 'todo.db');

    return await openDatabase(path, version: 1, onCreate: (db, version) async {
      await db.execute('''
          CREATE TABLE todoList(
            TodoNo INTEGER PRIMARY KEY AUTOINCREMENT,
            Content TEXT,
            RecordDate DATETIME)
          ''');
    }, onUpgrade: (db, oldVersion, newVersion) {});
  }

  Future<Todo> insert(Todo todo) async {
    final Database? db = await database;
    print(todo.toMap());

    todo.id = await db?.insert("todoList", todo.toMap());

    return todo;
  }
}
