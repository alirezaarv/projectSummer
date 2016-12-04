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
    public Integer profileImageID;

    public long coins;

    public Game currentGame;
    public ArrayList<Game> gameHistory=new ArrayList<>();


    private void deserializeV1_0_0(LinkedList<Byte> bytes) {
        username = PrimitiveSerializer.deserializeString(bytes);
        email = PrimitiveSerializer.deserializeString(bytes);
        coins = PrimitiveSerializer.deserializeLong(bytes);
        profileImageID = PrimitiveSerializer.deserializeInt(bytes);
        if (PrimitiveSerializer.deserializeInt(bytes)==1)
            currentGame = new Game(bytes);
        else
            currentGame = null;

        int gameCount = PrimitiveSerializer.deserializeInt(bytes);
        gameHistory = new ArrayList<>(gameCount);
        for (int i=0;i<gameCount;i++)
            gameHistory.add(new Game(bytes));
    }

    @Override
    public void serialize(LinkedList<Byte> bytes) {
        for (int i=gameHistory.size()-1;i>-1;i++)
            gameHistory.get(i).serialize(bytes);
        PrimitiveSerializer.serializeInt(gameHistory.size(),bytes);
        if (currentGame!=null)
            currentGame.serialize(bytes);
        PrimitiveSerializer.serializeInt(currentGame!=null?1:0,bytes);
        PrimitiveSerializer.serializeInt(profileImageID, bytes);
        PrimitiveSerializer.serializeLong(coins,bytes);
        PrimitiveSerializer.serializeString(email,bytes);
        PrimitiveSerializer.serializeString(username, bytes);
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
