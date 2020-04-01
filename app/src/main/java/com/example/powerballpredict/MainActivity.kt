package com.example.powerballpredict

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // get reference to button
        val btn_powerball_data = findViewById(R.id.btn_powerball_data) as ImageButton
        // set on-click listener
        btn_powerball_data.setOnClickListener {
            // your code to perform when the user clicks on the button
            var res = loadPowerBallData()
            Toast.makeText(this@MainActivity, "Hello, received $res", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadPowerBallData() : String{
        val service = ApiService()
        val result = service.execute(URL("https://data.api.thelott.com/sales/vmax/web/data/lotto/resultsallproductsstatistics")).get()
        println("Returned $result")
        return result
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
