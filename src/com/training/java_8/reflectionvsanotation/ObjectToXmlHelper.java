package com.training.java_8.reflectionvsanotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

/**
 *  lớp sử dụng Reflection để đọc thông tin các Annotation
 *  được đánh dấu và chuyển sang tài liệu xml.
 */
public class ObjectToXmlHelper {
    /**
     * Chuyển đối tượng sang chuỗi xml
     */
    public static <T> String convertToXml(T obj){
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
        sb.append(convertToXml(obj));
        return sb.toString();
    }

    /**
     * Chuyển đối tượng sang chuỗi xml
     */
    static <T> String convertToXml(T obj, int numOfTab) {
        StringBuilder sb = new StringBuilder();

        // Get Class of obj
        Class<?> clazz = obj.getClass();

        // Kiểm tra xem lớp này có được chú thích XmlRootElement hay không.
        boolean isXmlDoc = clazz.isAnnotationPresent(XmlRootElement.class);

        List<Field> fields;
        String name;
        String value;
        if (isXmlDoc) {
            // Lấy ra đối tượng XmlRootElement, chú thích trên lớp này.
            XmlRootElement rootNode = clazz.getAnnotation(XmlRootElement.class);

            sb.append(getTab(numOfTab)); // Add tab
            sb.append("<" + rootNode.name()); // Root element if (isNotEmpty(rootNode.namespace())) { sb.append(" xmlns=\"" + rootNode.namespace() + "\""); } fields = getFields(clazz, XmlAttribute.class); if (!fields.isEmpty()) { for (Field field : fields) { field.setAccessible(true); XmlAttribute ann = field.getAnnotation(XmlAttribute.class); name = ann.name(); value = getValueOfField(field, obj); sb.append(" " + name + "=\"" + value + "\""); // Add attribute } } sb.append("><span data-mce-type="bookmark" style="display: inline-block; width: 0px; overflow: hidden; line-height: 0;" class="mce_SELRES_start"></span>");
            sb.append("\n"); // Add new line

            fields = getFields(clazz, null);
            if (!fields.isEmpty()) {
                // Create xml elements
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (field.isAnnotationPresent(XmlElementWrapper.class)) {
                        sb.append(createXmlWrapper(field, obj, numOfTab + 1));
                    } else if (field.isAnnotationPresent(XmlElement.class)) {
                        sb.append(createXmlElement(field, obj, numOfTab + 1));
                    }
                }
            }

            sb.append(getTab(numOfTab));
            sb.append("</" + rootNode.name() + ">"); // End root element
        }

        return sb.toString();
    }

    /**
     * tao xml wrappers
     * @param field
     * @param obj
     * @param numOfTab
     * @return
     */
    private static String createXmlWrapper(Field field, Object obj, int numOfTab) {
        StringBuilder sb = new StringBuilder();
        XmlElementWrapper ann = field.getAnnotation(XmlElementWrapper.class);
        String name = ann.name(); // Get Element's name
        sb.append(getTab(numOfTab)); // Create 1 tab
        sb.append("<" + name + ">"); // Start Element
        sb.append("\n"); // Add new line
        Collection<?> collections = getListValueOfField(field, obj);
        if (collections != null && !collections.isEmpty()) {
            // Create xml sub elements
            for (Object collection : collections) {
                sb.append(convertToXml(collection, numOfTab + 1)); // Increase tab
                sb.append("\n"); // Add new line
            }
        }
        sb.append(getTab(numOfTab)); // Create 1 tab
        sb.append("</" + name + ">"); // End Element
        sb.append("\n"); // Add new line
        return sb.toString();
    }

    /** Lấy giá trị kiểu Collection (List, ArrayList, Set, ...)
     *
     * @param field
     * @param obj
     * @return
     */
    private static Collection<?> getListValueOfField(Field field, Object obj) {
        Collection<?> collection = null;
        try {
            Object objValue = field.get(obj);
            if (objValue instanceof Collection) {
                collection = (Collection<?>) objValue;
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return collection;
    }

    private static String createXmlElement(Field field, Object obj, int numOfTab) {
        StringBuilder sb = new StringBuilder();
        XmlElement ann = field.getAnnotation(XmlElement.class);
        String name = ann.name(); // Get Element's name
        String value = getValueOfField(field, obj); // Get value of field
        sb.append(getTab(numOfTab)); // Create tab
        sb.append("<" + name + ">"); // Start Element
        sb.append(value); // Element's content
        sb.append("</" + name + ">"); // End Element
        sb.append("\n"); // Add new line
        return sb.toString();
    }


    /**
     * Lấy giá trị kiểu chuỗi
     * @param field
     * @param obj
     * @return
     */
    private static String getValueOfField(Field field, Object obj) {
        String value = "";
        try {
            value = String.valueOf(field.get(obj));
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * Lấy danh sách field có sử dụng Annotation ann
     * @param clazz
     * @param ann
     * @return
     */
    private static List<Field> getFields(Class<?> clazz, Class<? extends Annotation> ann) {
        List<Field> fieldAttributes = new ArrayList<>();

        Field[] fields = clazz.getDeclaredFields();
        if (ann == null) {
            fieldAttributes.addAll(Arrays.asList(fields));
        } else {
            for (Field field : fields) {
                if (field.isAnnotationPresent(ann)) {
                    fieldAttributes.add(field);
                }
            }
        }

        return fieldAttributes;
    }

    /**
     * Lấy số dấu tab
     * @param numOfTab
     * @return
     */
    private static String getTab(int numOfTab) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= numOfTab; i++) {
            sb.append("\t"); // Thêm dấu tab.
        }
        return sb.toString();
    }
}
