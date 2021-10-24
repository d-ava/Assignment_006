package com.example.assignment_006.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.glideImage(img : String){
    Glide.with(context).load(img).into(this)
}
