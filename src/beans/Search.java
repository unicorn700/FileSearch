/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author goyal
 */
public class Search{
    
    
private static ArrayList<fileinfo> result=new ArrayList<fileinfo>();

    
//file searcher
    public ArrayList browse(File file,File directory)
    {

        if(file==null)
        {
            return null;
        }
        File[] files=directory.listFiles();
        if(files==null||files.length==0)
        {
            return result;
        }
        for(File ff: files)
        {
            if(ff.isDirectory())
            {
              if(((ff.getName().toLowerCase()).contains(file.getName().toLowerCase()))==true)
              {
                  result.add(Filedetails(ff));
              }
              result=browse(file, ff);
            }
            else if(((ff.getName().toLowerCase()).contains(file.getName().toLowerCase()))==true)
            {
                result.add(Filedetails(ff));
            }
        }
        return result;

    }
    
    
    public static ArrayList<fileinfo> showresult()
    {
        return result;
    }
    
    
    public void Remover()
    {
        result.clear();
    }
    

    public fileinfo Filedetails(File fl)
    {
        fileinfo flinfo = new fileinfo();
        flinfo.setFilename(fl.getName());
        flinfo.setPath(fl.getAbsolutePath());
        flinfo.setSize(sizer(fl.length()));
        flinfo.setType(getExtension(fl));
        return flinfo;
    }

    public static String getExtension(File f)
    {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) 
        {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;

    }


    public String sizer(Long size)
    {
        String retval;
        double newsize;
        newsize=(double) (size / 1024.00);
        newsize=roundTwoDecimals(newsize);
        if(newsize>1000)
        {
            newsize=(double) (newsize / 1024.00);
            newsize=roundTwoDecimals(newsize);
            retval=newsize+" MB";
        }
         else
        {
            retval=newsize+" KB";
        }
        return retval;
    }

    double roundTwoDecimals(double d) 
    {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }

}
