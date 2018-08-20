package com.byebye.kzj.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 1.0 刘风栓
 */
public class ReflectUtils {
    private static final Map<String, Class> typeMap = new HashMap() {
        {
            this.put("int", Integer.class);
            this.put("long", Long.class);
            this.put("double", Double.class);
            this.put("float", Float.class);
            this.put("boolean", Boolean.class);
            this.put("char", Character.class);
            this.put("byte", Byte.class);
            this.put("short", Short.class);
        }
    };

    public ReflectUtils() {
    }

    public static Object invokeGetterMethod(Object obj, String propertyName) {
        String getterMethodName = "get" + capitalize(propertyName);
        return invokeMethod(obj, getterMethodName, new Class[0], new Object[0]);
    }

    public static void invokeSetterMethod(Object obj, String propertyName, Object value) {
        invokeSetterMethod(obj, propertyName, value, (Class)null);
    }

    public static void invokeSetterMethod(Object obj, String propertyName, Object value, Class<?> propertyType) {
        Class type = propertyType != null ? propertyType : value.getClass();
        String setterMethodName = "set" + capitalize(propertyName);
        invokeMethod(obj, setterMethodName, new Class[]{type}, new Object[]{value});
    }

    public static Object getFieldValue(Object obj, String fieldName) {
        Field field = getAccessibleField(obj, fieldName);
        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
        } else {
            Object result = null;

            try {
                result = field.get(obj);
            } catch (IllegalAccessException var5) {
                var5.printStackTrace();
            }

            return result;
        }
    }

    public static void setFieldValue(Object obj, String fieldName, Object value) {
        Field field = getAccessibleField(obj, fieldName);
        if (field != null) {
            if (!field.getType().isAssignableFrom(value.getClass())) {
                value = getSimpleObjectValue(value, field.getType());
            }

            if (null != value) {
                try {
                    field.set(obj, value);
                } catch (IllegalAccessException var5) {
                    var5.printStackTrace();
                }
            }
        }

    }

    public static Field getAccessibleField(Object obj, String fieldName) {
        if (obj == null) {
            throw new IllegalArgumentException("object not null");
        } else if (fieldName != null && !"".equals(fieldName.trim())) {
            HashSet names = new HashSet();

            for(Class superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
                try {
                    Field[] e = superClass.getDeclaredFields();
                    int len$ = e.length;

                    for(int i$ = 0; i$ < len$; ++i$) {
                        Field df = e[i$];
                        names.add(df.getName());
                    }

                    if (names.contains(fieldName)) {
                        Field var9 = superClass.getDeclaredField(fieldName);
                        var9.setAccessible(true);
                        return var9;
                    }
                } catch (NoSuchFieldException var8) {
                    throw new RuntimeException(var8);
                }
            }

            return null;
        } else {
            throw new IllegalArgumentException("fieldName not null");
        }
    }

    public static Object getSimpleObjectValue(Object oldValue, Class targeType) {
        try {
            return Class.forName(((Class)typeMap.get(targeType.getSimpleName())).getName()).getConstructor(String.class).newInstance(oldValue.toString());
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static Set<Field> getAccessibleField(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("object not null");
        } else {
            HashSet names = new HashSet();

            for(Class superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
                Field[] arr$ = superClass.getDeclaredFields();
                int len$ = arr$.length;

                for(int i$ = 0; i$ < len$; ++i$) {
                    Field df = arr$[i$];
                    names.add(df);
                }
            }

            return names;
        }
    }

    public static Object invokeMethod(Object obj, String methodName, Class<?>[] parameterTypes, Object[] args) {
        Method method = getAccessibleMethod(obj, methodName, parameterTypes);
        if (method == null) {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + obj + "]");
        } else {
            try {
                return method.invoke(obj, args);
            } catch (Exception var6) {
                throw convertReflectionExceptionToUnchecked(var6);
            }
        }
    }

    public static Method getAccessibleMethod(Object obj, String methodName, Class... parameterTypes) {
        if (obj == null) {
            throw new IllegalArgumentException("object not null");
        } else {
            Class superClass = obj.getClass();
            if (superClass != Object.class) {
                try {
                    Method e = superClass.getDeclaredMethod(methodName, parameterTypes);
                    e.setAccessible(true);
                    return e;
                } catch (NoSuchMethodException var5) {
                    throw new RuntimeException(var5);
                }
            } else {
                return null;
            }
        }
    }

    public static <T> Class<T> getSuperClassGenricType(Class clazz) {
        return getSuperClassGenricType(clazz, 0);
    }

    public static Class getSuperClassGenricType(Class clazz, int index) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        } else {
            Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
            if (index < params.length && index >= 0) {
                return !(params[index] instanceof Class) ? Object.class : (Class)params[index];
            } else {
                return Object.class;
            }
        }
    }

    public static RuntimeException convertReflectionExceptionToUnchecked(Exception e) {
        return (RuntimeException)(!(e instanceof IllegalAccessException) && !(e instanceof IllegalArgumentException) && !(e instanceof NoSuchMethodException) ? (e instanceof InvocationTargetException ? new RuntimeException("Reflection Exception.", ((InvocationTargetException)e).getTargetException()) : (e instanceof RuntimeException ? (RuntimeException)e : new RuntimeException("Unexpected Checked Exception.", e))) : new IllegalArgumentException("Reflection Exception.", e));
    }

    public static String getErrorMsg(Throwable error) {
        PrintWriter out = null;

        String var3;
        try {
            StringWriter e = new StringWriter();
            out = new PrintWriter(e);
            error.printStackTrace(out);
            var3 = "\r\n" + e.toString() + "\r\n";
            String var4 = var3;
            return var4;
        } catch (Exception var8) {
            var3 = "bad getErrorMap";
        } finally {
            if (null != out) {
                out.close();
            }

        }

        return var3;
    }

    public static String capitalize(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            char firstChar = str.charAt(0);
            return Character.isTitleCase(firstChar) ? str : (new StringBuilder(strLen)).append(Character.toTitleCase(firstChar)).append(str.substring(1)).toString();
        } else {
            return str;
        }
    }
}
