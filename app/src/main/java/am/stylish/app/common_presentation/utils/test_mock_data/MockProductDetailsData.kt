package am.stylish.app.common_presentation.utils.test_mock_data

import am.stylish.app.common_domain.model.details.ProductDetails
import am.stylish.app.common_domain.model.product.ProductColor

const val COMMON_DESCRIPTION =
    "This product is made with the highest quality materials to ensure durability and style."
private val defaultSizeList = listOf("6 UK", "7 UK", "8 UK", "9 UK", "10 UK")

val productDetailsMockData = listOf(
    ProductDetails(
        productId = "1",
        title = "HRX by Hrithik Roshan",
        shortDescription = COMMON_DESCRIPTION,
        longDescription = "Crafted for modern style enthusiasts, this product combines elegance and comfort seamlessly. Ideal for everyday wear or special occasions. Elevate your wardrobe with this timeless addition.Crafted for modern style enthusiasts, this product combines elegance and comfort seamlessly. Ideal for everyday wear or special occasions. Elevate your wardrobe with this timeless addition.Crafted for modern style enthusiasts, this product combines elegance and comfort seamlessly. Ideal for everyday wear or special occasions. Elevate your wardrobe with this timeless addition.Crafted for modern style enthusiasts, this product combines elegance and comfort seamlessly. Ideal for everyday wear or special occasions. Elevate your wardrobe with this timeless addition.",
        size = defaultSizeList,
        color = listOf(
            ProductColor("Red", "#FF0000"),
            ProductColor("Blue", "#0000FF"),
            ProductColor("Black", "#000000")
        ),
        price = "2499",
        imageUrl = listOf(
            "https://s3-alpha-sig.figma.com/img/e8d7/a7e6/19ceee35411c96d9d02429c0907f549c?Expires=1733097600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=ARIxhEBz1wiRD8BAZC8QW~ism1-R~Dv94FDfwIdP1RHVyOja5wHRJA1~9tTBw8~2sqgOXNBsjeuJeKd7DlgtbJxSurIBnJih2jXWfEskgTyuNwQstJWrM~5mzmxFyePHriVPiXivMYHZp4bzMGCiR4nv2zyf3UIhB6Qqu2QhckHYmdUnVA~OWcd9sSBKc8UE-h2ECKF63ORwEQOKRyqbVtBIVpqFRRHebDkdoZ91jFJe1JfodjO1p9xGquNZI4YlPWPcF1Le5XqfsWQESQ5yYYoqJ1A5UjmnQreyO0N3ZFs1To0TAKU6VdLR9r-7nOi2WkkpkB7zQcJxPhesvFC1hA__",
            "https://s3-alpha-sig.figma.com/img/e8d7/a7e6/19ceee35411c96d9d02429c0907f549c?Expires=1733097600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=ARIxhEBz1wiRD8BAZC8QW~ism1-R~Dv94FDfwIdP1RHVyOja5wHRJA1~9tTBw8~2sqgOXNBsjeuJeKd7DlgtbJxSurIBnJih2jXWfEskgTyuNwQstJWrM~5mzmxFyePHriVPiXivMYHZp4bzMGCiR4nv2zyf3UIhB6Qqu2QhckHYmdUnVA~OWcd9sSBKc8UE-h2ECKF63ORwEQOKRyqbVtBIVpqFRRHebDkdoZ91jFJe1JfodjO1p9xGquNZI4YlPWPcF1Le5XqfsWQESQ5yYYoqJ1A5UjmnQreyO0N3ZFs1To0TAKU6VdLR9r-7nOi2WkkpkB7zQcJxPhesvFC1hA__",
            "https://s3-alpha-sig.figma.com/img/e8d7/a7e6/19ceee35411c96d9d02429c0907f549c?Expires=1733097600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=ARIxhEBz1wiRD8BAZC8QW~ism1-R~Dv94FDfwIdP1RHVyOja5wHRJA1~9tTBw8~2sqgOXNBsjeuJeKd7DlgtbJxSurIBnJih2jXWfEskgTyuNwQstJWrM~5mzmxFyePHriVPiXivMYHZp4bzMGCiR4nv2zyf3UIhB6Qqu2QhckHYmdUnVA~OWcd9sSBKc8UE-h2ECKF63ORwEQOKRyqbVtBIVpqFRRHebDkdoZ91jFJe1JfodjO1p9xGquNZI4YlPWPcF1Le5XqfsWQESQ5yYYoqJ1A5UjmnQreyO0N3ZFs1To0TAKU6VdLR9r-7nOi2WkkpkB7zQcJxPhesvFC1hA__"
        ),
        rating = 4.5f,
        reviewsCount = 52157
    ), ProductDetails(
        productId = "2",
        title = "Men's Starry Shirt",
        shortDescription = "Men's Starry Sky Printed Shirt 100% Cotton Fabric",
        longDescription = "This stylish Men's Starry Sky Printed Shirt is made from 100% cotton fabric, offering comfort and durability. Perfect for casual outings and gatherings.",
        size = defaultSizeList,
        color = listOf(
            ProductColor("Red", "#FF0000"),
            ProductColor("Blue", "#0000FF"),
            ProductColor("Black", "#000000")
        ),
        price = "399",
        oldPrice = null,
        imageUrl = listOf(
            "https://basket-10.wbbasket.ru/vol1560/part156075/156075698/images/big/1.webp",
            "https://basket-10.wbbasket.ru/vol1560/part156075/156075698/images/big/1.webp",
            "https://basket-10.wbbasket.ru/vol1560/part156075/156075698/images/big/1.webp",
        ),
        rating = 4.5f,
        reviewsCount = 0
    ), ProductDetails(
        productId = "3",
        title = "Elegant Black Dress",
        shortDescription = "Beautiful sleeveless evening dress perfect for parties",
        longDescription = "This elegant sleeveless black dress is the perfect choice for evening parties, weddings, and special occasions. Crafted with high-quality fabric, it combines style and comfort for a stunning look.",
        size = defaultSizeList, // Placeholder for sizes
        color = listOf(
            ProductColor("Red", "#FF0000"),
            ProductColor("Blue", "#0000FF"),
            ProductColor("Black", "#000000")
        ),
        price = "₹799",
        oldPrice = "₹599", // Old price provided in the input
        imageUrl = listOf(
            "https://basket-15.wbbasket.ru/vol2223/part222311/222311401/images/big/1.webp",
            "https://basket-15.wbbasket.ru/vol2223/part222311/222311401/images/big/1.webp",
            "https://basket-15.wbbasket.ru/vol2223/part222311/222311401/images/big/1.webp",
        ),
        rating = 4.7f,
        reviewsCount = 100_152_157 // Provided in the input
    ), ProductDetails(
        productId = "4",
        title = "Pink Embroidered Dress",
        shortDescription = "Casual pink dress with beautiful embroidery details",
        longDescription = "This casual pink embroidered dress is a perfect choice for everyday wear or special occasions. Crafted with premium materials, it combines comfort and elegance effortlessly.",
        size = defaultSizeList, // Standard sizes as requested
        color = listOf(
            ProductColor(colorName = "Pink", colorCode = "#FFC0CB"),
            ProductColor(colorName = "Light Pink", colorCode = "#FFB6C1"),
            ProductColor(colorName = "Rose Pink", colorCode = "#FF69B4")
        ),
        price = "₹699",
        oldPrice = null, // No old price provided in input
        imageUrl = listOf(
            "https://s3-alpha-sig.figma.com/img/743f/0181/31926f97294be302b7272fa7fbd8ddcc?Expires=1733097600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=FXYQH6yG5ZFPluY1GggefItqIHPFLQSH0ddXjsPRjkSnYyoNf8YAulIVfvbC06WwsQTAPfyOiPPP34uSgQh30GT1icpDBas7bQdJ9KfPF-iwkAi5C14aGa3v~sj9txOwRo5h~JgrqCgH-PbbK0dz~cvstonZ743fPjix29LAp3VMlLG-rjX2-f1u45I8y2-DyvKnMqSDA3AEbkLWuWbTSiK40iBbZedCce1qqCNMPO7xWxnndwBOCxKtArbS3rMgAVH3wJHCLfq6TsPsP7ok0KcW32yLyBE8Lus5iHWjEgMmiZpB3B7g5qBXGl689s6Dp8T5y2P3Ki0WiZVVlOxKCA__",
            "https://s3-alpha-sig.figma.com/img/743f/0181/31926f97294be302b7272fa7fbd8ddcc?Expires=1733097600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=FXYQH6yG5ZFPluY1GggefItqIHPFLQSH0ddXjsPRjkSnYyoNf8YAulIVfvbC06WwsQTAPfyOiPPP34uSgQh30GT1icpDBas7bQdJ9KfPF-iwkAi5C14aGa3v~sj9txOwRo5h~JgrqCgH-PbbK0dz~cvstonZ743fPjix29LAp3VMlLG-rjX2-f1u45I8y2-DyvKnMqSDA3AEbkLWuWbTSiK40iBbZedCce1qqCNMPO7xWxnndwBOCxKtArbS3rMgAVH3wJHCLfq6TsPsP7ok0KcW32yLyBE8Lus5iHWjEgMmiZpB3B7g5qBXGl689s6Dp8T5y2P3Ki0WiZVVlOxKCA__"
        ),
        rating = 4.2f,
        reviewsCount = 0 // No reviews count provided in input
    ), ProductDetails(
        productId = "5",
        title = "Casual Denim Jacket",
        shortDescription = "Classic blue denim jacket for all seasons",
        longDescription = "This versatile casual denim jacket is perfect for any season. Made from durable denim, it's both stylish and practical, offering a timeless look for everyday wear.",
        size = defaultSizeList, // Standard sizes as requested
        color = listOf(
            ProductColor(colorName = "Blue", colorCode = "#0000FF"),
            ProductColor(colorName = "Dark Blue", colorCode = "#00008B"),
            ProductColor(colorName = "Light Blue", colorCode = "#ADD8E6")
        ),
        price = "₹599",
        oldPrice = null, // No old price provided in input
        imageUrl = listOf(
            "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg",
            "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg"
        ),
        rating = 4.1f,
        reviewsCount = 0 // No reviews count provided in input
    ), ProductDetails(
        productId = "6",
        title = "Comfy Sneakers",
        shortDescription = "Lightweight and comfortable sneakers for daily wear",
        longDescription = "These sneakers are perfect for daily wear, offering lightweight comfort and a stylish design. Ideal for long walks and casual outings.",
        size = defaultSizeList, // Standard sizes as requested
        color = listOf(
            ProductColor(colorName = "White", colorCode = "#FFFFFF"),
            ProductColor(colorName = "Black", colorCode = "#000000")
        ),
        price = "₹499",
        oldPrice = "₹599", // Old price provided in input
        imageUrl = listOf(
            "https://i0.wp.com/picjumbo.com/wp-content/uploads/amazing-stone-path-in-forest-free-image.jpg?w=600&quality=80",
            "https://i0.wp.com/picjumbo.com/wp-content/uploads/amazing-stone-path-in-forest-free-image.jpg?w=600&quality=80"
        ),
        rating = 4.6f,
        reviewsCount = 100_152_157 // Large review count as provided
    ), ProductDetails(
        productId = "7",
        title = "Trendy Sunglasses",
        shortDescription = "Stylish sunglasses with UV protection",
        longDescription = "These sunglasses are designed to keep you stylish while providing UV protection, making them perfect for sunny days and outdoor activities.",
        size = defaultSizeList, // Standard sizes as requested
        color = listOf(
            ProductColor(colorName = "Black", colorCode = "#000000"),
            ProductColor(colorName = "Brown", colorCode = "#A52A2A")
        ),
        price = "₹299",
        oldPrice = null, // No old price provided
        imageUrl = listOf(
            "https://th.bing.com/th/id/OIG1.CgTbIrO0vUXLNU28HMdC",
            "https://th.bing.com/th/id/OIG1.CgTbIrO0vUXLNU28HMdC"
        ),
        rating = 4.4f,
        reviewsCount = 0 // Assuming no review count provided
    ), ProductDetails(
        productId = "8",
        title = "Smart Fitness Band",
        shortDescription = "Track your fitness with heart rate and sleep monitor",
        longDescription = "The Smart Fitness Band helps you monitor your fitness activities, heart rate, and sleep patterns, making it the perfect companion for a healthier lifestyle.",
        size = defaultSizeList, // Standard sizes as requested
        color = listOf(
            ProductColor(colorName = "Black", colorCode = "#000000"),
            ProductColor(colorName = "Blue", colorCode = "#0000FF")
        ),
        price = "₹999",
        oldPrice = null, // No old price provided
        imageUrl = listOf(
            "https://picsum.photos/200/300", "https://picsum.photos/200/300"
        ),
        rating = 4.3f,
        reviewsCount = 0 // Assuming no review count provided
    ), ProductDetails(
        productId = "9",
        title = "Leather Wallet",
        shortDescription = "High-quality leather wallet with multiple compartments",
        longDescription = "This leather wallet features multiple compartments for cards, cash, and receipts, designed to offer both style and functionality. Made with premium leather, it’s built to last.",
        size = defaultSizeList, // Standard sizes as requested
        color = listOf(
            ProductColor(colorName = "Brown", colorCode = "#8B4513"),
            ProductColor(colorName = "Black", colorCode = "#000000")
        ),
        price = "₹349",
        oldPrice = "₹599", // Provided old price
        imageUrl = listOf(
            "https://img.freepik.com/free-photo/colorful-design-with-spiral-design_188544-9588.jpg",
            "https://img.freepik.com/free-photo/colorful-design-with-spiral-design_188544-9588.jpg"
        ),
        rating = 4.8f,
        reviewsCount = 100_152_157
    ), ProductDetails(
        productId = "10",
        title = "Bluetooth Headphones",
        shortDescription = "Wireless headphones with noise-cancellation",
        longDescription = "These Bluetooth headphones offer superior sound quality with noise-cancelling technology for an immersive listening experience. They are lightweight and perfect for on-the-go use.",
        size = defaultSizeList, // Standard sizes as requested
        color = listOf(
            ProductColor(colorName = "Black", colorCode = "#000000"),
            ProductColor(colorName = "White", colorCode = "#FFFFFF")
        ),
        price = "₹1299",
        oldPrice = "₹599", // Provided old price
        imageUrl = listOf(
            "https://static.vecteezy.com/system/resources/thumbnails/009/273/280/small/concept-of-loneliness-and-disappointment-in-love-sad-man-sitting-element-of-the-picture-is-decorated-by-nasa-free-photo.jpg",
            "https://static.vecteezy.com/system/resources/thumbnails/009/273/280/small/concept-of-loneliness-and-disappointment-in-love-sad-man-sitting-element-of-the-picture-is-decorated-by-nasa-free-photo.jpg"
        ),
        rating = 4.5f,
        reviewsCount = 100_152_157
    ), ProductDetails(
        productId = "11",
        title = "Black Winter HoodieBlack Winter Hoodie",
        shortDescription = "Autumn And Winter Casual Cotton-Padded Jacket",
        longDescription = "This black winter hoodie is perfect for autumn and winter with its casual cotton-padded design to keep you warm and stylish.",
        size = defaultSizeList,
        color = listOf(
            ProductColor(colorName = "Black", colorCode = "#000000")
        ),
        price = "₹499",
        oldPrice = "₹599",
        imageUrl = listOf(
            "https://basket-15.wbbasket.ru/vol2300/part230005/230005258/images/big/1.webp",
            "https://basket-15.wbbasket.ru/vol2300/part230005/230005258/images/big/1.webp"
        ),
        rating = 4.0f,
        reviewsCount = 100_152_157
    ), ProductDetails(
        productId = "12",
        title = "Men's Starry Shirt",
        shortDescription = "Men's Starry Sky Printed Shirt 100% Cotton Fabric",
        longDescription = "This men's starry sky printed shirt is made from 100% cotton fabric, offering both comfort and style for casual wear.",
        size = defaultSizeList,
        color = listOf(
            ProductColor(colorName = "Navy Blue", colorCode = "#000080")
        ),
        price = "399",
        oldPrice = null,
        imageUrl = listOf(
            "https://basket-10.wbbasket.ru/vol1560/part156075/156075698/images/big/1.webp",
            "https://basket-10.wbbasket.ru/vol1560/part156075/156075698/images/big/1.webp"
        ),
        rating = 4.5f,
        reviewsCount = 0
    ), ProductDetails(
        productId = "13",
        title = "Elegant Black Dress",
        shortDescription = "Beautiful sleeveless evening dress perfect for parties",
        longDescription = "This elegant black dress is perfect for evening parties with its sleeveless design, offering both style and comfort.",
        size = defaultSizeList,
        color = listOf(
            ProductColor(colorName = "Black", colorCode = "#000000")
        ),
        price = "₹799",
        oldPrice = "₹599",
        imageUrl = listOf(
            "https://basket-15.wbbasket.ru/vol2223/part222311/222311401/images/big/1.webp",
            "https://basket-15.wbbasket.ru/vol2223/part222311/222311401/images/big/1.webp"
        ),
        rating = 4.7f,
        reviewsCount = 100_152_157
    ), ProductDetails(
        productId = "14",
        title = "Pink Embroidered Dress",
        shortDescription = "Casual pink dress with beautiful embroidery details",
        longDescription = "This casual pink dress features intricate embroidery details, making it a stylish and comfortable choice for everyday wear.",
        size = defaultSizeList,
        color = listOf(
            ProductColor(colorName = "Pink", colorCode = "#FFC0CB")
        ),
        price = "₹699",
        oldPrice = null,
        imageUrl = listOf(
            "https://images.pexels.com/photos/674010/pexels-photo-674010.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            "https://images.pexels.com/photos/674010/pexels-photo-674010.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
        ),
        rating = 4.2f,
        reviewsCount = 0
    ), ProductDetails(
        productId = "15",
        title = "Casual Denim Jacket",
        shortDescription = "Classic blue denim jacket for all seasons",
        longDescription = "This classic blue denim jacket is designed for all seasons, offering both style and comfort. Perfect for casual outings and layering over your favorite outfits.",
        size = defaultSizeList,
        color = listOf(
            ProductColor(colorName = "Blue", colorCode = "#0000FF")
        ),
        price = "₹599",
        oldPrice = null,
        imageUrl = listOf(
            "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg",
            "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg"
        ),
        rating = 4.1f,
        reviewsCount = 0
    ), ProductDetails(
        productId = "16",
        title = "Comfy Sneakers",
        shortDescription = "Lightweight and comfortable sneakers for daily wear",
        longDescription = "These sneakers are designed for comfort and style. They are lightweight, making them perfect for daily wear, and offer great support throughout the day.",
        size = defaultSizeList,
        color = listOf(
            ProductColor(colorName = "White", colorCode = "#FFFFFF"),
            ProductColor(colorName = "Black", colorCode = "#000000")
        ),
        price = "₹499",
        oldPrice = "₹599",
        imageUrl = listOf(
            "https://i0.wp.com/picjumbo.com/wp-content/uploads/amazing-stone-path-in-forest-free-image.jpg?w=600&quality=80",
            "https://i0.wp.com/picjumbo.com/wp-content/uploads/amazing-stone-path-in-forest-free-image.jpg?w=600&quality=80"
        ),
        rating = 4.6f,
        reviewsCount = 100_152_157
    ), ProductDetails(
        productId = "17",
        title = "Trendy Sunglasses",
        shortDescription = "Stylish sunglasses with UV protection",
        longDescription = "These sunglasses combine style and functionality with UV protection to keep your eyes safe while adding a trendy touch to your look.",
        size = defaultSizeList,
        color = listOf(
            ProductColor(colorName = "Black", colorCode = "#000000"),
            ProductColor(colorName = "Brown", colorCode = "#8B4513")
        ),
        price = "₹299",
        oldPrice = null,
        imageUrl = listOf(
            "https://th.bing.com/th/id/OIG1.CgTbIrO0vUXLNU28HMdC",
            "https://th.bing.com/th/id/OIG1.CgTbIrO0vUXLNU28HMdC"
        ),
        rating = 4.4f,
        reviewsCount = 0
    ), ProductDetails(
        productId = "18",
        title = "Smart Fitness Band",
        shortDescription = "Track your fitness with heart rate and sleep monitor",
        longDescription = "A smart fitness band to help you track your daily fitness activities, monitor your heart rate, and improve your sleep patterns.",
        size = defaultSizeList,
        color = listOf(
            ProductColor(colorName = "Black", colorCode = "#000000"),
            ProductColor(colorName = "Blue", colorCode = "#0000FF")
        ),
        price = "₹999",
        oldPrice = null,
        imageUrl = listOf(
            "https://picsum.photos/200/300", "https://picsum.photos/200/300"
        ),
        rating = 4.3f,
        reviewsCount = 0
    ), ProductDetails(
        productId = "19",
        title = "Leather Wallet",
        shortDescription = "High-quality leather wallet with multiple compartments",
        longDescription = "A premium leather wallet with several compartments to store your cards, cash, and more. Durable and stylish.",
        size = defaultSizeList,
        color = listOf(
            ProductColor(colorName = "Brown", colorCode = "#8B4513"),
            ProductColor(colorName = "Black", colorCode = "#000000")
        ),
        price = "₹349",
        oldPrice = "₹599",
        imageUrl = listOf(
            "https://img.freepik.com/free-photo/colorful-design-with-spiral-design_188544-9588.jpg",
            "https://img.freepik.com/free-photo/colorful-design-with-spiral-design_188544-9588.jpg"
        ),
        rating = 4.8f,
        reviewsCount = 100_152_157
    ), ProductDetails(
        productId = "20",
        title = "Bluetooth Headphones",
        shortDescription = "Wireless headphones with noise-cancellation",
        longDescription = "Experience immersive sound with these wireless headphones equipped with noise-cancellation for the best listening experience.",
        size = defaultSizeList,
        color = listOf(
            ProductColor(colorName = "Black", colorCode = "#000000"),
            ProductColor(colorName = "White", colorCode = "#FFFFFF")
        ),
        price = "₹1299",
        oldPrice = "₹599",
        imageUrl = listOf(
            "https://static.vecteezy.com/system/resources/thumbnails/009/273/280/small/concept-of-loneliness-and-disappointment-in-love-sad-man-sitting-element-of-the-picture-is-decorated-by-nasa-free-photo.jpg",
            "https://static.vecteezy.com/system/resources/thumbnails/009/273/280/small/concept-of-loneliness-and-disappointment-in-love-sad-man-sitting-element-of-the-picture-is-decorated-by-nasa-free-photo.jpg"
        ),
        rating = 4.5f,
        reviewsCount = 100_152_157
    )
)