package com.papaguycodes.exifeditor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.papaguycodes.exifeditor.utils.ThemeUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ThemeUtils.applyTheme(this)  // Apply the GitHub-inspired theme
        setContentView(R.layout.activity_main)

        // Open the ExifEditor when the user clicks a button (assume button has been set in XML)
        findViewById<Button>(R.id.openExifEditorButton).setOnClickListener {
            val intent = Intent(this, ExifEditor::class.java)
            startActivity(intent)
        }
    }
}

