import 'package:flutter/material.dart';
import 'package:todo_app/SqliteTestModel.dart';

class WritePage extends StatelessWidget {

  final content = TextEditingController();

  Future<void> _insertDB() async{
    var provider = MemoProvider();
    var todo = Todo(content: content.text);
    provider.insert(todo);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Insert'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Center(
          child: Column(
            children: [
              TextField(
                controller: content,
                decoration: InputDecoration(
                  labelText: '내용을 입력하세요'
                ),
              )
            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: (){
          _insertDB();
          Navigator.pop(context);
        },
        child: Icon(Icons.add),
      ),
    );
  }
}
