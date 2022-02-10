package com.example.libraryappui_androidjetpackcompose

val items = listOf(
    Book("Muscle", R.drawable.book_muscle, "Alan Trotter"),
    Book("Dominicana", R.drawable.book_dominicana, "Angie Cruz"),
    Book("A New Program for Graphic Design", R.drawable.book_a_new, "David Reinfurt"),
)

data class Book(
    val title: String,
    val image: Int,
    val author: String
)

val myBookItems = listOf(
    MyBook(Book("Just My Type", R.drawable.book_just_my_type, "Simon Garfield"), "25.03.2022", 75f),
    MyBook(items[0], "25.02.2022", 80f),
    MyBook(items[1], "21.01.2022", 90f),
)

data class MyBook(
    val book: Book,
    val returnDate: String,
    val timeLeftPercentage: Float
)