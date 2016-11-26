package QAPack.V1;

import Utility.PrimitiveSerializer;
import Utility.Serializer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by HoseinGhahremanzadeh on 9/19/2016.
 */
public class Pack implements Serializer{
    public final static int version = (((1)*256+(0))*256+(0));
    public ArrayList<Word> words = new ArrayList<Word>();
    public ArrayList<Question> questions = new ArrayList<Question>();

    private void deserializeV1_0_0(LinkedList<Byte> bytes) {
        int tempSize=PrimitiveSerializer.deserializeInt(bytes);
        questions=new ArrayList<Question>(tempSize);
        for (int i=0;i<tempSize;i++) {
            questions.add(new Question(bytes));
        }
        tempSize=PrimitiveSerializer.deserializeInt(bytes);
        words=new ArrayList<Word>(tempSize);
        for (int i=0;i<tempSize;i++) {
            words.add(new Word(bytes));
        }
    }

    @Override
    public void serialize(LinkedList<Byte> bytes) {
        for (int i=words.size()-1;i>-1;i--)
            words.get(i).serialize(bytes);
        PrimitiveSerializer.serializeInt(words.size(), bytes);

        for (int i=questions.size()-1;i>-1;i--)
            questions.get(i).serialize(bytes);
        PrimitiveSerializer.serializeInt(questions.size(), bytes);
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
