package modelo;


import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LectorDeNiveles {
	
	DocumentBuilderFactory docBuilderFactory;
    DocumentBuilder docBuilder;
    Document doc;
    NodeList niveles;
	
	public LectorDeNiveles() {
		docBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = docBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			doc = docBuilder.parse (new File("niveles.xml"));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		niveles = doc.getElementsByTagName("nivel");
	}
	
	public int getCantidadDeNiveles() {
		return niveles.getLength();
	}
	
	public Nivel getNivel(int numero) {
		Nivel nivel = new Nivel(numero);
		Node nivelNode = niveles.item(numero-1);
        NodeList bloques = nivelNode.getChildNodes();
        int i;
        for (i = 0; i < bloques.getLength(); i++) {
        	Node bloqueNode = bloques.item(i);
        	NamedNodeMap atributosBloque = bloqueNode.getAttributes();
        	Node x = atributosBloque.getNamedItem("x");
        	Node y = atributosBloque.getNamedItem("y");
        	if (bloqueNode.getNodeName() == "punto") {
        		Bloque bloque = new Punto(Integer.parseInt(x.getNodeValue()), Integer.parseInt(y.getNodeValue()));
        		nivel.agregarBloque(bloque);
        	} else {
        		if (bloqueNode.getNodeName() == "pared") {
        			Bloque bloque = new Pared(Integer.parseInt(x.getNodeValue()), Integer.parseInt(y.getNodeValue()));
            		nivel.agregarBloque(bloque);
        		} else {
        			Bloque bloque = new PuntoDePoder(Integer.parseInt(x.getNodeValue()), Integer.parseInt(y.getNodeValue()));
            		nivel.agregarBloque(bloque);
        		}
        	}
        }
        return nivel;
	}
	
}
