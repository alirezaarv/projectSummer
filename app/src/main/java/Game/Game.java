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
    public Letter letters[];

    public Game(LinkedList<Byte> bytes) {

    }

    private void deserializeV1_0_0(LinkedList<Byte> bytes) {
        if (PrimitiveSerializer.deserializeInt(bytes) == 1)
            serverStartDate = new Date(PrimitiveSerializer.deserializeLong(bytes));
        else
            serverStartDate=null;
        timeLeft = PrimitiveSerializer.deserializeLong(bytes);
        timePassed = PrimitiveSerializer.deserializeLong(bytes);
        currentWord=new Word(bytes);
        wordPack=PrimitiveSerializer.deserializeInt(bytes);
        letters = new Letter[PrimitiveSerializer.deserializeInt(bytes)];
        for (int i=letters.length-1;i>-1;i--)
            letters[i] = new Letter(bytes);
    }

    @Override
    public void serialize(LinkedList<Byte> bytes) {
        for (int i=0;i<letters.length;i++)
            letters[i].serialize(bytes);
        PrimitiveSerializer.serializeInt(letters.length,bytes);
        PrimitiveSerializer.serializeInt(wordPack, bytes);
        currentWord.serialize(bytes);
        PrimitiveSerializer.serializeLong(timePassed,bytes);
        PrimitiveSerializer.serializeLong(timeLeft,bytes);
        if (serverStartDate != null) {
            PrimitiveSerializer.serializeLong(serverStartDate.getTime(), bytes);
            PrimitiveSerializer.serializeInt(1,bytes);
        } else
            PrimitiveSerializer.serializeInt(0,bytes);

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
