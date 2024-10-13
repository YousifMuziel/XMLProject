import java.util.ArrayList;
import java.util.List;

public class XMLDocument {
    private XMLElement root;

    public XMLDocument(XMLElement root) {
        this.root = root;
    }

    // Method to print the XML document
    public void printXML() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return root.toString();
    }
}

