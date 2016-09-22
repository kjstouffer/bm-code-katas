import java.util.*

val mySet:SortedSet<Int> = sortedSetOf(1,2,4,5,3)

/**
 * Created by keithstouffer on 8/25/16.
 */


fun main(args : Array<String>){

    val sortedArray = listOf(4,5,6,7,8,9,10)

    println("result: " + binaryChop(sortedArray, -1))
    println("result: " + binaryChop(sortedArray, 0))
    println("result: " + binaryChop(sortedArray, 1))
    println("result: " + binaryChop(sortedArray, 2))
    println("result: " + binaryChop(sortedArray, 3))
    println("result: " + binaryChop(sortedArray, 4))
    println("result: " + binaryChop(sortedArray, 5))
    println("result: " + binaryChop(sortedArray, 6))
    println("result: " + binaryChop(sortedArray, 7))
    println("result: " + binaryChop(sortedArray, 8))
    println("result: " + binaryChop(sortedArray, 9))
    println("result: " + binaryChop(sortedArray, 10))
    println("result: " + binaryChop(sortedArray, 11))
}

 fun binaryChop(list: List<Int>, target: Int): Int{

     val middle: Int = list.size / 2
     if(list[0] >  target || list[list.size-1] < target ){
         return -1
     }
    else if(list[middle] == target){
        return middle
    }
    else if(list[middle] < target) {
        return middle + binaryChop(list.subList(middle, list.size), target)
    }
    else if( list[middle] > target){
        return binaryChop(list.subList(0, middle), target)
    }
    else{
        return -1
    }

}

