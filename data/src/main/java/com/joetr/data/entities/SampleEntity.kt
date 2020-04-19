package com.joetr.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SampleEntity(
    @PrimaryKey val id: String
)