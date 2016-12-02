package Utility;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by HoseinGhahremanzadeh on 9/18/2016.
 */
public class PrimitiveSerializer {
    private static byte[] getSubBytes (LinkedList<Byte> bytes, int from, int to) {
        byte[] subBytes=new byte[to-from];
        for (int i=from;i<to;i++)
            subBytes[i - from]=bytes.remove(from);
        return subBytes;
    }
    private static void addBytesToFirst (LinkedList<Byte> bytes, byte[] bytesToAdd) {
        for (int i=bytesToAdd.length - 1;i>-1;i--)
            bytes.addFirst(bytesToAdd[i]);
    }

    public static void serializeInt (int integer, LinkedList<Byte> bytes) {
        for (int i=0;i<4;i++) {
            bytes.addFirst((byte) (integer & 0xff));
            integer >>= 8;
        }
    }
    public static int deserializeInt (LinkedList<Byte> integer) {
        int ret = 0;
        for (int i=0;i<4;i++) {
            ret <<= 8;
            ret |= 0xff & integer.removeFirst();
        }
        return ret;
    }

    public static void serializeLong (long integer, LinkedList<Byte> bytes) {
        for (int i=0;i<4;i++) {
            bytes.addFirst((byte) (integer & 0xff));
            integer >>= 8;
        }
    }
    public static long deserializeLong (LinkedList<Byte> integer) {
        int ret = 0;
        for (int i=0;i<8;i++) {
            ret <<= 8;
            ret |= 0xff & integer.removeFirst();
        }
        return ret;
    }

    public static void serializeString(String string, LinkedList<Byte> bytes){
        if (string==null)
            string="";
        byte[] stringBytes= new byte[0];
        try {
            stringBytes = string.getBytes("UTF-16");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        addBytesToFirst(bytes, stringBytes);
        serializeInt(stringBytes.length, bytes);
    }
    public static String deserializeString(LinkedList<Byte> bytes){
        int length=deserializeInt(bytes);

        byte[] stringBytes=getSubBytes(bytes,0,length);
        try {
            return new String(stringBytes,"UTF-16");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void serializeStringArrayList(ArrayList<String> strings, LinkedList<Byte> bytes) {
        for (int i= strings.size()-1;i>-1;i--)
            serializeString(strings.get(i), bytes);
        serializeInt(strings.size(),bytes);
    }

    public static ArrayList<String> deserializeStringArrayList(LinkedList<Byte> bytes) {
        int length=deserializeInt(bytes);
        ArrayList<String> strings=new ArrayList<>(length);
        for (int i=0;i<length;i++)
            strings.add(deserializeString(bytes));
        return strings;
    }

    public static byte[] getBytes(LinkedList<Byte> bytesLS) {
        byte[] bytes = new byte[bytesLS.size()];
        for (int i=0;i<bytes.length;i++)
            bytes[i]=bytesLS.get(i);
        return bytes;
    }
    public static LinkedList<Byte> bytesToLS(byte[] bytes) {
        LinkedList<Byte> bytesLS = new LinkedList<>();
        for (int i=0;i<bytes.length;i++)
            bytesLS.add(bytes[i]);
        return bytesLS;
    }
}
