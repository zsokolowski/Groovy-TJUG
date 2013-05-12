package pl.data.CollectionsDemo

/**
 * Created with IntelliJ IDEA.
 * User: Zbyszek Sokołowski
 * Date: 5/9/13
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
class RangesDemo {

    public static testRanges() {
        def a = 0..10
        assert a instanceof Range
        assert a.contains(5)
        a.each { print "${it.toString()}, "}

        def today = new Date()
        def dayBefore = today-2
        def datesRange = dayBefore..today
        println ""

        datesRange.each {println it.toString()}

    }

    static ageCalculation() {
        def insuranceRate
        def age = 36
        switch(age){
            case 16..20 : insuranceRate = 0.05 ; break
            case 21..50 : insuranceRate = 0.06 ; break
            case 51..65 : insuranceRate = 0.07 ; break
            default: throw new IllegalArgumentException()
        }
        assert insuranceRate == 0.06
        def ages = [20,36,42,56]
        def midage = 21..50
        assert ages.grep(midage) == [36,42]

        println ages.grep(midage)
    }

}
