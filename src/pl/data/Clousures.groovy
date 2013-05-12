package pl.data
/**
 * Created with IntelliJ IDEA.
 * User: Zbyszek Sokołowski
 * Date: 5/1/13
 * Time: 11:51 PM
 */
class Clousures {
    public static void  toUpperCase() {
    def list = ['a','b','c','d']
    def upperCase = list.collect { it.toUpperCase() }
    assert list instanceof ArrayList
    assert upperCase == ["A", "B", "C", "D"]
    println upperCase

    upperCase.add("E")
    assert upperCase == ["A", "B", "C", "D", "E"]

    ArrayList<String> found = upperCase.findAll { it > "C"}
    println found


    }

    public static void listFile(String fileName) {

        def number = 0
        String fileToView = fileName ?: 'data.txt'    //elvis operator - compact ternary operator
        new File(fileToView).eachLine { line ->
            number++
            println "$number: $line"
        }
    }
}
