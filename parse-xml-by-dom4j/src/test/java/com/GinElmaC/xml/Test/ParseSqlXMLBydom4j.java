package com.GinElmaC.xml.Test;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 测试读取MyBatis中SQL语句的配置文件
 * 修改：GinElmaC
 */
public class ParseSqlXMLBydom4j {
    @Test
    public void testParseSqlMapperXML() throws Exception{
        SAXReader reader = new SAXReader();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("CarMapper.xml");
        Document document = reader.read(is);
        //获取namespace
        String xpath = "/mapper";
        Element mapper = (Element) document.selectSingleNode(xpath);
        String namespqce = mapper.attributeValue("namespace");
        //获取mapper节点下所有的子节点
        List<Element> elements = mapper.elements();
        //遍历
        elements.forEach(element -> {
            //获取sqlId
            String id=  element.attributeValue("id");
            //获取resultType,没有的话会返回null
            String resultType = element.attributeValue("resultType");
            //获取标签中的sql语句
            //获取文本中的文本内容并且去除前后空白
            String sql = element.getTextTrim();
            //将sql语句中的#{}替换为？，因为以后再MyBatis中封装JDBC要进行带有？的sql语句
            sql.replaceAll("#\\{[0-9A-Za-z_$]*}","?");
            System.out.println(id+" "+resultType+""+sql);
        });
    }
}
