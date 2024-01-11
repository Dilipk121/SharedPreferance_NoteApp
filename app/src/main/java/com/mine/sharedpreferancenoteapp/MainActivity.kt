package com.mine.sharedpreferancenoteapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mine.sharedpreferancenoteapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //getSharedPreference() is use to create and give name to SP, Context.Private means
        //its app data used within the app only
        sharedPreferences = getSharedPreferences("noteApp",Context.MODE_PRIVATE)

        binding.saveNote.setOnClickListener{

            val note = binding.noteEt.text.toString()

           if (note.isEmpty()){
               Toast.makeText(this, "Blank Note !!", Toast.LENGTH_SHORT).show()
           }else{
               //we have to assinged here SP is modified or readable
               //edit() -- modifiable
               val sharedEdit = sharedPreferences.edit()
               sharedEdit.putString("note",note)
               sharedEdit.apply()
               Toast.makeText(this, "Note Store Successfully", Toast.LENGTH_SHORT).show()
               binding.noteEt.text.clear()//clear the Edit Text Data
           }
        }

        binding.displayBtn.setOnClickListener{
            val storedNote = sharedPreferences.getString("note","")
            binding.noteTv.text = "$storedNote"
        }

        binding.saveNoteActivity.setOnClickListener{
            val noteActivity = binding.noteEtActivity.text.toString()
            if (noteActivity.isEmpty()){
                Toast.makeText(this, "Blank Note !!", Toast.LENGTH_SHORT).show()
            }else{
                //we have to assinged here SP is modified or readable
                //edit() -- modifiable
                sharedPreferences = getSharedPreferences("noteApp",Context.MODE_PRIVATE)
                val sharedEdit = sharedPreferences.edit()
                sharedEdit.putString("noteActivity",noteActivity)
                sharedEdit.apply()

                startActivity(Intent(this,AnotherSPActivity::class.java))

                Toast.makeText(this, "Note Store Successfully", Toast.LENGTH_SHORT).show()
                binding.noteEtActivity.text.clear()

            }

        }


    }
}