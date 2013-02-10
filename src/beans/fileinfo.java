/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author unicorn
 */
public class fileinfo {

   private String path;
   private String Filename;
   private String size;
   private String modified;
   private String type;

    public String getFilename() {
        return Filename;
    }

    public void setFilename(String Filename) {
        this.Filename = Filename;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
