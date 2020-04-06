package website.lhc.lspace.commo.util;

import java.io.*;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.commo.util
 * @ClassName: SerializationUtils
 * @Author: lhc
 * @Description: TODO
 * @Date: 2020/4/4 下午 07:46
 */
public class SerializationUtils {

    /**
     * 序列化对象
     *
     * @param obj 对象
     * @return 序列化后的字节数组
     * @throws IOException
     */
    public static byte[] serialize(Object obj) throws IOException {
        if (null == obj) {
            return null;
        }

        try (
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);
        ) {

            out.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        }

    }

    /**
     * 反序列化
     *
     * @param bytes 对象序列化后的字节数组
     * @return 反序列化后的对象
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        if (null == bytes) {
            return null;
        }

        try (
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                ObjectInputStream in = new ObjectInputStream(byteArrayInputStream);
        ) {

            return in.readObject();
        }
    }
}
