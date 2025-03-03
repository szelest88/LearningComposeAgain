package com.artmaj.myapplication

class BookNonData(var title: String, val author: String, var condition: BookCondition) {
// needed for comparison:

//    override fun equals(other: Any?): Boolean {
//        return (title == (other as BookNonData).title
//                &&
//                author == (other as BookNonData).author
//                &&
//                condition == (other as BookNonData).condition
//                )
//    }
//
//    override fun hashCode(): Int {
//        return arrayOf(title, author, condition).hashCode()
//    }
}
