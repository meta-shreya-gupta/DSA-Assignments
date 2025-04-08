package Assignment1;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Directory {
    String name;
    LocalDateTime creationDateTime;
    Map<String, Directory> childs;
    Directory parent;

    public Directory(String name, Directory parent) {
        this.name = name;
        this.creationDateTime = LocalDateTime.now();
        this.childs = new HashMap<>();
        this.parent = parent;
    }
    /**
     * returns the parent directory of the current directory if it exists else null
     * @return parent directory of the current directory
     */
    public Directory getParent() {
        return parent;
    }
    /**
     * extracts the creation date and time of the creation of the directory
     * @return date and time of the creation of the directory
     */
    public LocalDateTime getDateTime() {
        return creationDateTime;
    }
    /**
     * extracts name of the directory
     * @return name of the directory
     */
    public String getName() {
        return name;
    }
    /**
     * extracts the children of the current directory
     * @return map of child directory name and the child directory
     */
    public Map<String, Directory> getChilds() {
        return childs;
    }

    @Override
    public String toString() {
        return name + "->" + creationDateTime;
    }
}
