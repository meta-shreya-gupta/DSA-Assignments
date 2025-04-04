package Assignment1;

public class VirtualCommandPrompt {
    final String rootDirectory = "R:";
    Directory root;
    Directory current;
    public VirtualCommandPrompt(){
        root = new Directory(rootDirectory, null);
        current = root;
    }
    public Directory getCurrent(){
        return current;
    }
    public void mkdir(String name){
        if(current.childs.containsKey(name)){
            System.out.println("Directory already exists");
        }
        else{
            current.childs.put(name, new Directory(name , current));
            System.out.println("Directory successfully created");
        }
    }
    public void cd(String name){
        if(current.childs.containsKey(name)){
            current = current.childs.get(name);
        }
        else{
            System.out.println("there is no such directory");
        }
    }
    public void bk(){
        if(current.parent != null){
            current = current.parent;
        }
        else{
            System.out.println("This is the root directory");
        }
    }
    public void ls(){
        if(current.childs.size() == 0){
            System.out.println("No subdirectories available");
        }
        for(Directory directory : current.childs.values()){
            System.out.println(directory);
        }
    }
    public boolean findDirectory(Directory current , String name){
        if(current.childs.containsKey(name)){
            return true;
        }
        for(Directory directory : current.childs.values()){
            findDirectory(directory, name);
        }
        return false;
    }
    public String findPath(Directory directory){
        StringBuilder path = new StringBuilder();
        Directory temp = directory;
        while(temp != null){
            path.insert(0, "\\" + temp.getName());
            temp = temp.parent;
        }
        return path.substring(1) + ">";
    }
    public void find(Directory current , String name){
        for(Directory directory : current.childs.values()){
            if(directory.getName().equals(name)){
                String path = findPath(directory);
                System.out.println(path);
            }
            find(directory , name);
        }
    }
    public void exit(){
        System.exit(0);
    }
}
