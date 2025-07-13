package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import org.springframework.stereotype.Service;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    public Country getCountry(String code) {
        List<Country> countries = loadCountries();
        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    private List<Country> loadCountries() {
        List<Country> countries = new ArrayList<>();
        try {
            File xmlFile = new File("src/main/resources/country.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("country");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    String code = elem.getElementsByTagName("code").item(0).getTextContent();
                    String name = elem.getElementsByTagName("name").item(0).getTextContent();
                    countries.add(new Country(code, name));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }
}
