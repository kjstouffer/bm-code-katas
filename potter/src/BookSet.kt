/**
 * Created by keithstouffer on 9/22/16.
 */
class BookSet {

    private val setPrices:Map<Double,Double> = mapOf(
            Pair(0.0,0.0),
            Pair(1.0,8.0),
            Pair(2.0,8.0*.95),
            Pair(3.0,8.0*.90),
            Pair(4.0,8.0*.80),
            Pair(5.0,8.0*.75)
    )


    var numberOfBooks:Double = 0.0
    var books:MutableSet<Int> = mutableSetOf();


    fun getPrice():Double{
        if(numberOfBooks > 5.0) return 0.0;
        return setPrices.get(numberOfBooks)!! * numberOfBooks
    }

    fun addBook(bookNumber:Int):Boolean{
        val isBookAdded = books.add(bookNumber)
        numberOfBooks = books.size.toDouble()
        return isBookAdded
    }

    fun isEmpty():Boolean{
        return numberOfBooks == 0.0
    }
}