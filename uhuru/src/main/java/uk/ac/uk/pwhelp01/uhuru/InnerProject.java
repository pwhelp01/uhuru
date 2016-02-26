/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uk.pwhelp01.uhuru;

import java.io.PrintStream;
import org.apache.maven.cli.MavenCli;

/**
 *
 * @author pete
 */
public class InnerProject {
    
    MavenCli cli;
    String[] args;
    String workingDirectory;
    PrintStream stdout;
    PrintStream stderr;
    
    public InnerProject(String[] argsIn, String workingDirectoryIn) {
        
        // Create a new instance of the Maven Command Line Interface (CLI)
        this.cli = new MavenCli();
        
        // Set object properties based on input parameters
        this.args = argsIn;
        this.workingDirectory = workingDirectoryIn;
        
        // Set stdout and stderr to System.out
        this.stdout = System.out;
        this.stderr = System.err;
        
    }
    
    
    public void build() throws Exception {
        
        // Build inner project
        int result = cli.doMain(this.args, this.workingDirectory, this.stdout, this.stderr);
        
        // Check if build failed (return value other than 0) and raise error if it did
        if(result != 0) {
            throw new Exception("Maven build failed with error code: " + result);
        }

    }
}
