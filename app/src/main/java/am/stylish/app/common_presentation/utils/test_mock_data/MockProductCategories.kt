package am.stylish.app.common_presentation.utils.test_mock_data

import am.stylish.app.R
import am.stylish.app.main.search.domain.model.ProductCategory

val mockProductCategories = listOf(
    ProductCategory(
        name = "Beauty",
        image = R.drawable.ic_beauty,
    ),
    ProductCategory(
        name = "Fashion",
        image = R.drawable.ic_fashion,
    ),
    ProductCategory(
        name = "Kids",
        image = R.drawable.ic_kids,
    ),
    ProductCategory(
        name = "Mens",
        image = R.drawable.ic_mens,
    ),
    ProductCategory(
        name = "Womens",
        image = R.drawable.ic_woman,
        products = mockProductsData,
    ),
    ProductCategory(
        name = "Electronics",
        image = R.drawable.ic_electronics,
        products = mockProductsData
    ),
    ProductCategory(
        name = "Sports",
        image = R.drawable.ic_sport,
        products = mockProductsData
    ),
    ProductCategory(
        name = "Books",
        image = R.drawable.ic_book,
        products = mockProductsData
    ),
    ProductCategory(
        name = "Home & Kitchen",
        image = R.drawable.ic_kitchen,
        products = mockProductsData
    ),
    ProductCategory(
        name = "Toys",
        image = R.drawable.ic_toys,
        products = mockProductsData
    ),
    ProductCategory(
        name = "Groceries",
        image = R.drawable.ic_groceries,
        products = mockProductsData
    ),
    ProductCategory(
        name = "Jewelry",
        image = R.drawable.ic_jewelry,
        products = mockProductsData
    ),
    ProductCategory(
        name = "Watches",
        image = R.drawable.ic_watches,
        products = mockProductsData
    ),
    ProductCategory(
        name = "Shoes",
        image = R.drawable.ic_shoes,
        products = mockProductsData
    ),
    ProductCategory(
        name = "Bags",
        image = R.drawable.ic_bags,
        products = mockProductsData
    ),
    ProductCategory(
        name = "Health",
        image = R.drawable.ic_health,
        products = mockProductsData
    ),
    ProductCategory(
        name = "Fitness",
        image = R.drawable.ic_fitness,
        products = mockProductsData
    ),
    ProductCategory(
        name = "Garden",
        image = R.drawable.ic_garden,
        products = mockProductsData
    ),
    ProductCategory(
        name = "Pet Supplies",
        image = R.drawable.ic_pet_supplies,
        products = mockProductsData
    ),
    ProductCategory(
        name = "Furniture",
        image = R.drawable.ic_furniture,
        products = mockProductsData
    ),
    ProductCategory(
        name = "Stationery",
        image = R.drawable.ic_stationery,
        products = mockProductsData
    )
)
