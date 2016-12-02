package Game;

import java.util.Date;
import java.util.LinkedList;
import QAPack.V1.Word;
import Utility.PrimitiveSerializer;
import Utility.Serializer;

/**
 * Created by HoseinGhahremanzadeh on 11/30/2016.
 */

public class Game implements Serializer {

    public final static int version = (((1)*256+(0))*256+(0));

    public Date serverStartDate;
    public long timeLeft;
    public long timePassed;

    public Word currentWord;
    public int wordPack;

    private void deserializeV1_0_0(LinkedList<Byte> bytes) {
    }

    @Override
    public void serialize(LinkedList<Byte> bytes) {
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
