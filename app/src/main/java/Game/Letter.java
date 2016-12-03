package Game;

import java.util.LinkedList;

import Utility.PrimitiveSerializer;
import Utility.Serializer;

/**
 * Created by HoseinGhahremanzadeh on 12/2/2016.
 */
public class Letter implements Serializer {

    public final static int version = (((1) * 256 + (0)) * 256 + (0));

    public String letter;
    public boolean hinted;

    public Letter(LinkedList<Byte> bytes) {
        deserialize(bytes);
    }

    private void deserializeV1_0_0(LinkedList<Byte> bytes) {
        hinted = PrimitiveSerializer.deserializeInt(bytes) == 1;
        letter = PrimitiveSerializer.deserializeString(bytes);
    }

    @Override
    public void serialize(LinkedList<Byte> bytes) {
        PrimitiveSerializer.serializeString(letter, bytes);
        PrimitiveSerializer.serializeInt(hinted ? 1 : 0, bytes);
        PrimitiveSerializer.serializeInt(version, bytes);
    }

    @Override
    public void deserialize(LinkedList<Byte> bytes) {
        int currentVersion = PrimitiveSerializer.deserializeInt(bytes);
        switch (currentVersion) {
            case (((1) * 256 + (0)) * 256 + (0)):
                deserializeV1_0_0(bytes);
                break;
        }
    }
}
