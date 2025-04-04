package Assignment1;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Directory {
    String name;
    LocalDateTime creationDateTime;
    Map<String , Directory> childs;
    Directory parent ;
    public Directory(String name , Directory parent){
        this.name = name;
        this.creationDateTime = LocalDateTime.now();
        this.childs = new HashMap<>();
        this.parent = parent;
    }
    public Directory getParent(){
        return parent;
    }
    public LocalDateTime getDateTime(){
        return creationDateTime;
    }
    public String getName(){
        return name;
    }
    public Map<String , Directory> getChilds(){
        return childs;
    }
    @Override
    public String toString(){
        return name + "->" + creationDateTime;
    }
}
