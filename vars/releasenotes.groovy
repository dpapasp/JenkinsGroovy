import java.io.*;
import groovy.io.*;


@NonCPS
def call(Map config=[:]){

    def dir = new File(pwd());

    new File(dir.path + '/releasenotes.txt').withWriter('utf-8'){

        writer -> 
            dir.eachFileRecurse(FileType.ANY){ file ->
                if(file.isDirectory()){
                    writer.writeLine(file.name);
                }else{
                    writer.writeLine('\t' + file.name + '\t' + file.length());
                }
            }
    }
    
    def date = new Date()
    def sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
    echo "Date and Time IS: " + sdf.format(date)
    
    if(config.changes != "false"){
        echo "changes";
    }
}
