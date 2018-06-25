package com.kuba.mealky.Database.Repositories

import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import android.util.Log
import com.kuba.mealky.Database.Entities.MealData
import com.kuba.mealky.Database.MealkyDatabase
import java.util.Objects.isNull

class MealsRepository(val mealkyDatabase: MealkyDatabase) {

    fun getAll(): LiveData<List<MealData>> {
        return mealkyDatabase.mealDao().getAll()
    }
}