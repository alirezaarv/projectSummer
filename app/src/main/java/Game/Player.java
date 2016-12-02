package Game;

import java.util.ArrayList;
import java.util.LinkedList;

import Utility.PrimitiveSerializer;
import Utility.Serializer;

/**
 * Created by HoseinGhahremanzadeh on 11/30/2016.
 */
public class Player implements Serializer{

    public final static int version = (((1)*256+(0))*256+(0));

    public String username;
    public String email;

    public long coins;

    public Game currentGame;
    public ArrayList<Game> gameHistory=new ArrayList<>();


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
