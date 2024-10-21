package com.firstprog.notes_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firstprog.notes_app.adapter.TodoListAdapter
import com.firstprog.notes_app.model.TodoList

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        todoAdapter = TodoListAdapter(mutableListOf())
        val rvTodoItems = findViewById<RecyclerView>(R.id.rv_TodoItems)
        val btnAddTodo = findViewById<Button>(R.id.btn_addTodos)
        val etTodoTitle = findViewById<EditText>(R.id.etTodoTitle)
        val btnDeleteDoneTodos = findViewById<Button>(R.id.btn_deleteDoneTodos)

        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = TodoList(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }

        btnDeleteDoneTodos.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}