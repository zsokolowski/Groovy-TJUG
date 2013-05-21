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
    
    def workingFiles() {
        def file1 = new File('groovy1.txt')
        def file2 = new File('groovy2.txt')
        def file3 = new File('groovy3.txt')
        

        file1.write 'Working with files is easy.\n'
        file1 << 'See how easy it is to add text to a file.\n'
        def testString = "yeah"
        file2.text = """Maybe text has some structure?
Lets insert something: ${testString}

simplest way to create templates"""
        
        file3.withWriter('UTF-8') { writer ->
            writer.write('Napiszmy po polsku: ąęł.')
        }
    }
}
