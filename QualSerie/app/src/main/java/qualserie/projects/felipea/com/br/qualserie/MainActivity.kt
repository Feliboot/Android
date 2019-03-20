package qualserie.projects.felipea.com.br.qualserie

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnSeekBarChangeListener{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.seekBarID!!.setOnSeekBarChangeListener(this)
       // seekBar.setOnSeekBarChangeListener(this)
    }
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        var opcoesCarinhas = findViewById<ImageView>(R.id.carinhaID)
        if (progress==0) opcoesCarinhas.setImageResource(R.drawable.pouco)
        else if (progress == 1) opcoesCarinhas.setImageResource(R.drawable.medio)
        else if (progress == 2) opcoesCarinhas.setImageResource(R.drawable.muito)
        else if (progress == 3) opcoesCarinhas.setImageResource(R.drawable.susto)


    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
       // Toast.makeText(this,"Seek Bar clicado!",Toast.LENGTH_LONG).show()
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
       // Toast.makeText(this,"Seek Bar deixou de ser clicado!!!",Toast.LENGTH_LONG).show()

    }

}
