package com.kuba.mealky.Activites

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.kuba.mealky.Adapters.MealsAdapter
import com.kuba.mealky.Database.Entities.MealData
import com.kuba.mealky.Database.MealkyDatabase
import com.kuba.mealky.Database.Repositories.MealsRepository
import com.kuba.mealky.Presenters.ListOfMealsContract
import com.kuba.mealky.Presenters.ListOfMealsPresenter
import com.kuba.mealky.R
import android.arch.lifecycle.ViewModelProviders
import com.kuba.mealky.ViewModels.MealsViewModel
import android.support.v7.util.DiffUtil




class ListOfMealsActivity : AppCompatActivity(), ListOfMealsContract.View {
    private var meals: List<MealData> = emptyList<MealData>()
    lateinit var bottomBar: BottomNavigationView
    lateinit var presenter: ListOfMealsPresenter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var mealsRepository: MealsRepository
    private lateinit var database: MealkyDatabase
    lateinit var viewModel: MealsViewModel

    override fun fillList(m: LiveData<List<MealData>>) {
        viewManager = LinearLayoutManager(this)
        // viewAdapter = MealsAdapter(meals)

        recyclerView = findViewById<RecyclerView>(R.id.list_of_meals).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
        }

        val todosObserver = object : Observer<List<MealData>> {
            override fun onChanged(mealsHere: List<MealData>?) {
                if (meals.size == 0) {
                    meals = mealsHere!!
                    viewAdapter = MealsAdapter(meals)
                    recyclerView.setAdapter(viewAdapter)
                } else {
                    val result = DiffUtil.calculateDiff(object : DiffUtil.Callback() {

                        override fun getOldListSize(): Int {
                            return meals.size
                        }

                        override fun getNewListSize(): Int {
                            return mealsHere!!.size
                        }

                        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                            return meals[oldItemPosition] === mealsHere!![newItemPosition]
                        }

                        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                            val oldTodo = meals.get(oldItemPosition)
                            val newTodo = mealsHere!![newItemPosition]
                            return oldTodo.equals(newTodo)
                        }
                    })
                    result.dispatchUpdatesTo(viewAdapter)
                    meals = mealsHere!!
                }
            }
        }
        viewModel.getAllMeals(database.mealDao()).observe(this, todosObserver)






    }

    override fun onItemClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemLongClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearData() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = MealkyDatabase.getInstance(this)!!
        setSupportActionBar(findViewById(R.id.topBar))
        bottomBar = findViewById(R.id.bottomBar)
        mealsRepository = MealsRepository(database)
        presenter = ListOfMealsPresenter(mealsRepository)
        presenter.attach(this)

        viewModel = ViewModelProviders.of(this).get(MealsViewModel::class.java)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        presenter.loadMeals()
    }

    override fun onDestroy() {
        super.onDestroy()
        clearData()
    }

}


