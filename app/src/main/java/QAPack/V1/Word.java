package QAPack.V1;

import Utility.PrimitiveSerializer;
import Utility.Serializer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by HoseinGhahremanzadeh on 9/18/2016.
 */
public class Word implements Serializer {
    public String word;
    public ArrayList<QA> questions = new ArrayList<QA>();
    public String wordHint  = "";
    public String wordExplanation = "";
    public final static int version = (((1)*256+(0))*256+(1));

    public Word(String word, String wordHint, String wordExplanation) {
        this.word = word;
        this.wordHint = wordHint;
        this.wordExplanation = wordExplanation;
    }
    public Word(LinkedList<Byte> bytes) {
        deserialize(bytes);
    }

    private void deserializeV1_0_0(LinkedList<Byte> bytes) {
        word = PrimitiveSerializer.deserializeString(bytes);
        int size=PrimitiveSerializer.deserializeInt(bytes);
        questions=new ArrayList<QA>(size);
        for (int i=0;i<size;i++) {
            questions.add(new QA(bytes));
        }
    }

    private void deserializeV1_0_1(LinkedList<Byte> bytes) {
        wordExplanation = PrimitiveSerializer.deserializeString(bytes);
        wordHint=PrimitiveSerializer.deserializeString(bytes);
        word = PrimitiveSerializer.deserializeString(bytes);
        int size=PrimitiveSerializer.deserializeInt(bytes);
        questions=new ArrayList<QA>(size);
        for (int i=0;i<size;i++) {
            questions.add(new QA(bytes));
        }
    }

    @Override
    public void deserialize(LinkedList<Byte> bytes) {
        int currentVersion = PrimitiveSerializer.deserializeInt(bytes);
        switch (currentVersion) {
            case (((1)*256+(0))*256+(0)):
                deserializeV1_0_0(bytes);
                break;
            case (((1)*256+(0))*256+(1)):
                deserializeV1_0_1(bytes);
                break;
        }
    }

    @Override
    public void serialize(LinkedList<Byte> bytes) {
        for (int i=questions.size()-1;i>-1;i--) {
            questions.get(i).serialize(bytes);
        }
        PrimitiveSerializer.serializeInt(questions.size(),bytes);
        PrimitiveSerializer.serializeString(word, bytes);
        PrimitiveSerializer.serializeString(wordHint, bytes);
        PrimitiveSerializer.serializeString(wordExplanation, bytes);
        PrimitiveSerializer.serializeInt(version, bytes);
    }
}
