package com.deveducatuion.warcardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity() {

    internal lateinit var iv_card_left:ImageView
    internal lateinit var iv_card_right:ImageView
    internal lateinit var b_deal:ImageView
    internal lateinit var tv_score_left:TextView
    internal lateinit  var tv_score_right:TextView
    var leftScore=0
    var rightScore=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv_card_left=findViewById<ImageView>(R.id.iv_card_left)
        iv_card_right=findViewById<ImageView>(R.id.iv_card_right)
        b_deal=findViewById<ImageView>(R.id.b_deal)
        tv_score_left=findViewById<TextView>(R.id.tv_score_left)
        tv_score_right=findViewById<TextView>(R.id.tv_score_right)
    }


    fun onClicked(view: View){
        var leftCard=Random().nextInt(13)+2
        var rightCard=Random().nextInt(13)+2

        //var leftImage=getResources().getIdentifier("card" +leftCard, "drawable", getPackageName()) // джава вариант

        var leftImage=resources.getIdentifier("card$leftCard", "drawable", packageName) // котлин вариант
        iv_card_left.setImageResource(leftImage)
        var rightImage=resources.getIdentifier("card$rightCard", "drawable", packageName)
        iv_card_right.setImageResource(rightImage)

        when {
            leftCard>rightCard -> {
                leftScore++
                tv_score_left.text=leftScore.toString()
            }
            leftCard<rightCard -> {
                rightScore++
                tv_score_right.text=rightScore.toString()
            }
            else -> Toast.makeText(this, "WAR!!!", Toast.LENGTH_SHORT).show()
        }

        if(leftScore>=20){
            zeroScore()
            Toast.makeText(this, "Player 1 the win!!!", Toast.LENGTH_SHORT).show()
        }else if(rightScore>=20){
           zeroScore()
            Toast.makeText(this, "Player 2 the win!!!", Toast.LENGTH_SHORT).show()
        }else if (leftScore==20 && rightScore==20){
            zeroScore()
            Toast.makeText(this, "DRAW!!!", Toast.LENGTH_SHORT).show()
        }
    }

    fun zeroScore(){
        leftScore=0
        rightScore=0
        tv_score_left.text=leftScore.toString()
        tv_score_right.text=rightScore.toString()
    }

}
