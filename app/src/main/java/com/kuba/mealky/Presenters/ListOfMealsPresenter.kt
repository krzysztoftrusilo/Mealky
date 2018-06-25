package com.kuba.mealky.Presenters

import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import android.widget.Toast
import com.kuba.mealky.Database.DBWorkerThread
import com.kuba.mealky.Database.Entities.MealData
import com.kuba.mealky.Database.MealkyDatabase
import android.os.Looper
import com.kuba.mealky.Database.Repositories.MealsRepository


class ListOfMealsPresenter(val mealsRepository: MealsRepository) : BasePresenter<ListOfMealsContract.View>(), ListOfMealsContract.Presenter {

    override fun loadMeals() {
        var meals: LiveData<List<MealData>>
        meals = mealsRepository.getAll()
        view?.fillList(meals)
    }

    override fun changeViewToMeal() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteMeal() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refresh() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}