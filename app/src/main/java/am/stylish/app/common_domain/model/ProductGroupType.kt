package am.stylish.app.common_domain.model

import am.stylish.app.R

enum class ProductGroupType(val title: Int) {
    BEAUTY(R.string.product_type_beauty),
    FASHION(R.string.product_type_fashion),
    KIDS(R.string.product_type_kids),
    MENS(R.string.product_type_mens),
    Women(R.string.product_type_women),
    Other(R.string.product_type_other)
}
