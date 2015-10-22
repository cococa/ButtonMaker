package com.cocoa.bm;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.function.DoubleConsumer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.cocoa.bm.bean.Gradient;
import com.cocoa.bm.bean.Gradient.TYPE;

public class Test {
	private static Document document;
	
	private static String[]  fileName =  {"btn_grey_pressed","btn_grey_pressed","btn_grey_normal"};
	private static String  mainFileName ="btn_grey";
	

	public static void main(String[] aStrings) throws Exception {

		// <?xml version="1.0" encoding="UTF-8"?>
		// -<shape xmlns:android="http://schemas.android.com/apk/res/android">
		// <corners android:radius="5dp"/> <gradient android:endColor="#cccccc"
		// android:startColor="#cccccc" android:centerColor="#cccccc"
		// android:centerX="35%" android:angle="45"/> <padding
		// android:bottom="6dp" android:right="8dp" android:top="6dp"
		// android:left="8dp"/> <stroke android:color="#c4c4c4"
		// android:width="0.5dp"/> </shape>

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder build = factory.newDocumentBuilder();

		document = build.newDocument();

		Element rootElement = document.createElement("shape");

		rootElement.setAttribute("xmlns:android", "http://schemas.android.com/apk/res/android");
		// android:shape="rectangle"
		rootElement.setAttribute("android:" + "shape", "rectangle");

		document.appendChild(rootElement);

		System.out.println(document.toString());

		Gradient gradient = new Gradient();

		gradient.setAngle(10);
		gradient.setType(TYPE.linear);
		gradient.setStartColor("#fff");
		gradient.setEndColor("#fff");
		gradient.setCenterColor("#fff");
		gradient.setCenterX(100);

		Element gradientElement = document.createElement("gradient");
		gradientElement.setAttribute("android:" + "angle", gradient.getAngle() + "");
		gradientElement.setAttribute("android:" + "type", gradient.getType() + "");
		gradientElement.setAttribute("android:" + "centerX", gradient.getCenterX() + "");

		gradientElement.setAttribute("android:" + "startColor", gradient.getStartColor());
		gradientElement.setAttribute("android:" + "centerColor", gradient.getCenterColor());
		gradientElement.setAttribute("android:" + "endColor", gradient.getEndColor());

		// <corners
		// android:radius="10dp"
		// />
		Element cornersElement = document.createElement("corners");
		cornersElement.setAttribute("android:" + "radius", "10dp");

		rootElement.appendChild(cornersElement);
		rootElement.appendChild(gradientElement);

		TransformerFactory tf = TransformerFactory.newInstance();

		Transformer transformer = tf.newTransformer();
		DOMSource source = new DOMSource(document);
		PrintWriter pw = new PrintWriter(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\"+fileName[0]+".xml"));
		StreamResult result = new StreamResult(pw);
		transformer.transform(source, result);
		
		
		
		createFile();

	}

	public static void createFile() throws Exception{
		// <?xml version="1.0" encoding="UTF-8"?>
		// -<selector
		// xmlns:android="http://schemas.android.com/apk/res/android"> <item
		// android:drawable="@drawable/btn_grey_pressed"
		// android:state_pressed="true"/> <item
		// android:drawable="@drawable/btn_grey_pressed"
		// android:state_focused="true"/> <item
		// android:drawable="@drawable/btn_grey_normal"/> </selector>
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder build = factory.newDocumentBuilder();

		Document  maindocument = build.newDocument();

		
		Element rootElement = maindocument.createElement("selector");
		rootElement.setAttribute("xmlns:android", "http://schemas.android.com/apk/res/android");

		for (int i = 0; i < 3; i++) {
			Element e = maindocument.createElement("item");
			e.setAttribute("android:drawable", "@drawable/"+fileName[i]);
			e.setAttribute("android:state_pressed", true+"");
			rootElement.appendChild(e);
		}
		
		maindocument.appendChild(rootElement);
		
		TransformerFactory tf = TransformerFactory.newInstance();

		Transformer transformer = tf.newTransformer();
		DOMSource source = new DOMSource(maindocument);
		PrintWriter pw = new PrintWriter(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\"+mainFileName+".xml"));
		StreamResult result = new StreamResult(pw);
		transformer.transform(source, result);
	
	}

}
