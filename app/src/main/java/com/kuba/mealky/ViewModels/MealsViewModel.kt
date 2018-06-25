package com.kuba.mealky.ViewModels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.kuba.mealky.Database.DAO.MealDao
import com.kuba.mealky.Database.Entities.MealData


class MealsViewModel : ViewModel() {
    private var mMealLiveData: LiveData<List<MealData>>? = null
    fun getAllMeals(mealsDao: MealDao): LiveData<List<MealData>> {
        if (mMealLiveData == null) {
            mMealLiveData = mealsDao.getAll()
        }
        return mMealLiveData!!
    }
}