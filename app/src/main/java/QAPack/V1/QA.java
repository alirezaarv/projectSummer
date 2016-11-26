package QAPack.V1;

import Utility.PrimitiveSerializer;
import Utility.Serializer;

import java.util.LinkedList;

/**
 * Created by HoseinGhahremanzadeh on 9/18/2016.
 */
public class QA implements Serializer {
    public int q;
    public int a;
    public final static int version = (((1)*256+(0))*256+(0));

    public QA(int q, int a) {
        this.q = q;
        this.a = a;
    }

    public QA(LinkedList<Byte> data) {
        deserialize(data);
    }

    private void deserializeV1_0_0(LinkedList<Byte> bytes) {
        a = PrimitiveSerializer.deserializeInt(bytes);
        q = PrimitiveSerializer.deserializeInt(bytes);
    }

    @Override
    public void serialize(LinkedList<Byte> bytes) {
        PrimitiveSerializer.serializeInt(q, bytes);
        PrimitiveSerializer.serializeInt(a, bytes);
        PrimitiveSerializer.serializeInt(version, bytes);
    }

    @Override
    public void deserialize(LinkedList<Byte> bytes) {
        int currentVersion = PrimitiveSerializer.deserializeInt(bytes);
        switch (currentVersion) {
            case (((1)*256+(0))*256+(0)):
                deserializeV1_0_0(bytes);
                break;
        }
    }
}
