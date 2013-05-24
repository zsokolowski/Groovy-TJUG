package pl.data

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked

/**
 * Created with IntelliJ IDEA.
 * User: Zbyszek Sokołowski
 * Date: 5/24/13
 * Time: 10:43 PM
 */

//@TypeChecked
//@CompileStatic
class TypeCheckedDemo {

    def test() {
       int printing = new Date()
       println printing
  }

    def closureInAction() {
       Map<Integer, String> listToDo = [1:"compile"]
       listToDo.each { a,  b -> println a + b}
    }

}
