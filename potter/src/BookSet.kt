/**
 * Created by keithstouffer on 9/22/16.
 */
class BookSet {

    var numberOfBooks:Double = 0.0
    var books:MutableSet<Int> = mutableSetOf();


    fun getPrice():Double{
        if(numberOfBooks == 0.0) return 0.0
        if(numberOfBooks == 1.0) return 8.0
        if(numberOfBooks < 4.0){
            return numberOfBooks * 8.0 *  (1 - (numberOfBooks - 1.0) * 0.05 )
        }
        else{
            return numberOfBooks * 8.0 * (1 - (numberOfBooks * 0.05))
        }
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