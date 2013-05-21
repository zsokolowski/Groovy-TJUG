package pl.data

/**
 * Created with IntelliJ IDEA.
 * User: Zbyszek Sokołowski
 * Date: 5/21/13
 * Time: 10:36 PM
 */

import static groovy.io.FileType.ANY
import static groovy.io.FileVisitResult.SKIP_SUBTREE

class GDKDemo {
    def getUrlContents(){
        def contents = new URL("http://trojmiasto.jug.pl").text
        println contents
    }

    def traverseFileSystem() {
        def totalSize = 0
        def count = 0
        def sortByTypeThenName = { a, b ->
            a.isFile() != b.isFile() ? a.isFile() <=> b.isFile() : a.name <=>
                    b.name
        }
        def inputDir = new File('/home/zbysio/IdeaProjects/GroovyDemo')
        inputDir.traverse(
                type : ANY,
                nameFilter : ~/.*\.groovy|.*\.java/,
                excludeNameFilter : ~/.*First.*/,
                preDir : { if (it.name == '.git' || it.name == '.idea') return SKIP_SUBTREE },
                postDir : {  if (count > 0)println "Found $count files in $it.name : $totalSize bytes \n"
                    totalSize = 0
                    count = 0 },
                postRoot : true,
                sort : sortByTypeThenName
        ) {it -> totalSize += it.size(); println it.name; count++ }
    }
}
