public class Main {
    public static void main(String[] args) {
        // Create course element
        XMLElement course = new XMLElement("course");

        // Create code element
        XMLElement code = new XMLElement("code", "SYSC3110");
        course.addChild(code);

        // Create prof element
        XMLElement prof = new XMLElement("prof", "Wafa");
        course.addChild(prof);

        // Create class element
        XMLElement classElement = new XMLElement("class");

        // Create student elements with attributes
        XMLElement student1 = new XMLElement("student", "Michael");
        student1.addAttribute(new Attribute("id", "123456"));
        student1.addAttribute(new Attribute("year", "3"));

        XMLElement student2 = new XMLElement("student", "Alan");
        student2.addAttribute(new Attribute("id", "654321"));
        student2.addAttribute(new Attribute("year", "2"));

        classElement.addChild(student1);
        classElement.addChild(student2);

        // Add class to course
        course.addChild(classElement);

        // Instantiate XML document
        XMLDocument xmlDoc = new XMLDocument(course);

        // Print out the XML document with attributes
        xmlDoc.printXML();  // This will print the XML document with attributes
    }
}
