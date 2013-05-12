package pl.data

/**
 * Created with IntelliJ IDEA.
 * User: Zbyszek Sokołowski
 * Date: 5/9/13
 * Time: 9:07 PM
 * To change this template use File | Settings | File Templates.
 */
class DynamicDemo {

    Closure whatToDo = { name -> println "accessed $name"}

    def methodMissing(String name, Object args) {
        whatToDo(name)
    }

    def addMethodToStringClass() {
        String upperCaseStr = "UPPER"
        String.metaClass.low = {-> delegate.toLowerCase() }
        println upperCaseStr.low()
    }


    public nonExistingCalls() {
        String test = "test"
       // test.nonExistingMethod()
    }

    void changeBehaviour()
    {
        test1()
        whatToDo = { name -> println "$name has size ${name.size()}" }
        test2()
    }

    def showMetaClassProps() {
        MetaClass mc = String.metaClass
        final Object[] NO_ARGS = []
        assert 1 == mc.respondsTo("toString", NO_ARGS).size()
        assert 3 == mc.properties.size()
        assert 75 == mc.methods.size()
        assert 251 == mc.metaMethods.size()   //one is mine! so 250
        assert "" == mc.invokeMethod("","toString", NO_ARGS)
        assert null == mc.invokeStaticMethod(String, "println", NO_ARGS)
        assert "" == mc.invokeConstructor(NO_ARGS)
    }

    def realExample() {
        Number.metaClass {
            getMm = { delegate }
            getCm = { delegate * 10.mm }
            getM  = { delegate * 100.cm }
        }
        assert 1.m + 20.cm - 8.mm == 1.192.m
        println "1.m + 20.cm - 8.mm = ${1.m + 20.cm - 8.mm } mm"

    }


}
