public class Request {
    private static int counter=1;
    int requestId;
    User user;
    String emergencyType;
    String status;
    
    public Request(User user, String emergencyType){
        this.requestId=counter++;
        this.user=user;
        this.emergencyType=emergencyType;
        this.status="Pending";
    }

    @Override
    public String toString(){
        return "Request Id: " +requestId+
        " , Name : "+user.name+
        " , Age: "+ user.age+
        " , Location:"+user.location+
        " , Emergency : "+emergencyType+
        " , Status: " + status;
    }

}
