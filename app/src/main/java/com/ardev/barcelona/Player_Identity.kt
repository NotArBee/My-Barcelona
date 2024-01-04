package com.ardev.barcelona

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player_Identity(
    val name: String,
    val position: String,
    val desc: String,
    val photo: Int,
    val special: String
) : Parcelable
