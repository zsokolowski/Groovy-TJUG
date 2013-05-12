package pl.data

/**
 * Created with IntelliJ IDEA.
 * User: Zbyszek Sokołowski
 * Date: 5/7/13
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
class RegExpDemo {

    static testRegexp() {
        ("Zosia 1" =~ /(\w+) (\d+)/).each {full, name, age
            -> println "$name is $age years old."}
    }
}
