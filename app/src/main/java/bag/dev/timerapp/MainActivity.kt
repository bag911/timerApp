package bag.dev.timerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bag.dev.timerapp.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {

//        binding.progressBar2.progress
        var isRun = false

        var hours:Int
        var minutes:Int
        var seconds:Int

        binding.button.setOnClickListener {
            if (!isRun){
                var time = 20
                isRun=true
                val timer = Timer()
                timer.schedule(object : TimerTask(){
                    override fun run(){
                        runOnUiThread{
                            time--
                            hours = time/3600
                            minutes = time%3600/60
                            seconds = time%60
                            binding.textView.text = "$hours : $minutes : $seconds"
                            if (time==0){
                                timer.cancel()
                                isRun = false
                            }
//                            binding.progressBar2.progress++
//                            if (binding.progressBar2.progress==100){
//                                binding.progressBar2.progress=0
//                            }
                        }
                    }
                },0,1000)
            }
        }


    }


}