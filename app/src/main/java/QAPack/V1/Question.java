package QAPack.V1;

import Utility.PrimitiveSerializer;
import Utility.Serializer;

import java.util.LinkedList;

/**
 * Created by HoseinGhahremanzadeh on 9/18/2016.
 */
public class Question implements Serializer {
    public String question;
    public String choice1;
    public String choice2;
    public final static int version = (((1)*256+(0))*256+(0));

    public Question(String question, String choice1, String choice2) {
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public Question(LinkedList<Byte> bytes) {
        deserialize(bytes);
    }

    private void deserializeV1_0_0(LinkedList<Byte> bytes) {
        choice2=PrimitiveSerializer.deserializeString(bytes);
        choice1=PrimitiveSerializer.deserializeString(bytes);
        question=PrimitiveSerializer.deserializeString(bytes);
    }

    @Override
    public void serialize(LinkedList<Byte> bytes) {
        PrimitiveSerializer.serializeString(question, bytes);
        PrimitiveSerializer.serializeString(choice1, bytes);
        PrimitiveSerializer.serializeString(choice2, bytes);
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
