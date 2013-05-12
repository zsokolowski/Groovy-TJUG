package pl.data

/**
 * Created with IntelliJ IDEA.
 * User: Zbyszek Sokołowski
 * Date: 5/11/13
 * Time: 8:26 PM
 * To change this template use File | Settings | File Templates.
 */
class MyExtension {
    static String dynamicDemo(String self, String name) {
        "Hi ${name}, I'm ${self}"
    }
}
