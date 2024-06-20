package 信息类;
public class Users {
    private String name=null,phone=null,on=null,dz=null;
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
    public Users(){

    }
    public void setdz(String dz){
        this.dz=dz;
    }
    public String getdz(){
        return dz;
    }
    Users(String phone,String name,String on){
        this.phone=phone;
        this.name=name;
        this.on=on;
        //On=String.valueOf(on);
        // on=Boolean.valueOf(On);
        //Phone=String.valueOf(phone);
        // phone=Integer.parseInt(Phone);

    }
}
