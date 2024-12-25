package com.GinElmaC.xml.Test;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.ElementModifier;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 测试读取MyBatis核心配置文件文件的方法
 * 修改：GinElmaC
 */
public class ParseXMLBydom4j {
    @Test
    /**
     * 修改：GinElmaC
     */
    public void testParseMyBatisConfigXML() throws Exception {
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //用输入流读xml文件，返回document对象，是文档对象，代表了整个xml文件
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("MyBatis-config.xml");
        Document document = reader.read(is);
//        //获取文档中的根标签
//        Element rootElement = document.getRootElement();
//        String rootElementName = rootElement.getName();
//        System.out.println(rootElementName);//获取到了configration标签
        //获取default默认的环境id
        //下面语句表示从"/"代表的根目录下configuration标签向下照environments标签
        String xpath = "/configuration/environments";//xpath是做标签路径匹配的，可以让我们快速定位XML文件中的元素
        //拿到environment节点
        //本来应该返回的是Node对象，但Element是Node的子类，方法更多，使用更便捷，所以进行强转
        Element environments = (Element)document.selectSingleNode(xpath);
        //获取环境默认属性的值,就是默认名字
        String defaultEnvironment = environments.attributeValue("default");
        //获取具体的环境environemnt
        xpath = "/configuration/environments/environment[@id='"+defaultEnvironment+"']";
        Element environment = (Element) document.selectSingleNode(xpath);
        //获取environment节点下的transactionManager节点，配置事务管理器
        Element transactionManager = environment.element("transactionManager");
        //获取事务管理器的名字
        String transactionType = transactionManager.attributeValue("type");
        //获取DataSource节点
        Element DataSource = environment.element("dataSource");
        //获取DataSource节点的类型值
        String DataSourceType = DataSource.attributeValue("type");
        //获取datasource节点下的所有子节点,子节点以Map的键值对存在
        List<Element> list = DataSource.elements();
        //遍历
        list.forEach(datesource -> {
            String name = datesource.attributeValue("name");
            String value = datesource.attributeValue("value");
        });
        //获取所有的Mapper
        xpath = "//mapper";
        List<Node> mappers = document.selectNodes(xpath);
        //遍历
        mappers.forEach(mapper->{
            Element mapperElt = (Element) mapper;
            String mapperType = mapperElt.attributeValue("resource");
            System.out.println(mapperType);
        });
    }
}
