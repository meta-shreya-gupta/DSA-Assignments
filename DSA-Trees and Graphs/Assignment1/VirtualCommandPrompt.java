package Assignment1;

public class VirtualCommandPrompt {
    final String rootDirectory = "R:";
    Directory root;
    Directory current;
    public VirtualCommandPrompt(){
        root = new Directory(rootDirectory, null);
        current = root;
    }
    /**
     * extracts the current directory 
     * @return present working directory
     */
    public Directory getCurrent(){
        return current;
    }
    /**
     * creates the new directory in the current directory
     * @param name of the directory which is to be created
     */
    public void mkdir(String name){
        if(current.childs.containsKey(name)){
            System.out.println("Directory already exists");
        }
        else{
            current.childs.put(name, new Directory(name , current));
            System.out.println("Directory successfully created");
        }
    }
    /**
     * change the creent directory to the new directory
     * @param name of the directory which is to be new current directory
     */
    public void cd(String name){
        if(current.childs.containsKey(name)){
            current = current.childs.get(name);
        }
        else{
            System.out.println("there is no such directory");
        }
    }
    /**
     * change the current directory to its parent directory
     */
    public void bk(){
        if(current.parent != null){
            current = current.parent;
        }
        else{
            System.out.println("This is the root directory");
        }
    }
    /**
     * it prints all the child directories
     */
    public void ls(){
        if(current.childs.size() == 0){
            System.out.println("No subdirectories available");
        }
        for(Directory directory : current.childs.values()){
            System.out.println(directory);
        }
    }
    /**
     * checks whether the directory resembles the specified string or not
     * @param current represents present working directory
     * @param name directory which is to be searched
     * @return true if that directory resembles else false
     */
    public boolean findDirectory(Directory current , String name){
        if(current.childs.containsKey(name)){
            return true;
        }
        for(Directory directory : current.childs.values()){
            findDirectory(directory, name);
        }
        return false;
    }
    /**
     * extracts path of the directory which we are finding
     * @param directory represents present working directory
     * @return path of the directory in String format
     */
    public String findPath(Directory directory){
        StringBuilder path = new StringBuilder();
        Directory temp = directory;
        while(temp != null){
            path.insert(0, "\\" + temp.getName());
            temp = temp.parent;
        }
        return path.substring(1) + ">";
    }
    /**
     * checks whether the directory resembles the specified string or not
     * @param current represents present working directory
     * @param name directory which is to be searched
     */
    public void find(Directory current , String name){
        for(Directory directory : current.childs.values()){
            if(directory.getName().contains(name)){
                String path = findPath(directory);
                System.out.println("->" + path.replace("//", ">"));
            }
            find(directory , name);
        }
    }
    /**
     * gives the structure in the tree format from the starting root node
     * @param current it represents the present working directory
     */
    public void tree(Directory current){
        while(current.parent != null){
            current = current.parent;
        }
        printTree(current , "");
    }
    /**
     * helper method to print the tree structure starting from the root node
     * @param current represents the current working directory
     * @param spaces indentation that we have to give at start of each directory
     */
    private void printTree(Directory current, String spaces) {
        System.out.println(spaces + current.getName());
        for(Directory child : current.childs.values()){
            printTree(child, spaces + "    ");
        }
    }
    /**
     * exits the irtual command prompt
     */
    public void exit(){
        System.exit(0);
    }
}
