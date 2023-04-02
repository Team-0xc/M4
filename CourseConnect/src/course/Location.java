package course;

public class Location {
    
    public Location(){
        this("", 0, False);
    }    

    public Location (String building, int roomNum, Boolean isOnline){
        this.building = building;
        this.roomNum = roomNum;
        this.isOnline = isOnline
    }

    public GetBuilding(){
        return building;
    }

    public SetBuilding(String building){
        this.building = building;
    }

    public GetRoomNum(){
        return roomNum;
    }

    public SetRoomNum(int roomNum){
        this.roomNum = roomNum;
    }

    public toString(){
        String format = "";

        if isOnline{
            format = "Online";
        }
        else{
            format = "In Person";
        }

        return "Building: " + building +
             "Room Number: " + roomNum + 
             "Format: " + format;

    }



}
