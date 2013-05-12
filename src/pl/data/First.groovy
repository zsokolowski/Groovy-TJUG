package pl.data

import pl.data.CollectionsDemo.CollectionsDemo
import pl.data.CollectionsDemo.RangesDemo
import pl.data.xmlExample.XMLDemo

/**
 * Created with IntelliJ IDEA.
 * User: Zbyszek Sokołowski
 * Date: 4/29/13
 * Time: 9:23 PM
 * To change this template use File | Settings | File Templates.
 */
class First {
    public static void main(String[] args) {
        def text = "Groovy !!!"
        println text
        assert text instanceof String

        Clousures.toUpperCase()
        println SingletonTest.instance.amSingleton

        Clousures.listFile(XMLDemo.xmlFilePath)
        def demo = new XMLDemo()
        demo.parseXML()

        demo.createXML()

        demo.createJson()

        demo.getPerson()

        RegExpDemo.testRegexp()

        RangesDemo.testRanges()

        RangesDemo.ageCalculation()

        CollectionsDemo.testList()
        CollectionsDemo.showMoreIntrestingExampleList()
        CollectionsDemo.mapFunctionality()

        DynamicDemo dynamicDemo = new DynamicDemo()
        dynamicDemo.nonExistingCalls()
        dynamicDemo.changeBehaviour()
        dynamicDemo.addMethodToStringClass()
        dynamicDemo.showMetaClassProps()
        dynamicDemo.realExample()

        println "test".dynamicDemo("demo")

    }
}
