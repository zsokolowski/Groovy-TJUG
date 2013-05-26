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
        println "basics".center(80, "-")+"\n"       //add argument to spoil
        def text = "Groovy !!!"
        println text
        assert text instanceof String

        text = 1
        assert text instanceof Integer

        println "\n"+"Markup builders xml and json".center(80, "-")+"\n"
        def demo = new XMLDemo()
        demo.parseXML()
        demo.createXML()

        demo.createJson()
        demo.getPerson()

        println "\n"+"Regular expressions".center(80, "-")+"\n"
        RegExpDemo.testRegexp()

        println "\n"+"Closures".center(80, "-")+"\n"
        Clousures.toUpperCase()
        Clousures.listFile(XMLDemo.xmlFilePath)

        println "\n"+"Ranges".center(80, "-")+"\n"
        RangesDemo.testRanges();
        RangesDemo.ageCalculation()

        println "\n"+"Collections".center(80, "-")+"\n"
        CollectionsDemo.testList()
        CollectionsDemo.showMoreIntrestingExampleList()
        CollectionsDemo.mapFunctionality()

        println "\n"+"GDK".center(80, "-")+"\n"
        GDKDemo gdkDemo = new GDKDemo()
        gdkDemo.getUrlContents()
        gdkDemo.traverseFileSystem()
        gdkDemo.workingFiles()
        gdkDemo.runProcess()
        gdkDemo.transformFile(new File("resources/fileToTransform.txt"))

        println "\n"+"AST".center(80, "-")+"\n"
        println SingletonTest.instance.amSingleton

        println "\n"+"Groovy is really dynamic".center(80, "-")+"\n"
        DynamicDemo dynamicDemo = new DynamicDemo()
        dynamicDemo.nonExistingCalls()
        dynamicDemo.changeBehaviour()
        dynamicDemo.addMethodToStringClass()
        dynamicDemo.showMetaClassProps()
        dynamicDemo.realExample()

        println "test".dynamicDemo("demo")

        println "\n"+"Groovy 2.x".center(80, "-")+"\n"

        TypeCheckedDemo typeCheckedDemo = new TypeCheckedDemo()
        typeCheckedDemo.closureInAction()

    }


}
