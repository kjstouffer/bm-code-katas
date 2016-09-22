/**
 * Created by keithstouffer on 9/22/16.
 */
class BookSetCollection {
    var bookSets:MutableList<BookSet> = mutableListOf()

    fun addAllBooksToSets(books:List<Int>){
        var bookList = books.toMutableList()
        while(!bookList.isEmpty()){
            var book = bookList.get(0)
            addBookToSet(book)
            bookList.removeAt(0)
        }
    }

    fun addBookToSet(book:Int){
        var isBookAdded = false
        for(bookSet:BookSet in bookSets){
            if(bookSet.addBook(book)){
                isBookAdded = true
                break
            }
        }
        if(!isBookAdded){
            //add a new list to booksets
            var bookSet:BookSet = BookSet()
            bookSet.addBook(book)
            bookSets.add(bookSet)
        }
    }

    fun getTotalPrice():Double{
        var totalPrice:Double = 0.0
        for(bookSet:BookSet in bookSets){
            totalPrice += bookSet.getPrice()
        }
        return totalPrice
    }
}