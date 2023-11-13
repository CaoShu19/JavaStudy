package com.cs.request;

import java.io.Serializable;

/**
 * @author : Str2ke
 * @date : 2023/11/12 上午3:28
 * @Desc :
 */
public class RpcRequest implements Serializable {

    private String className;
    private String methodName;
    private Object[] parameter;
    private Class[] types;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameter() {
        return parameter;
    }

    public void setParameter(Object[] parameter) {
        this.parameter = parameter;
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }
}
