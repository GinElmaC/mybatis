package com.GinElmaC.bank.Util;

import org.apache.ibatis.javassist.*;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 工具类，可以动态生成Dao的代理类(MyBatis底层原理)
 * 修改：GinElmaC
 * @version 1.0
 */
public class GenerateDaoProxy {
    private GenerateDaoProxy(){};

    /**
     * 生成Dao接口实现类，并返回该接口的实现类
     * @param daoInterface 传入的Dao接口
     * @return 返回的实例化对象
     */
    public static Object generate(SqlSession sqlSession,Class daoInterface){
        //类池，MyBatis内置了javassist，对其进行了二次包装
        ClassPool cp =ClassPool.getDefault();
        //制造出类  classPool.makeClass("要制造的类名")
        CtClass ctclass = cp.makeClass(daoInterface.getName()+"Proxy");//本质上就是在内存中动态生成一个代理类
        //制造出接口  classPool.makeInterface("要制造的接口类名")
        CtClass ctInterface = cp.makeInterface(daoInterface.getName());
        //实现接口
        ctclass.addInterface(ctInterface);
        //实现接口所有方法
        CtMethod[] declaredMethods = ctInterface.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(methon->{
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("public ");
                sb.append(methon.getReturnType().getName());
                sb.append(" ");
                sb.append(methon.getName());
                sb.append("(");
                //方法参数
                CtClass[] parameterTypes = methon.getParameterTypes();
                for(int i = 0;i<parameterTypes.length;i++){
                    CtClass parameterType = parameterTypes[i];
                    sb.append(parameterType.getName());
                    sb.append(" ");
                    sb.append("arg"+i);
                    if(i != parameterTypes.length-1){
                        sb.append(",");
                    }
                }
                sb.append(")");
                sb.append("{");
                //拼方法体(要用全限定报名，要不然不知道需要哪个SqlSession)
                sb.append("org.apache.ibatis.session.SqlSession sqlSession = com.GinElmaC.bank.Util.SqlSessionUtil.openSession();");
                sb.append("sqlSession.");
                String sqlId = daoInterface.getName()+"."+methon.getName();
                SqlCommandType sqlCommandType = sqlSession.getConfiguration().getMappedStatement(sqlId).getSqlCommandType();
                if(sqlCommandType == SqlCommandType.INSERT){

                }
                if(sqlCommandType == SqlCommandType.UPDATE){
                    sb.append("return sqlSession.update(\""+sqlId+"\"),arg0);");
                }
                if(sqlCommandType == SqlCommandType.SELECT){
                    String returnType = methon.getReturnType().getName();
                    sb.append("return ("+returnType+")sqlSession.selectOne(\""+sqlId+"\"),arg0);");
                }
                sb.append("}");
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }

        });
        //...
        //创建对象
        Object obj = null;
        try {
            Class<?> aClass = ctclass.toClass();
            obj = aClass.newInstance();
        } catch (CannotCompileException e) {
            throw new RuntimeException(e);
        }finally {
            return obj;
        }
    }
}
