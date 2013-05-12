package pl.data.xmlExample
/**
 * Created with IntelliJ IDEA.
 * User: Zbyszek Sokołowski
 * Date: 5/2/13
 * Time: 9:35 PM
 * To change this template use File | Settings | File Templates.
 */
class XMLDemo {

    public static final xmlFilePath = "src/pl/data/xmlExample/langs.xml"

    static String PERSON =
        """
        <person id='2'>
            <name>Zosia</name>
            <age>1</age>
        </person>
        """

    public void parseXML() {

        def programming = new XmlSlurper().parse(new File(xmlFilePath))
        for (lang in programming.children()) {
            for (concreteLang in lang.children()) {
                println "${lang['@platform']} platform: ${concreteLang} is ${concreteLang['@type']} type language"
            }
        }
    }

    public void createXML(){
        def writer = new StringWriter()
        def xml = new groovy.xml.MarkupBuilder(writer)
        xml.person(id:2) {
            name 'Zosia'
            age 1
        }
        println writer.toString()
    }

    void createJson() {
        def json = new groovy.json.JsonBuilder()
        json.people {
            person {
            name 'Zosia'
            age '1'
            }
        }
        println json.toPrettyString()
    }

    void getPerson() {
        def xmlPerson = new XmlParser().
                parseText(PERSON)
        Person person = new Person(id: xmlPerson.@id,
                name: xmlPerson.name.text(),
                age: xmlPerson.age.text())
        println "${person.id}, ${person.name}, ${person.age}"
    }
}
