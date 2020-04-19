package com.joetr.base.di

import androidx.annotation.NonNull

interface DaggerAware {
    fun injectSelf(@NonNull component: OverridableComponent)
}
