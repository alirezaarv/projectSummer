package Utility;

import java.util.LinkedList;

/**
 * Created by HoseinGhahremanzadeh on 9/18/2016.
 */
public interface Serializer {
    public void serialize(LinkedList<Byte> bytes);
    public void deserialize(LinkedList<Byte> bytes);
}
