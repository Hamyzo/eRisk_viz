/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.sql.Timestamp;

/**
 *
 * @author JENNIFER
 */
public class getData {

    static String path;
    public getData(String path, String chunk, Connection con) throws SQLException{
        this.path = path;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(path);
            NodeList id = document.getElementsByTagName("ID");
            String uid = id.item(0).getFirstChild().getNodeValue();
            NodeList bookList = document.getElementsByTagName("WRITING");


            Statement st;

            for (int i = 0; i < bookList.getLength(); i++) {
                Node book = bookList.item(i);
                NodeList childNodes = book.getChildNodes();
                String title = childNodes.item(1).getFirstChild().getNodeValue();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                ParsePosition pos = new ParsePosition(0);
                Date date = formatter.parse(childNodes.item(3).getFirstChild().getNodeValue(), pos);
                String text = childNodes.item(7).getFirstChild().getNodeValue();


                    Timestamp timeStamp = new Timestamp(date.getTime());
                    String sql = "insert into raw"+chunk+" values(" + "'" + uid + "'" + "," + "'" + title + "'" + "," + "'" + timeStamp + "'" + "," + "'" + text + "'" + ")";
                    st = (Statement) con.createStatement();

                    st.executeUpdate(sql);


            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
        }
    }
}
