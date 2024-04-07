package com.cihank.catchtomole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import com.cihank.catchtomole.databinding.ActivityPlayGameBinding
import kotlin.concurrent.thread

class PlayGameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayGameBinding
    private var score = 0
    private lateinit var countDownTimer: CountDownTimer
    var moleimageList = ArrayList<ImageView>()
    //var cactusimageList = ArrayList<ImageView>() //->Algoritmayı değiştirdim burası iptal.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Başlangıç zamanı (60 saniye)
        val initialTimeMillis = 10 * 1000L

        // Geri sayım sayacını başlat
        startCountdown(initialTimeMillis)

        moleimageList.add(binding.moleimageView1)
        moleimageList.add(binding.moleimageView2)
        moleimageList.add(binding.moleimageView3)
        moleimageList.add(binding.moleimageView4)
        moleimageList.add(binding.moleimageView5)
        moleimageList.add(binding.moleimageView6)
        moleimageList.add(binding.moleimageView7)
        moleimageList.add(binding.moleimageView8)
        moleimageList.add(binding.moleimageView9)
        moleimageList.add(binding.moleimageView10)
        moleimageList.add(binding.moleimageView11)
        moleimageList.add(binding.moleimageView12)
        moleimageList.add(binding.moleimageView13)
        moleimageList.add(binding.moleimageView14)
        moleimageList.add(binding.moleimageView15)
        moleimageList.add(binding.moleimageView16)
        moleimageList.add(binding.moleimageView17)
        moleimageList.add(binding.moleimageView18)
        moleimageList.add(binding.moleimageView19)
        moleimageList.add(binding.moleimageView20)
        moleimageList.add(binding.moleimageView21)
        moleimageList.add(binding.moleimageView22)
        moleimageList.add(binding.moleimageView23)
        moleimageList.add(binding.moleimageView24)
        moleimageList.add(binding.moleimageView25)
        moleimageList.add(binding.moleimageView26)
        moleimageList.add(binding.moleimageView27)
        moleimageList.add(binding.cactusimageView1)
        moleimageList.add(binding.cactusimageView2)
        moleimageList.add(binding.cactusimageView3)
        moleimageList.add(binding.cactusimageView4)
        moleimageList.add(binding.cactusimageView5)
        moleimageList.add(binding.cactusimageView6)
        moleimageList.add(binding.cactusimageView7)
        moleimageList.add(binding.cactusimageView8)
        moleimageList.add(binding.cactusimageView9)

    }

    private fun startCountdown(initialTimeMillis: Long) {
        countDownTimer = object : CountDownTimer(initialTimeMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Her saniye burası çalışır
                hideImage()
                //hideCactusImage() -> iptal
                val secondsRemaining = millisUntilFinished / 1000
                binding.timeTextView.text = "Time: $secondsRemaining"
            }

            override fun onFinish() {
                // Geri sayım tamamlandığında burası çalışır
                binding.timeTextView.text = "Time Over"
                // Burada istediğiniz başka bir işlemi yapabilirsiniz.

                //geri sayım bitince bütün imageların gizlenmesi için for yazdım
                for (image in moleimageList){
                    image.visibility = View.INVISIBLE
                }

                /*
                for (image in cactusimageList){
                    image.visibility = View.INVISIBLE
                }
                 */


                thread {
                    Thread.sleep(1000) // 1000 milisaniye = 1 saniye beklemesini söyledim.
                    // 1 sn beklediktan Sonraki kod satırını buraya ekleyin
                    val intent = Intent(this@PlayGameActivity, MainActivity::class.java)
                    intent.putExtra("newscore", score)
                    startActivity(intent)
                    finish()

                }
            }
        }
        countDownTimer.start()
    }

    /*  --> gerek var mı bu fun'a bilmiyorum.
    override fun onDestroy() {
        super.onDestroy()
        countDownTimer.cancel() // Sayacı durdur
    }

     */

    fun moleclick(view: View){

        score += 1
        binding.scoreTextView.text = "Score: $score"

        //tıklandıktan sonra kaybolması için for yazdım. daha verimlisini bulunca değiştir.
        for (image in moleimageList){
            image.visibility = View.INVISIBLE
        }

    }

    fun cactusClick(view: View){

        score -= 1
        binding.scoreTextView.text = "Score: $score"

    }

    fun hideImage(){

        for (image in moleimageList){
            image.visibility = View.INVISIBLE
        }

        val size = moleimageList.size -1
        var random = (0..size).random()

        moleimageList[random].visibility = View.VISIBLE
    }

    /*
    fun hideCactusImage(){
        for (image in cactusimageList){
            image.visibility = View.INVISIBLE
        }

        var random = (0..8).random()

        cactusimageList[random].visibility = View.VISIBLE
    }

     */

}