package com.example.jetpackcomposeuidesigns.daily_ui_designs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.HeartBroken
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeuidesigns.R


@Composable
fun MyntraProductUI23Oct2024(modifier: Modifier = Modifier) {
    Scaffold(
        containerColor = Color.White
    ) { padding ->
        Column(
            modifier
                .padding(padding)
        ) {
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(shirtsList) { item ->
                    Column(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(5.dp)
                    ) {
                        Box {
                            Image(
                                painter = painterResource(R.drawable.campussutraimg),
                                contentDescription = item.productName, contentScale = ContentScale.Crop,
                                modifier = modifier.fillMaxSize().
                                clip(shape = RoundedCornerShape(10.dp)),
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = modifier
                                    .padding(5.dp)
                                    .background(color = Color.LightGray,
                                        shape = CircleShape
                                    )
                                    .padding(3.dp)
                                    .align(Alignment.BottomStart)
                            ) {
                                Text(item.ratings.toString(),
                                    style = TextStyle(
                                        fontSize = 10.sp,
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold
                                    ),
                                    modifier = modifier
                                        .padding(3.dp))
                                Icon(
                                    Icons.Outlined.Star, contentDescription = "Rating",
                                    modifier = modifier.size(10.dp),
                                    tint = Color(0xFF063E2A)
                                )

                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(top = 5.dp)
                        ) {
                            Column(modifier = modifier.weight(.8f)) {
                                Text(
                                    item.productName, style = TextStyle(
                                        fontSize = 14.sp,
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    item.brand, style = TextStyle(
                                        fontSize = 10.sp,
                                        color = Color.DarkGray
                                    ),
                                    modifier = modifier.paddingFromBaseline(bottom = 5.dp)
                                )
                                Text(
                                    "Festive Price Drop",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold
                                    ),
                                    modifier = modifier
                                        .background(
                                            color = Color.Red,
                                            shape = RoundedCornerShape(5.dp)
                                        )
                                        .padding(3.dp)
                                )
                                Row(
                                    modifier = modifier.padding(top = 3.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        "\$${item.price.toInt()}", style = TextStyle(
                                            fontSize = 12.sp,
                                            color = Color.Gray
                                        ),
                                        textDecoration = TextDecoration.LineThrough
                                    )
                                    Text(
                                        "\$${item.discountPrice.toInt()}", style = TextStyle(
                                            fontSize = 12.sp,
                                            color = Color.Black,
                                            fontWeight = FontWeight.ExtraBold
                                        ),
                                        modifier = modifier.padding(horizontal = 5.dp)
                                    )
                                    Text(
                                        "63% OFF!",
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            color = Color(0xFFFF0000),
                                            fontWeight = FontWeight.Bold
                                        ),
                                        modifier = modifier
                                            .background(
                                                brush = Brush.linearGradient(
                                                    colors = listOf(
                                                        Color.White, Color(
                                                            0xA6FF5E5E
                                                        )
                                                    )
                                                ),
                                            )
                                            .padding(3.dp)
                                    )
                                }
                            }
                            Icon(
                                Icons.Outlined.HeartBroken, contentDescription = "Like",
                                modifier = modifier.size(24.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun MyntraProductUI23Oct2024Preview() {
    MyntraProductUI23Oct2024()
}

data class Shirt(
    val productName: String,
    val brand: String,
    val description: String,
    val price: Double,
    val discountPrice: Double,
    val sizesAvailable: List<String>,
    val colorOptions: List<String>,
    val ratings: Double,
    val material: String,
    val careInstructions: List<String>,
    val images: List<String> // URLs or resource IDs for product images
)

val shirtsList = listOf(
    Shirt(
        productName = "Casual Cotton Shirt",
        brand = "TrendyWear",
        description = "A stylish and comfortable cotton shirt perfect for casual outings.",
        price = 1299.0,
        discountPrice = 899.0,
        sizesAvailable = listOf("S", "M", "L", "XL"),
        colorOptions = listOf("Blue", "White", "Green", "Grey"),
        ratings = 4.5,
        material = "100% Cotton",
        careInstructions = listOf(
            "Machine wash cold.",
            "Do not bleach.",
            "Tumble dry low."
        ),
        images = listOf(
            "url_to_front_view_1",
            "url_to_back_view_1",
            "url_to_fabric_texture_1",
            "url_to_model_wearing_1"
        )
    ),
    Shirt(
        productName = "Formal Dress Shirt",
        brand = "EliteStyle",
        description = "Perfect for business meetings and formal events.",
        price = 1799.0,
        discountPrice = 1399.0,
        sizesAvailable = listOf("M", "L", "XL"),
        colorOptions = listOf("White", "Black", "Navy"),
        ratings = 4.8,
        material = "Cotton Blend",
        careInstructions = listOf(
            "Dry clean only.",
            "Iron on low heat."
        ),
        images = listOf(
            "url_to_front_view_2",
            "url_to_back_view_2",
            "url_to_fabric_texture_2",
            "url_to_model_wearing_2"
        )
    ),
    Shirt(
        productName = "Denim Shirt",
        brand = "DenimCo",
        description = "A rugged and stylish denim shirt for casual wear.",
        price = 1599.0,
        discountPrice = 1199.0,
        sizesAvailable = listOf("S", "M", "L"),
        colorOptions = listOf("Light Blue", "Dark Blue"),
        ratings = 4.6,
        material = "100% Denim",
        careInstructions = listOf(
            "Machine wash cold.",
            "Do not tumble dry."
        ),
        images = listOf(
            "url_to_front_view_3",
            "url_to_back_view_3",
            "url_to_fabric_texture_3",
            "url_to_model_wearing_3"
        )
    ),
    Shirt(
        productName = "Printed Casual Shirt",
        brand = "FashionHub",
        description = "A vibrant printed shirt for a trendy look.",
        price = 999.0,
        discountPrice = 699.0,
        sizesAvailable = listOf("M", "L", "XL"),
        colorOptions = listOf("Red", "Black", "White"),
        ratings = 4.3,
        material = "Cotton",
        careInstructions = listOf(
            "Machine wash cold.",
            "Do not bleach."
        ),
        images = listOf(
            "url_to_front_view_4",
            "url_to_back_view_4",
            "url_to_fabric_texture_4",
            "url_to_model_wearing_4"
        )
    ),
    Shirt(
        productName = "Hawaiian Shirt",
        brand = "TropicalWear",
        description = "A fun and colorful Hawaiian shirt for summer days.",
        price = 1299.0,
        discountPrice = 899.0,
        sizesAvailable = listOf("S", "M", "L"),
        colorOptions = listOf("Floral", "Stripes"),
        ratings = 4.5,
        material = "Rayon",
        careInstructions = listOf(
            "Machine wash cold.",
            "Iron on low heat."
        ),
        images = listOf(
            "url_to_front_view_5",
            "url_to_back_view_5",
            "url_to_fabric_texture_5",
            "url_to_model_wearing_5"
        )
    ),
    Shirt(
        productName = "Linen Summer Shirt",
        brand = "CoolCotton",
        description = "A breathable linen shirt ideal for hot weather.",
        price = 1499.0,
        discountPrice = 1099.0,
        sizesAvailable = listOf("M", "L", "XL"),
        colorOptions = listOf("Beige", "White"),
        ratings = 4.7,
        material = "100% Linen",
        careInstructions = listOf(
            "Machine wash cold.",
            "Iron on medium heat."
        ),
        images = listOf(
            "url_to_front_view_6",
            "url_to_back_view_6",
            "url_to_fabric_texture_6",
            "url_to_model_wearing_6"
        )
    ),
    Shirt(
        productName = "Graphic Tee",
        brand = "StreetStyle",
        description = "A trendy graphic tee for casual outings.",
        price = 799.0,
        discountPrice = 599.0,
        sizesAvailable = listOf("S", "M", "L"),
        colorOptions = listOf("Black", "White", "Grey"),
        ratings = 4.2,
        material = "100% Cotton",
        careInstructions = listOf(
            "Machine wash cold.",
            "Do not iron on print."
        ),
        images = listOf(
            "url_to_front_view_7",
            "url_to_back_view_7",
            "url_to_fabric_texture_7",
            "url_to_model_wearing_7"
        )
    ),
    Shirt(
        productName = "Polo Shirt",
        brand = "ClassicFit",
        description = "A classic polo shirt for a sporty look.",
        price = 1099.0,
        discountPrice = 749.0,
        sizesAvailable = listOf("S", "M", "L", "XL"),
        colorOptions = listOf("Navy", "Red", "Green"),
        ratings = 4.5,
        material = "Cotton Blend",
        careInstructions = listOf(
            "Machine wash cold.",
            "Do not bleach."
        ),
        images = listOf(
            "url_to_front_view_8",
            "url_to_back_view_8",
            "url_to_fabric_texture_8",
            "url_to_model_wearing_8"
        )
    ),
    Shirt(
        productName = "Oversized T-Shirt",
        brand = "UrbanStyle",
        description = "A trendy oversized t-shirt for a relaxed fit.",
        price = 899.0,
        discountPrice = 649.0,
        sizesAvailable = listOf("M", "L"),
        colorOptions = listOf("Black", "White", "Olive"),
        ratings = 4.4,
        material = "100% Cotton",
        careInstructions = listOf(
            "Machine wash cold.",
            "Do not tumble dry."
        ),
        images = listOf(
            "url_to_front_view_9",
            "url_to_back_view_9",
            "url_to_fabric_texture_9",
            "url_to_model_wearing_9"
        )
    ),
    Shirt(
        productName = "Flannel Shirt",
        brand = "CozyWear",
        description = "A warm flannel shirt perfect for cooler days.",
        price = 1299.0,
        discountPrice = 999.0,
        sizesAvailable = listOf("M", "L"),
        colorOptions = listOf("Plaid Red", "Plaid Blue"),
        ratings = 4.6,
        material = "Cotton Flannel",
        careInstructions = listOf(
            "Machine wash cold.",
            "Do not bleach."
        ),
        images = listOf(
            "url_to_front_view_10",
            "url_to_back_view_10",
            "url_to_fabric_texture_10",
            "url_to_model_wearing_10"
        )
    ),
    Shirt(
        productName = "Sporty Workout Shirt",
        brand = "ActiveWear",
        description = "A lightweight shirt for workouts and sports activities.",
        price = 999.0,
        discountPrice = 749.0,
        sizesAvailable = listOf("S", "M", "L"),
        colorOptions = listOf("Black", "Blue", "Grey"),
        ratings = 4.5,
        material = "Moisture-Wicking Fabric",
        careInstructions = listOf(
            "Machine wash cold.",
            "Do not bleach."
        ),
        images = listOf(
            "url_to_front_view_11",
            "url_to_back_view_11",
            "url_to_fabric_texture_11",
            "url_to_model_wearing_11"
        )
    ),
    Shirt(
        productName = "Floral Print Shirt",
        brand = "SpringStyle",
        description = "A fresh floral print shirt perfect for spring.",
        price = 1099.0,
        discountPrice = 799.0,
        sizesAvailable = listOf("S", "M", "L", "XL"),
        colorOptions = listOf("Pink", "Blue", "Yellow"),
        ratings = 4.4,
        material = "Cotton",
        careInstructions = listOf(
            "Machine wash cold.",
            "Iron on low heat."
        ),
        images = listOf(
            "url_to_front_view_12",
            "url_to_back_view_12",
            "url_to_fabric_texture_12",
            "url_to_model_wearing_12"
        )
    ),
    Shirt(
        productName = "Vintage Denim Shirt",
        brand = "RetroDenim",
        description = "A classic vintage-style denim shirt.",
        price = 1599.0,
        discountPrice = 1199.0,
        sizesAvailable = listOf("M", "L", "XL"),
        colorOptions = listOf("Washed Blue", "Dark Denim"),
        ratings = 4.7,
        material = "100% Denim",
        careInstructions = listOf(
            "Machine wash cold.",
            "Do not tumble dry."
        ),
        images = listOf(
            "url_to_front_view_13",
            "url_to_back_view_13",
            "url_to_fabric_texture_13",
            "url_to_model_wearing_13"
        )
    ),
    Shirt(
        productName = "Striped Casual Shirt",
        brand = "Stripes&Co",
        description = "A trendy striped shirt for casual outings.",
        price = 999.0,
        discountPrice = 699.0,
        sizesAvailable = listOf("S", "M", "L"),
        colorOptions = listOf("Red & White", "Navy & White"),
        ratings = 4.5,
        material = "Cotton Blend",
        careInstructions = listOf(
            "Machine wash cold.",
            "Do not bleach."
        ),
        images = listOf(
            "url_to_front_view_14",
            "url_to_back_view_14",
            "url_to_fabric_texture_14",
            "url_to_model_wearing_14"
        )
    ),
    Shirt(
        productName = "Bamboo Viscose Shirt",
        brand = "EcoFashion",
        description = "A soft and eco-friendly bamboo shirt.",
        price = 1399.0,
        discountPrice = 999.0,
        sizesAvailable = listOf("M", "L", "XL"),
        colorOptions = listOf("Cream", "Brown"),
        ratings = 4.6,
        material = "Bamboo Viscose",
        careInstructions = listOf(
            "Machine wash cold.",
            "Iron on low heat."
        ),
        images = listOf(
            "url_to_front_view_15",
            "url_to_back_view_15",
            "url_to_fabric_texture_15",
            "url_to_model_wearing_15"
        )
    ),
    Shirt(
        productName = "Graphic Print Long Sleeve",
        brand = "UrbanTrend",
        description = "A cool long sleeve shirt with graphic print.",
        price = 1099.0,
        discountPrice = 849.0,
        sizesAvailable = listOf("M", "L"),
        colorOptions = listOf("Black", "White"),
        ratings = 4.3,
        material = "100% Cotton",
        careInstructions = listOf(
            "Machine wash cold.",
            "Do not iron on print."
        ),
        images = listOf(
            "url_to_front_view_16",
            "url_to_back_view_16",
            "url_to_fabric_texture_16",
            "url_to_model_wearing_16"
        )
    ),
    Shirt(
        productName = "Luxe Satin Shirt",
        brand = "Elegance",
        description = "A luxurious satin shirt for special occasions.",
        price = 2499.0,
        discountPrice = 1999.0,
        sizesAvailable = listOf("S", "M", "L"),
        colorOptions = listOf("Black", "Emerald"),
        ratings = 4.8,
        material = "Satin",
        careInstructions = listOf(
            "Dry clean only.",
            "Iron on low heat."
        ),
        images = listOf(
            "url_to_front_view_17",
            "url_to_back_view_17",
            "url_to_fabric_texture_17",
            "url_to_model_wearing_17"
        )
    ),
    Shirt(
        productName = "Basic Crew Neck Tee",
        brand = "EverydayWear",
        description = "A basic crew neck tee for everyday use.",
        price = 499.0,
        discountPrice = 349.0,
        sizesAvailable = listOf("S", "M", "L", "XL"),
        colorOptions = listOf("White", "Black", "Grey"),
        ratings = 4.2,
        material = "100% Cotton",
        careInstructions = listOf(
            "Machine wash cold.",
            "Do not bleach."
        ),
        images = listOf(
            "url_to_front_view_18",
            "url_to_back_view_18",
            "url_to_fabric_texture_18",
            "url_to_model_wearing_18"
        )
    ),
    Shirt(
        productName = "Active Yoga Shirt",
        brand = "FitLife",
        description = "A lightweight and breathable shirt for yoga.",
        price = 899.0,
        discountPrice = 649.0,
        sizesAvailable = listOf("M", "L"),
        colorOptions = listOf("Lavender", "Peach"),
        ratings = 4.5,
        material = "Moisture-Wicking Fabric",
        careInstructions = listOf(
            "Machine wash cold.",
            "Do not bleach."
        ),
        images = listOf(
            "url_to_front_view_19",
            "url_to_back_view_19",
            "url_to_fabric_texture_19",
            "url_to_model_wearing_19"
        )
    ),
    Shirt(
        productName = "Safari Adventure Shirt",
        brand = "Outdoorsy",
        description = "A rugged shirt designed for outdoor adventures.",
        price = 1399.0,
        discountPrice = 999.0,
        sizesAvailable = listOf("S", "M", "L"),
        colorOptions = listOf("Khaki", "Olive"),
        ratings = 4.4,
        material = "100% Cotton",
        careInstructions = listOf(
            "Machine wash cold.",
            "Iron on low heat."
        ),
        images = listOf(
            "url_to_front_view_20",
            "url_to_back_view_20",
            "url_to_fabric_texture_20",
            "url_to_model_wearing_20"
        )
    ),
    Shirt(
        productName = "Floral Print Shirt",
        brand = "SpringStyle",
        description = "A fresh floral print shirt perfect for spring.",
        price = 1099.0,
        discountPrice = 799.0,
        sizesAvailable = listOf("S", "M", "L", "XL"),
        colorOptions = listOf("Pink", "Blue", "Yellow"),
        ratings = 4.4,
        material = "Cotton",
        careInstructions = listOf(
            "Machine wash cold.",
            "Iron on low heat."
        ),
        images = listOf(
            "url_to_front_view_12",
            "url_to_back_view_12",
            "url_to_fabric_texture_12",
            "url_to_model_wearing_12"
        )
    ),
    Shirt(
        productName = "Vintage Denim Shirt",
        brand = "RetroDenim",
        description = "A classic vintage-style denim shirt.",
        price = 1599.0,
        discountPrice = 1199.0,
        sizesAvailable = listOf("M", "L", "XL"),
        colorOptions = listOf("Washed Blue", "Dark Denim"),
        ratings = 4.7,
        material = "100% Denim",
        careInstructions = listOf(
            "Machine wash cold.",
            "Do not tumble dry."
        ),
        images = listOf(
            "url_to_front_view_13",
            "url_to_back_view_13",
            "url_to_fabric_texture_13",
            "url_to_model_wearing_13"
        )
    ),
    Shirt(
        productName = "Striped Casual Shirt",
        brand = "Stripes&Co",
        description = "A trendy striped shirt for casual outings.",
        price = 999.0,
        discountPrice = 699.0,
        sizesAvailable = listOf("S", "M", "L"),
        colorOptions = listOf("Red & White", "Navy & White"),
        ratings = 4.5,
        material = "Cotton Blend",
        careInstructions = listOf(
            "Machine wash cold.",
            "Do not bleach."
        ),
        images = listOf(
            "url_to_front_view_14",
            "url_to_back_view_14",
            "url_to_fabric_texture_14",
            "url_to_model_wearing_14"
        )
    ),
    Shirt(
        productName = "Bamboo Viscose Shirt",
        brand = "EcoFashion",
        description = "A soft and eco-friendly bamboo shirt.",
        price = 1399.0,
        discountPrice = 999.0,
        sizesAvailable = listOf("M", "L", "XL"),
        colorOptions = listOf("Cream", "Brown"),
        ratings = 4.6,
        material = "Bamboo Viscose",
        careInstructions = listOf(
            "Machine wash cold.",
            "Iron on low heat."
        ),
        images = listOf(
            "url_to_front_view_15",
            "url_to_back_view_15",
            "url_to_fabric_texture_15",
            "url_to_model_wearing_15"
        )
    ),
    Shirt(
        productName = "Graphic Print Long Sleeve",
        brand = "UrbanTrend",
        description = "A cool long sleeve shirt with graphic print.",
        price = 1099.0,
        discountPrice = 849.0,
        sizesAvailable = listOf("M", "L"),
        colorOptions = listOf("Black", "White"),
        ratings = 4.3,
        material = "100% Cotton",
        careInstructions = listOf(
            "Machine wash cold.",
            "Do not iron on print."
        ),
        images = listOf(
            "url_to_front_view_16",
            "url_to_back_view_16",
            "url_to_fabric_texture_16",
            "url_to_model_wearing_16"
        )
    ),
    Shirt(
        productName = "Luxe Satin Shirt",
        brand = "Elegance",
        description = "A luxurious satin shirt for special occasions.",
        price = 2499.0,
        discountPrice = 1999.0,
        sizesAvailable = listOf("S", "M", "L"),
        colorOptions = listOf("Black", "Emerald"),
        ratings = 4.8,
        material = "Satin",
        careInstructions = listOf(
            "Dry clean only.",
            "Iron on low heat."
        ),
        images = listOf(
            "url_to_front_view_17",
            "url_to_back_view_17",
            "url_to_fabric_texture_17",
            "url_to_model_wearing_17"
        )
    ),
    Shirt(
        productName = "Basic Crew Neck Tee",
        brand = "EverydayWear",
        description = "A basic crew neck tee for everyday use.",
        price = 499.0,
        discountPrice = 349.0,
        sizesAvailable = listOf("S", "M", "L", "XL"),
        colorOptions = listOf("White", "Black", "Grey"),
        ratings = 4.2,
        material = "100% Cotton",
        careInstructions = listOf(
            "Machine wash cold.",
            "Do not bleach."
        ),
        images = listOf(
            "url_to_front_view_18",
            "url_to_back_view_18",
            "url_to_fabric_texture_18",
            "url_to_model_wearing_18"
        )
    ),
    Shirt(
        productName = "Active Yoga Shirt",
        brand = "FitLife",
        description = "A lightweight and breathable shirt for yoga.",
        price = 899.0,
        discountPrice = 649.0,
        sizesAvailable = listOf("M", "L"),
        colorOptions = listOf("Lavender", "Peach"),
        ratings = 4.5,
        material = "Moisture-Wicking Fabric",
        careInstructions = listOf(
            "Machine wash cold.",
            "Do not bleach."
        ),
        images = listOf(
            "url_to_front_view_19",
            "url_to_back_view_19",
            "url_to_fabric_texture_19",
            "url_to_model_wearing_19"
        )
    ),
    Shirt(
        productName = "Safari Adventure Shirt",
        brand = "Outdoorsy",
        description = "A rugged shirt designed for outdoor adventures.",
        price = 1399.0,
        discountPrice = 999.0,
        sizesAvailable = listOf("S", "M", "L"),
        colorOptions = listOf("Khaki", "Olive"),
        ratings = 4.4,
        material = "100% Cotton",
        careInstructions = listOf(
            "Machine wash cold.",
            "Iron on low heat."
        ),
        images = listOf(
            "url_to_front_view_20",
            "url_to_back_view_20",
            "url_to_fabric_texture_20",
            "url_to_model_wearing_20"
        )
    ),
)
