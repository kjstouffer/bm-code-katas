fun price(booklist:Array<Int>):Double{
    var books = booklist.toList()
//    println("Testing: $books")

    //organize sets
    var bookSetCollection:BookSetCollection = BookSetCollection()
    bookSetCollection.addAllBooksToSets(books)
//    for(bookSet:BookSet in bookSetCollection.bookSets){
//        println(bookSet.books)
//    }
    return bookSetCollection.getTotalPrice()
}




fun main(args: Array<String>): Unit {
    testBasics()
    testSimpleDiscounts()
    testEdgeCases()
    testSeveralDiscounts()
}

fun  testBasics() {
    assert_equal(0, price(arrayOf()))
    assert_equal(8, price(arrayOf(0)))
    assert_equal(8, price(arrayOf(1)))
    assert_equal(8, price(arrayOf(2)))
    assert_equal(8, price(arrayOf(3)))
    assert_equal(8, price(arrayOf(4)))
    assert_equal(8 * 2, price(arrayOf(0, 0)))
    assert_equal(8 * 3, price(arrayOf(1, 1, 1)))
}

fun  testSimpleDiscounts() {
    assert_equal(8 * 2 * 0.95, price(arrayOf(0, 1)))
    assert_equal(8 * 3 * 0.9, price(arrayOf(0, 2, 4)))
    assert_equal(8 * 4 * 0.8, price(arrayOf(0, 1, 2, 4)))
    assert_equal(8 * 5 * 0.75, price(arrayOf(0, 1, 2, 3, 4)))
}

fun  testSeveralDiscounts() {
    assert_equal(8 + (8 * 2 * 0.95), price(arrayOf(0, 0, 1)))
    assert_equal(2 * (8 * 2 * 0.95), price(arrayOf(0, 0, 1, 1)))
    assert_equal((8 * 4 * 0.8) + (8 * 2 * 0.95), price(arrayOf(0, 0, 1, 2, 2, 3)))
    assert_equal(8 + (8 * 5 * 0.75), price(arrayOf(0, 1, 1, 2, 3, 4)))
}

fun  testEdgeCases() {
    assert_equal(2 * (8 * 4 * 0.8), price(arrayOf(0, 0, 1, 1, 2, 2, 3, 4)))
    assert_equal(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8),
            price(arrayOf(0, 0, 0, 0, 0,
                    1, 1, 1, 1, 1,
                    2, 2, 2, 2,
                    3, 3, 3, 3, 3,
                    4, 4, 4, 4)))
}

fun assert_equal(expected:Number, actual:Number): Boolean {
    if(Math.abs(expected.toDouble() - actual.toDouble()) < 0.001) {
        return true
    }
    println("Assert failed: expected: $expected, actual: $actual")
    return false
}