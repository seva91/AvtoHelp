package ru.avtohelp.domain

import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

interface SelectionCategoryUseCase {
    val categories: Single<List<Category>>
    val selectedCategory: Single<Category>

    fun selectCategory(category: Category): Completable
}

interface CategoryRepository {
    val selectedCategory: Category
    val categories: List<Category>

    fun saveCategories(categories: List<Category>)
}

interface CategoryServer {
    var selectedCategory: Category?
    val categories: List<Category>
}

class SelectionCategoryUseCaseImpl @Inject constructor(
    private val categoryServer: CategoryServer,
    private val categoryRepository: CategoryRepository
) : SelectionCategoryUseCase {

    override val categories: Single<List<Category>>
        get() = Single
            .fromCallable {
                return@fromCallable categoryServer.categories
            }

    override val selectedCategory: Single<Category>
        get() = Single
            .fromCallable {
                return@fromCallable categoryServer.selectedCategory
            }

    override fun selectCategory(category: Category): Completable {
        return Completable
            .fromAction {
                categoryServer.selectedCategory = category
            }
    }
}