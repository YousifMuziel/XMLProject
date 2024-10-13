import java.util.List;
import java.util.ArrayList;

public class XMLElement {
    private String tagName;
    private List<Attribute> attributes;
    private String textContent;
    private List<XMLElement> children;

    // Constructor for element with text content
    public XMLElement(String tagName, String textContent) {
        this.tagName = tagName;
        this.textContent = textContent;
        this.attributes = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    // Constructor for element with child elements
    public XMLElement(String tagName) {
        this.tagName = tagName;
        this.attributes = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addChild(XMLElement child) {
        this.children.add(child);
    }

    public void addAttribute(Attribute attribute) {
        this.attributes.add(attribute);
    }

    public String getTagName() {
        return tagName;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public List<XMLElement> getChildren() {
        return children;
    }

    public String getTextContent() {
        return textContent;
    }

    // Helper method for formatted output with indentation
    private String toStringIndented(int indentLevel) {
        StringBuilder xml = new StringBuilder();
        String indent = "    ".repeat(indentLevel); // 4 spaces for each level of indentation

        xml.append(indent).append("<").append(tagName);

        // Add attributes
        for (Attribute attr : attributes) {
            xml.append(" ").append(attr.getName()).append("=\"").append(attr.getValue()).append("\"");
        }

        if (textContent != null && !textContent.isEmpty()) {
            xml.append(">").append(textContent).append("</").append(tagName).append(">\n");
        } else if (!children.isEmpty()) {
            xml.append(">\n");
            for (XMLElement child : children) {
                xml.append(child.toStringIndented(indentLevel + 1));
            }
            xml.append(indent).append("</").append(tagName).append(">\n");
        } else {
            xml.append("/>\n");
        }

        return xml.toString();
    }

    @Override
    public String toString() {
        return toStringIndented(0);
    }
}
