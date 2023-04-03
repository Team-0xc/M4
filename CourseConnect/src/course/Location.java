package course;

public class Location {

    private String building;
    private Integer roomNum;
    private Boolean isOnline;
    
    public Location(){
        this("", 0, false);
    }    

    public Location (String building, int roomNum, Boolean isOnline){
        this.building = building;
        this.roomNum = roomNum;
        this.isOnline = isOnline;
    }

    public String GetBuilding(){
        return building;
    }

    public void SetBuilding(String building){
        this.building = building;
    }

    public Integer GetRoomNum(){
        return roomNum;
    }

    public void SetRoomNum(int roomNum){
        this.roomNum = roomNum;
    }

    public String toString(){
        String format = "";

        if(isOnline) {
            format = "Online";
        }
        else {
            format = "In Person";
        }

        return "Building: " + building +
             "Room Number: " + roomNum + 
             "Format: " + format;

    }



}
