package pl.data.CollectionsDemo

/**
 * Created with IntelliJ IDEA.
 * User: Zbyszek Sokołowski
 * Date: 5/9/13
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
class CollectionsDemo {

    static testList() {
        def myList = [1,2,3]
        assert myList.size() == 3

        assert myList[0] == 1
        assert myList instanceof ArrayList


        def emptyList = []
        assert emptyList.size() == 0

        myList = ['a','b','c','d','e','f']
        assert myList[0..2] == ['a','b','c']
        assert myList[0,2,4] == ['a','c','e']

        myList[0..2] = ['x','y','z']    //add items
        assert myList == ['x','y','z','d','e','f']

        myList[3..5] = []     //remove items
        assert myList == ['x','y','z']


        myList[1..1] = ['y','1','2']    //add items at position
        assert myList == ['x','y','1','2','z']

        myList = []
        myList += 'a'

        assert myList == ['a']
        myList += ['b','c']

        assert myList == ['a','b','c']

        myList = []
        myList << 'a' << 'b'

        assert myList == ['a','b']
        assert myList - ['b'] == ['a']
    }


    static showMoreIntrestingExampleList() {
        def list = [1,2,3]

        assert list.count(2) == 1
        assert list.max() == 3
        assert list.min() == 1

        def even = list.find { item ->
            item % 2 == 0
        }
        assert even == 2

        assert list.every { item -> item < 5}
        assert list.any { item -> item < 2}

        def store = ''
        list.each { item -> 
            store += item
        }
        assert store == '123'
        
        store = ''
        list.reverseEach{ item ->
            store += item 
        } 
        assert store == '321' 
        assert list.join(',') == '1,2,3'
        
        def result = list.inject(0){ extra, guests ->
            extra += guests
        } 
        assert result == 0 + 1+2+3
    }

    static def mapFunctionality() {
        def myMap = [a:1, b:2, c:3]
        assert myMap instanceof HashMap
        assert myMap.size() == 3
        assert myMap['a'] == 1
        def emptyMap = [:]
        assert emptyMap.size() == 0
    }
}
