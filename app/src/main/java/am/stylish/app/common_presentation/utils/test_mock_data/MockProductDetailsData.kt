package am.stylish.app.common_presentation.utils.test_mock_data

import am.stylish.app.common_domain.model.details.ProductDetails
import am.stylish.app.common_domain.model.product.ProductColor

const val COMMON_DESCRIPTION =
    "This product is made with the highest quality materials to ensure durability and style."
private val defaultSizeList = listOf("6 UK", "7 UK", "8 UK", "9 UK", "10 UK")

val mockProductDetails = listOf(
    ProductDetails(
        productId = "1",
        title = "Nike SB Dunk Low Pro Premium",
        shortDescription = COMMON_DESCRIPTION,
        longDescription = "Crafted for modern style enthusiasts, this product combines elegance and comfort seamlessly. Ideal for everyday wear or special occasions. Elevate your wardrobe with this timeless addition.Crafted for modern style enthusiasts, this product combines elegance and comfort seamlessly. Ideal for everyday wear or special occasions. Elevate your wardrobe with this timeless addition.Crafted for modern style enthusiasts, this product combines elegance and comfort seamlessly. Ideal for everyday wear or special occasions. Elevate your wardrobe with this timeless addition.Crafted for modern style enthusiasts, this product combines elegance and comfort seamlessly. Ideal for everyday wear or special occasions. Elevate your wardrobe with this timeless addition.",
        size = defaultSizeList,
        color = listOf(
            ProductColor("Red", "#FF0000"),
            ProductColor("Blue", "#0000FF"),
            ProductColor("Black", "#000000")
        ),
        price = "125",
        imageUrl = listOf(
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/5e5e9811-9098-466c-a54a-360e0031539b/NIKE+SB+DUNK+LOW+PRO+PRM.png",
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/16932771-4d86-4050-9153-4f3342714987/NIKE+SB+DUNK+LOW+PRO+PRM.png",
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/427defe6-de52-4c56-9a14-276882f2edcf/NIKE+SB+DUNK+LOW+PRO+PRM.png",
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/f3d31b55-6795-41b6-9d93-22a36a6ef06f/NIKE+SB+DUNK+LOW+PRO+PRM.png",
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/d8b8ea7a-0913-4971-8959-89b4dc9a3f0b/NIKE+SB+DUNK+LOW+PRO+PRM.png",
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/6e8ee372-c9b9-40bc-a0bb-7eebf4974ec2/NIKE+SB+DUNK+LOW+PRO+PRM.png",
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/85425384-7403-4eab-98d9-f8bb031eeff7/NIKE+SB+DUNK+LOW+PRO+PRM.png",
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/6bba652e-f4e1-4b57-a420-5dcb79db95ff/NIKE+SB+DUNK+LOW+PRO+PRM.png",
        ),
        rating = 4.5f,
        reviewsCount = 52157
    ), ProductDetails(
        productId = "2",
        title = "Nike Air Max 90 Drift",
        shortDescription = "The Air Max 90 Drift adds a more durable option to your shoe rotation. Its color-blocked design helps accentuate the different textures and layers, including tough ripstop and rubber paired with real and synthetic leather. Meanwhile, Max Air cushioning and a Waffle outsole keep it comfortable enough for the street or trail.",
        longDescription = "The Air Max 90 Drift adds a more durable option to your shoe rotation. Its color-blocked design helps accentuate the different textures and layers, including tough ripstop and rubber paired with real and synthetic leather. Meanwhile, Max Air cushioning and a Waffle outsole keep it comfortable enough for the street or trail.",
        size = defaultSizeList,
        color = listOf(
            ProductColor("Red", "#FF0000"),
            ProductColor("Blue", "#0000FF"),
            ProductColor("Black", "#000000")
        ),
        price = "399",
        oldPrice = null,
        imageUrl = listOf(
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/7a0371bb-5c81-4042-9802-28c249c096a3/AIR+MAX+90+DRIFT.png",
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/d8aec4e7-5db3-4799-a3dc-ba7c8e43eac2/AIR+MAX+90+DRIFT.png",
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/94d59a22-acba-44e3-a914-fd98a9072919/AIR+MAX+90+DRIFT.png",
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/2fe4fb2f-578e-4b66-8ac6-75f6a32d51e3/AIR+MAX+90+DRIFT.png",
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/d65fc10e-c68a-4d49-a2a1-cac9294483e6/AIR+MAX+90+DRIFT.png",
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/585b7d80-0c70-4962-9f5a-2848c9330fb1/AIR+MAX+90+DRIFT.png",
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/674dd738-19be-4e95-b2ed-5c5127d13bb4/AIR+MAX+90+DRIFT.png",
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/da4d227e-d9e6-49e8-8455-5441853de2f1/AIR+MAX+90+DRIFT.png",
        ),
        rating = 4.5f,
        reviewsCount = 0
    ), ProductDetails(
        productId = "3",
        title = "Air Jordan 1 Mid SE",
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
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/c5ddb74a-80ea-4238-ad82-d95dfddb6fef/AIR+JORDAN+1+MID+SE.png",
            "https://basket-15.wbbasket.ru/vol2223/part222311/222311401/images/big/1.webp",
            "https://basket-15.wbbasket.ru/vol2223/part222311/222311401/images/big/1.webp",
        ),
        rating = 4.7f,
        reviewsCount = 100_152_157 // Provided in the input
    ), ProductDetails(
        productId = "4",
        title = "Pink Embroidered Dress",
        shortDescription = "An '80s b-ball icon returns with classic details and throwback hoops flair.",
        longDescription = "An '80s b-ball icon returns with classic details and throwback hoops flair. Channeling vintage style back onto the streets, its padded low-cut collar lets you comfortably take your game anywhere.",
        size = defaultSizeList, // Standard sizes as requested
        color = listOf(
            ProductColor(colorName = "Pink", colorCode = "#FFC0CB"),
            ProductColor(colorName = "Light Pink", colorCode = "#FFB6C1"),
            ProductColor(colorName = "Rose Pink", colorCode = "#FF69B4")
        ),
        price = "₹699",
        oldPrice = null, // No old price provided in input
        imageUrl = listOf(
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/ed8d46c0-d433-467c-a72a-c850d6380c85/NIKE+SB+DUNK+LOW+PRO.png",
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/35b8a643-85bf-40f3-a853-592269056cba/NIKE+SB+DUNK+LOW+PRO.png",
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/b11bf5b4-33bd-4ea3-b14c-aa614fb96827/NIKE+SB+DUNK+LOW+PRO.png",
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/52d006b8-cece-4fd9-9b21-cfea67883c57/NIKE+SB+DUNK+LOW+PRO.png",
            "https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/f464ec09-665a-42cd-88c9-02eb32fc7224/NIKE+SB+DUNK+LOW+PRO.png",
        ),
        rating = 4.2f,
        reviewsCount = 150_000
    ), ProductDetails(
        productId = "5",
        title = "Samba XLG Shoes",
        shortDescription = "Take your style to new places with the Samba XLG from adidas. Upgraded with premium suede and a gum rubber sole with finely textured sidewalls and a varied-tread traction pattern, it offers a brilliant mix of sporty sophistication and casual cool. The iconic quilted heel tab matches the material on the serrated 3-Stripes, while the ribbed, molded tongue is as comfortable as ever over the top of your foot. Big-letter Samba branding on the side lets everyone know how you step. A longtime streetwear staple, wear the XLG casually with track pants or fleece, or pair it with fashion jeans or chinos and wear it to work.",
        longDescription = "Take your style to new places with the Samba XLG from adidas. Upgraded with premium suede and a gum rubber sole with finely textured sidewalls and a varied-tread traction pattern, it offers a brilliant mix of sporty sophistication and casual cool. The iconic quilted heel tab matches the material on the serrated 3-Stripes, while the ribbed, molded tongue is as comfortable as ever over the top of your foot. Big-letter Samba branding on the side lets everyone know how you step. A longtime streetwear staple, wear the XLG casually with track pants or fleece, or pair it with fashion jeans or chinos and wear it to work.",
        size = defaultSizeList, // Standard sizes as requested
        color = listOf(
            ProductColor(colorName = "Blue", colorCode = "#0000FF"),
            ProductColor(colorName = "Dark Blue", colorCode = "#00008B"),
            ProductColor(colorName = "Light Blue", colorCode = "#ADD8E6")
        ),
        price = "110",
        oldPrice = null, // No old price provided in input
        imageUrl = listOf(
            "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/921e014556e74027bca600c618fe7583_9366/Samba_XLG_Shoes_Green_JI3198_01_standard_hover.jpg",
            "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/9df140a45fdb481cb043bd186896c939_9366/Samba_XLG_Shoes_Green_JI3198_02_standard.jpg",
            "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/9df140a45fdb481cb043bd186896c939_9366/Samba_XLG_Shoes_Green_JI3198_03_standard.jpg",
            "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/0cc68d38a02a40489c503cd499966688_9366/Samba_XLG_Shoes_Green_JI3198_04_standard.jpg",
            "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/fc5eeffe475d40f698bcb542124d5c58_9366/Samba_XLG_Shoes_Green_JI3198_05_standard.jpg",
            "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/492449ef428d4046863261b5f0117ec0_9366/Samba_XLG_Shoes_Green_JI3198_06_standard.jpg",
            "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/492449ef428d4046863261b5f0117ec0_9366/Samba_XLG_Shoes_Green_JI3198_07_standard.jpg",
            "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/a089c1d4385b4ff3b719004725029040_9366/Samba_XLG_Shoes_Green_JI3198_09_standard.jpg",
        ),
        rating = 4.1f,
        reviewsCount = 0 // No reviews count provided in input
    ), ProductDetails(
        productId = "6",
        title = "Samba XLG Shoes",
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
            "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/018194de07a540ffbf73c8137f79abd3_9366/Samba_XLG_Shoes_Brown_JI3196_01_00_standard.jpg",
            "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/e6b126665c7e426a9c1d7eaae710c937_9366/Samba_XLG_Shoes_Brown_JI3196_02_standard_hover.jpg",
            "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/9cef31fc3fd44a8a8c3e3be5e5233bc7_9366/Samba_XLG_Shoes_Brown_JI3196_03_standard.jpg",
            "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/9ac12919a33e40fe9520769345504bdc_9366/Samba_XLG_Shoes_Brown_JI3196_04_standard.jpg",
            "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/9ac12919a33e40fe9520769345504bdc_9366/Samba_XLG_Shoes_Brown_JI3196_04_standard.jpg",
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
        title = "Nike Heritage",
        shortDescription = "Take your gear to go with the Nike Heritage Backpack.",
        longDescription = "Take your gear to go with the Nike Heritage Backpack. Its spacious main compartment features a sleeve that holds up to a 15\" laptop, so your computer is never out of reach. 2 zippered accessories pockets help keep your gear organized and easy to grab. This product is made with at least 65% recycled polyester fibers.",
        size = defaultSizeList,
        color = listOf(
            ProductColor(colorName = "Pink", colorCode = "#FFC0CB")
        ),
        price = "₹699",
        oldPrice = null,
        imageUrl = listOf(
            "https://s3-alpha-sig.figma.com/img/ce8f/5f59/6f4bc239eaaba2d48652d030bce31853?Expires=1734307200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=H0QApAyaa0gjkqBwMfY2f-q7IJSmO7UNk2Ajfo2GmaN1N8RbHXW~bUGk2wlaPqGhd1v252x9R5WHN0y627HVFI-DROLLDFqUwpwjjxizmbpIziiByvo7jUizZ8J6L9i2mPGJPD2KndXFy2XdClTtnLRXhRJ0QSfw1w841YeWVXdeTTCd1ix09Y4ABEi8cq5ebZc-viOKzd-8N53jhgLACo1Mdy5YB9890LiVtqFgGHfuUyhFULoOGeXbitkD4VuLTqYcaTZryWcMxhqNwYoSFz2kbgv95kPipOf7g-CdhGc2fqbDrCY0s2IlJcy61rKjaCPibdDgX1ivANAjQyoLUQ__",
            "https://s3-alpha-sig.figma.com/img/ce8f/5f59/6f4bc239eaaba2d48652d030bce31853?Expires=1734307200&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=H0QApAyaa0gjkqBwMfY2f-q7IJSmO7UNk2Ajfo2GmaN1N8RbHXW~bUGk2wlaPqGhd1v252x9R5WHN0y627HVFI-DROLLDFqUwpwjjxizmbpIziiByvo7jUizZ8J6L9i2mPGJPD2KndXFy2XdClTtnLRXhRJ0QSfw1w841YeWVXdeTTCd1ix09Y4ABEi8cq5ebZc-viOKzd-8N53jhgLACo1Mdy5YB9890LiVtqFgGHfuUyhFULoOGeXbitkD4VuLTqYcaTZryWcMxhqNwYoSFz2kbgv95kPipOf7g-CdhGc2fqbDrCY0s2IlJcy61rKjaCPibdDgX1ivANAjQyoLUQ__"
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
