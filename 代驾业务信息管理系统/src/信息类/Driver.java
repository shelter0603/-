package 信息类;
public class Driver {
    private String name=null,phone=null,on=null;
    public void setphone(String phone){
        this.phone=phone;
    }
    public String getphone() {
        return phone;
    }
    public void setname(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void seton(String on){
        this.on=on;
        
    }
    public String geton(){
        return on;
    }
    public Driver(){

    }
    Driver(String phone,String name,String on){
        this.phone=phone;
        this.name=name;
        this.on=on;
        //On=String.valueOf(on);
        // on=Boolean.valueOf(On);
        //Phone=String.valueOf(phone);
        // phone=Integer.parseInt(Phone);

    }
}
