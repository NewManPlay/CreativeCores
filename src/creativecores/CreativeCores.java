package creativecores;

import arc.*;
import arc.util.*;
import creativecores.content.CCBlocks;
import creativecores.content.CCTechTree;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class CreativeCores extends Mod{

    public CreativeCores(){}

    @Override
    public void loadContent(){
        new CCBlocks().load();
        new CCTechTree().load();
    }

}
