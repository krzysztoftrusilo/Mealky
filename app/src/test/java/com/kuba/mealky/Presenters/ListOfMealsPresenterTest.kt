package com.kuba.mealky.Presenters

import com.kuba.mealky.Database.MealkyDatabase
import com.kuba.mealky.Database.Repositories.MealsRepository
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.junit.Rule
import org.mockito.Mockito


class ListOfMealsPresenterTest {
    lateinit var presenter: ListOfMealsPresenter

    @Mock
    lateinit var mealsRepositoryMock: MealsRepository

    @get:Rule
    var mockitoRule = MockitoJUnit.rule()

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        presenter = ListOfMealsPresenter(mealsRepositoryMock)

    }

    @Test
    fun loadMeals() {
        presenter.loadMeals()
    }

    @Test
    fun changeViewToMeal() {
        assert(true)
    }

    @Test
    fun deleteMeal() {
        assert(true)
    }

    @Test
    fun refresh() {
        assert(true)
    }
}