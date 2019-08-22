package com.example.dmtoolsv001;

import android.content.Context;
import android.content.res.AssetManager;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class BackgroundOperationsRandomSpell {

    SpellEntry GetSpellMethod(Context context, int UserInputLevel, String UserInputSchoolOfMagic, String UserInputCharacterClass){
        //Create SpellEntry ArrayList
        List<SpellEntry> FullSpellList = new ArrayList<>();
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------Beginning of XML Parsing
        //CreateDocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            AssetManager mngr = context.getAssets();
            InputStream istream = mngr.open("spells_listv2.xml");
            Document doc = builder.parse(istream);

            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();
            //Log.d("DMToolsv001", root.getNodeName());

            NodeList nList = doc.getElementsByTagName("spell");
            //Log.d("DMToolsv001", "==========");

            for(int temp = 0; temp < nList.getLength(); temp++){

                Node node = nList.item(temp);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) node;
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    int levelInt = Integer.parseInt(eElement.getElementsByTagName("level").item(0).getTextContent());
                    String schoolofmagic = eElement.getElementsByTagName("school").item(0).getTextContent();
                    String classesString = eElement.getElementsByTagName("classes").item(0).getTextContent();
                    String[] classesArray = classesString.split(",");
                    FullSpellList.add(new SpellEntry(levelInt, name, schoolofmagic, classesArray));
                }

            }


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------End of XML Parsing
        //This is the list of all available spells
        //FullSpellList.add(new SpellEntry(0,"Abi-Dalzim's Horrid Wilting", "Necromancy", new String[]{}));



        return RandomSpellGeneratorMethod(FullSpellList, UserInputLevel, UserInputSchoolOfMagic, UserInputCharacterClass);

    }

    private static SpellEntry RandomSpellGeneratorMethod(List<SpellEntry> spells, int UserInputLevel, String UserInputSchoolOfMagic, String UserInputCharacterClass){

        //Make an array of Spells as Big as the List
        SpellEntry[] spell_arr = new SpellEntry[spells.size()];
        int NumberOfFoundSpells = 0; // used to count how many spells we found

        //Iterate over the List and Check for the Matching criteria
        for (int i = 0; i < spells.size(); i++) {
            if ((spells.get(i).getLevel() == UserInputLevel) && ((spells.get(i).hasClass(UserInputCharacterClass) || UserInputCharacterClass.equalsIgnoreCase("any"))) && ((spells.get(i).getSchoolOfMagic().equalsIgnoreCase(UserInputSchoolOfMagic)) || UserInputSchoolOfMagic.equalsIgnoreCase("any"))) {
                spell_arr[i] = spells.get(i);
                NumberOfFoundSpells++;
            }
        }

        //No spells could be found, sad
        if (NumberOfFoundSpells == 0) {
            System.out.println("No spells could be found");
            return null;
        }


        //Put all the found spells in a new Array
        SpellEntry[] finalArr = new SpellEntry[NumberOfFoundSpells];
        NumberOfFoundSpells = 0; //Now we use it to keep track of where in the final array we are
        for (int i = 0; i < spell_arr.length; i++) {
            if (spell_arr[i] != null) {
                finalArr[NumberOfFoundSpells] = spell_arr[i];
                NumberOfFoundSpells++;
            }
        }


        Random random = new Random();
        //Returns an random Spell Object
        return finalArr[random.nextInt(NumberOfFoundSpells)];




    }
}
