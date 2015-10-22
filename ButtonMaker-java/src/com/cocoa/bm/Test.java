package com.cocoa.bm;

import java.io.FileOutputStream;
import java.io.PrintWriter;

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

		Document document = build.newDocument();

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
		// transformer.setOutputProperty(OutputKeys.ENCODING, "gb2312");
		// transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		PrintWriter pw = new PrintWriter(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test.xml"));
		StreamResult result = new StreamResult(pw);
		transformer.transform(source, result);
		System.out.println("生成XML文件成功!");

	}

}
