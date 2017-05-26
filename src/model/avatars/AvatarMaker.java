package model.avatars;

/**
 * Created by johnny on 27/5/17.
 */
public abstract class AvatarMaker implements Avatars {

    protected String name;
    protected String type;

    public String getType(){

         return type;
    }

    public String getName(){

        return name;
    }

}
