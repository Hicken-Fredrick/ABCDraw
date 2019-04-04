package com.group.abcdraw.ui.background;

import com.group.abcdraw.model.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PositionsRepository {
    private static final PositionsRepository ourInstance = new PositionsRepository();

    public static PositionsRepository getInstance() {
        return ourInstance;
    }

    private PositionsRepository() {
    }

    public List<Position> getByLetter(char letter){
        List<Position> positionList = new ArrayList<Position>();
        switch (letter) {
            case 'a':
                positionList.add(new Position(422,1216));
                positionList.add(new Position(588,1236));
                positionList.add(new Position(753,1219));
                positionList.add(new Position(898,1208));
                positionList.add(new Position(980,1124));
                positionList.add(new Position(1001,978));
                positionList.add(new Position(854,980));
                positionList.add(new Position(626,988));
                positionList.add(new Position(477,920));
                positionList.add(new Position(341,827));
                positionList.add(new Position(416,687));
                positionList.add(new Position(533,648));
                positionList.add(new Position(698,639));
                break;
        }
        return positionList;
    }
}
